package org.kangspace.wechat.helper.core.message;

import lombok.Data;
import org.kangspace.wechat.helper.core.config.WeChatConfig;
import org.kangspace.wechat.helper.core.exception.WeChatSignatureException;
import org.kangspace.wechat.helper.core.util.DigestUtil;
import org.kangspace.wechat.helper.core.util.XmlParser;

import javax.annotation.Nonnull;
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
public class MessageDecrypt {

    /**
     * 微信Token
     */
    private final WeChatConfig weChatConfig;

    public MessageDecrypt(@Nonnull WeChatConfig weChatConfig) {
        this.weChatConfig = weChatConfig;
    }

    /**
     * 消息解码
     *
     * @param messageSignature 消息签名
     * @param rawMessage       原始消息内容
     * @return 解码后的消息
     */
    public <T extends WeChatEncryptMessage> String decrypt(@Nonnull MessageSignature messageSignature, @Nonnull String rawMessage, Class<T> encryptMessageClass) {

        T message = XmlParser.parse(rawMessage, encryptMessageClass);
        checkSignature(messageSignature, message.getEncrypt());
        // TODO xxx
        return null;
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
     * @throws org.kangspace.wechat.helper.core.exception.WeChatSignatureException
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
    public String decrypt(String msgEncrypt) {
        byte[] messageBytes = Base64.getDecoder().decode(msgEncrypt);
        String aesKey = getEncodingAESKey();
        // TODO xx
    }

    /**
     * 公众号第三方平台的 EncodingAESKey,
     * 长度固定为 43 个字符，从 a-z,A-Z,0-9 共 62 个字符中选取
     */
    public String getEncodingAESKey() {
        return Objects.requireNonNull(this.getWeChatConfig().getEncodingAESKey(), "encodingAESKey must be not null! 需在WeChatConfig中设置!");
    }

    /**
     * 微信Token
     */
    public String getToken() {
        return Objects.requireNonNull(this.getWeChatConfig().getToken(), "token must be not null! 需在WeChatConfig中设置");
    }
}
