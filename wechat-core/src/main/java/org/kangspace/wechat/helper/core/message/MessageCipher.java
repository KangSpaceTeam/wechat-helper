package org.kangspace.wechat.helper.core.message;

import lombok.Data;
import org.kangspace.wechat.helper.core.config.WeChatConfig;
import org.kangspace.wechat.helper.core.exception.WeChatSignatureException;
import org.kangspace.wechat.helper.core.message.response.WeChatEncryptEchoMessage;
import org.kangspace.wechat.helper.core.util.ByteGroup;
import org.kangspace.wechat.helper.core.util.DigestUtil;
import org.kangspace.wechat.helper.core.util.ReflectUtil;
import org.kangspace.wechat.helper.core.util.XmlParser;

import javax.annotation.Nonnull;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.Objects;

/**
 * 消息解码器<br>
 * 文档: <a href="https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/2.0/api/Before_Develop/Technical_Plan.html">https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/2.0/api/Before_Develop/Technical_Plan.html</a><br>
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/26
 */
@Data
public class MessageCipher {
    /**
     * 编解码CharSet
     */
    private final static Charset CHARSET = StandardCharsets.UTF_8;
    /**
     * 微信Token
     */
    private final WeChatConfig weChatConfig;

    public MessageCipher(@Nonnull WeChatConfig weChatConfig) {
        this.weChatConfig = weChatConfig;
    }

    /**
     * 消息解码
     *
     * @param messageSignature    消息签名
     * @param rawMessage          原始消息内容
     * @param encryptMessageClass 加密消息处理类
     * @return 解码后的消息
     */
    public <T extends WeChatEncryptMessage> String decrypt(@Nonnull MessageSignature messageSignature, @Nonnull String rawMessage, @Nonnull Class<T> encryptMessageClass) {
        // 转换为加密消息接收类
        T message = XmlParser.parse(rawMessage, encryptMessageClass);
        // 检查签名
        checkSignature(messageSignature, message.getEncrypt());
        // 解密
        return decrypt(message.getEncrypt());
    }

    /**
     * 签名校验
     * <pre>
     * 验证方式：
     * 1. 开发者计算签名，dev_msg_signature=sha1(sort(Token、timestamp、nonce, msg_encrypt))
     * 2. 比较dev_msg_signature和 URL 上带的msg_signature是否相等，相等则表示验证通过。
     * </pre>
     *
     * @param messageSignature 签名参数
     * @param msgEncrypt       加密的消息
     */
    public void checkSignature(@Nonnull MessageSignature messageSignature, @Nonnull String msgEncrypt) {
        String token = getToken();
        String timestamp = Objects.requireNonNull(messageSignature.getTimestamp(), "timestamp must be not null");
        String nonce = Objects.requireNonNull(messageSignature.getNonce(), "nonce must be not null");
        String msgSignature = Objects.requireNonNull(messageSignature.getMsgSignature(), "msgSignature must be not null");
        String calcMsgSignature = DigestUtil.sha1(token, timestamp, nonce, msgEncrypt);
        if (!msgSignature.equals(calcMsgSignature)) {
            throw new WeChatSignatureException(calcMsgSignature, "msg_signature check failed!");
        }
    }

    /**
     * 消息解码
     * <pre>
     * 解密方式如下：
     * 1. TmpMsg = Base64_Decode(msg_encrypt)
     * 2. FullStr = AES_Decrypt(TmpMsg, AESKey);  FullStr 如前所述由4部分组成（random, msg_len, msg, appid）
     * 3. 验证尾部的appid 是否正确（可选）
     * 4. 去掉 FullStr 头部16字节的random、4字节的msg_len、和尾部的appid，即得到明文内容
     * </pre>
     *
     * @param msgEncrypt 加密的消息
     * @return 解码的消息
     */
    public String decrypt(@Nonnull String msgEncrypt) {
        byte[] msgBytes;
        byte[] appId;
        try {
            byte[] messageBytes = Base64.getDecoder().decode(msgEncrypt);
            byte[] aesKey = DigestUtil.extractAESKey(getEncodingAESKey());
            byte[] fullBytes = DigestUtil.deAesCBCWithPKCS7(messageBytes, aesKey);
            int fromIdx = 16;
            // 获取 msgLength
            byte[] messageLengthBytes = Arrays.copyOfRange(fullBytes, fromIdx, (fromIdx += 4));
            int messageLength = ByteBuffer.wrap(messageLengthBytes).getInt();
            // 获取 msg
            msgBytes = Arrays.copyOfRange(fullBytes, fromIdx, (fromIdx += messageLength));
            // 获取 AppId
            appId = Arrays.copyOfRange(fullBytes, fromIdx, fullBytes.length);
        } catch (Exception e) {
            throw new WeChatSignatureException(msgEncrypt, "msgEncrypt decrypt failed: " + e.getMessage(), e);
        }
        // 验证AppId
        checkAppId(appId);
        // 返回解密消息内容
        return new String(msgBytes, CHARSET);
    }

    /**
     * 消息编码
     *
     * @param messageSignature    消息签名
     * @param message             消息内容
     * @param encryptMessageClass 加密消息处理类
     * @return 编码后的消息
     */
    public <T extends WeChatEncryptEchoMessage> String encrypt(@Nonnull MessageSignature messageSignature, @Nonnull String message, @Nonnull Class<T> encryptMessageClass) {
        // 原始消息加密
        String encodedMessage = encrypt(message);
        // 转换为加密消息类
        T encryptMessageObject = ReflectUtil.newInstance(encryptMessageClass);
        encryptMessageObject.setEncrypt(encodedMessage);
        // TODO xxx, 消息签名处理
        // 返回XML字符串
        return XmlParser.toXmlString(encryptMessageObject);
    }

    /**
     * 加密原始消息<br>
     * <pre>
     * 加密方式如下：
     * 1. AESKey = Base64_Decode(EncodingAESKey + "=");
     * 2. FullStr = random(16B) + msg_len(4B) + msg + appid;
     * 3. msg_encrypt = Base64_Encode( AES_Encrypt( FullStr, AESKey ) );
     * </pre>
     *
     * @param message 原始消息内容
     * @return 加密后的消息
     */
    public String encrypt(String message) {
        try {
            ByteGroup byteGroup = new ByteGroup();
            byte[] aesKey = DigestUtil.extractAESKey(getEncodingAESKey());
            byte[] randomStrBytes = DigestUtil.get16RandomStr().getBytes(CHARSET);
            byte[] messageBytes = message.getBytes(CHARSET);
            byte[] messageLengthBytes = ByteBuffer.allocate(4).putInt(messageBytes.length).array();
            byte[] appIdBytes = getAppId().getBytes(CHARSET);
            byteGroup.addBytes(randomStrBytes)
                    .addBytes(messageLengthBytes)
                    .addBytes(messageBytes)
                    .addBytes(appIdBytes);
            byte[] fullBytes = DigestUtil.aesCBCWithPKCS7(byteGroup, aesKey);
            return Base64.getEncoder().encodeToString(fullBytes);
        } catch (Exception e) {
            throw new WeChatSignatureException(message, "encrypt message failed: " + e.getMessage(), e);
        }
    }

    /**
     * 检查签名中的AppId
     *
     * @param appId appId
     */
    public void checkAppId(byte[] appId) {
        String appIdStr = new String(appId, CHARSET);
        if (!appIdStr.equals(getWeChatConfig().getAppId())) {
            throw new WeChatSignatureException(appIdStr, "appId check failed!");
        }
    }

    /**
     * 公众号第三方平台的 EncodingAESKey,
     * 长度固定为 43 个字符，从 a-z,A-Z,0-9 共 62 个字符中选取
     *
     * @return EncodingAESKey
     */
    public String getEncodingAESKey() {
        return Objects.requireNonNull(this.getWeChatConfig().getEncodingAESKey(), "encodingAESKey must be not null! 需在WeChatConfig中设置!");
    }

    /**
     * 微信Token
     *
     * @return token
     */
    public String getToken() {
        return Objects.requireNonNull(this.getWeChatConfig().getToken(), "token must be not null! 需在WeChatConfig中设置");
    }

    /**
     * 微信AppId
     *
     * @return appId
     */
    public String getAppId() {
        return Objects.requireNonNull(this.getWeChatConfig().getAppId(), "appId must be not null! 需在WeChatConfig中设置");
    }
}
