package org.kangspace.wechat.helper.mp.message;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.kangspace.wechat.helper.core.message.MessageCipher;
import org.kangspace.wechat.helper.core.message.MessageSignature;
import org.kangspace.wechat.helper.mp.WeChatMpAppConstant;
import org.kangspace.wechat.helper.mp.config.WeChatMpConfig;
import org.kangspace.wechat.helper.mp.message.response.WeChatMpEncryptEchoXmlMessage;

/**
 * 消息加解密测试
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/28
 */
@Slf4j
@RunWith(JUnit4.class)
public class MessageCipherTest {
    private final String appId = WeChatMpAppConstant.GLOBAL_APPID;
    private final String appSecret = WeChatMpAppConstant.GLOBAL_APPSECRET;
    private final String token = WeChatMpAppConstant.GLOBAL_TOKEN;
    private final String encodingAesKey = WeChatMpAppConstant.GLOBAL_ENCODING_AES_KEY;
    private MessageCipher messageCipher;

    @Before
    public void before() {
        boolean isEncrypt = true;
        WeChatMpConfig weChatMpConfig = new WeChatMpConfig(appId, appSecret);
        weChatMpConfig.setToken(token);
        weChatMpConfig.setEncodingAESKey(encodingAesKey);
        messageCipher = new MessageCipher(weChatMpConfig);
    }

    /**
     * 解密测试<br>
     * url: signature=4531152dfaa32d83bda1451595b434eedbaee8c6&timestamp=1672062037&nonce=924856700&openid=oMIE-6T2iTOgEdERSg26CU0KL8Og&encrypt_type=aes&msg_signature=3fae3477f04d2805bb2f647d67f98ead14fc5f6e
     */
    @Test
    public void decryptTest() {
        String rawMessage = "<xml>\n" +
                "    <ToUserName><![CDATA[gh_84671c4da479]]></ToUserName>\n" +
                "    <FromUserName><![CDATA[oMIE-6T2iTOgEdERSg26CU0KL8Og]]></FromUserName>\n" +
                "    <CreateTime>1672062036</CreateTime>\n" +
                "    <MsgType><![CDATA[text]]></MsgType>\n" +
                "    <Content><![CDATA[1]]></Content>\n" +
                "    <MsgId>23938173794149768</MsgId>\n" +
                "    <Encrypt><![CDATA[tybon2345ToFXFumMtSoJ0i6F5PGT6BIJudVM+TIkPjfR9o9hrsyVa7yGcWIBpeaK57/mDXfYSNSgjmzfk5AecAMvDb7blMwc1wNEGwvOsh7LkfX+8jT/8SyQ3o5BvUi/0maQBtuQQ9L5REk829Oj0zpXsxwaCEX2kQrJ3AMA7/wwom+u9UXstEQzIbMyC20zxlx9/kzGQEqmME3xhBhBvBH5TCQO7foUMTb+7xZNNbzraBMWwsz+orXNvNMliqiAPcJIRJBeh7OCwi5wssrO2ujtiTrG5uln0/0uNBaIWTKSR7yI1Ddnfd4c7gR1Q2N/Uyz0+TRGDeJsnd/jB5Qn6Ur10eAEyxL+uwHbjXemMntHRHad3CtsD2+3wV3VQL4jBC6bCYJp9TrEiCsYn/eqrSceDLWu54li8iN+RS7B4U=]]></Encrypt>\n" +
                "</xml>";
        String signature = "4531152dfaa32d83bda1451595b434eedbaee8c6";
        String timestamp = "1672062037";
        String nonce = "924856700";
        String encryptType = "aes";
        String msgSignature = "3fae3477f04d2805bb2f647d67f98ead14fc5f6e";
        log.info("raw: {}", rawMessage);
        MessageSignature messageSignature = new MessageSignature(signature, timestamp, nonce, encryptType, msgSignature);
        String message = messageCipher.decrypt(messageSignature, rawMessage, WeChatMpEncryptXmlMessage.class);
        log.info("{}", message);
        Assert.assertNotNull(message);
    }

    /**
     * 加密测试
     */
    @Test
    public void encryptTest() {
        String rawMessage = "<xml>\n" +
                "    <ToUserName><![CDATA[gh_84671c4da479]]></ToUserName>\n" +
                "    <FromUserName><![CDATA[oMIE-6T2iTOgEdERSg26CU0KL8Og]]></FromUserName>\n" +
                "    <CreateTime>1672062036</CreateTime>\n" +
                "    <MsgType><![CDATA[text]]></MsgType>\n" +
                "    <Content><![CDATA[1]]></Content>\n" +
                "    <MsgId>23938173794149768</MsgId>\n" +
                "</xml>";
        log.info("rawMessage: {}", rawMessage);
        String timestamp = "1672062037";
        String nonce = "924856700";
        String encryptType = "aes";
        String exceptEncryptMessage = "<Encrypt><![CDATA[tybon2345ToFXFumMtSoJ0i6F5PGT6BIJudVM+TIkPjfR9o9hrsyVa7yGcWIBpeaK57/mDXfYSNSgjmzfk5AecAMvDb7blMwc1wNEGwvOsh7LkfX+8jT/8SyQ3o5BvUi/0maQBtuQQ9L5REk829Oj0zpXsxwaCEX2kQrJ3AMA7/wwom+u9UXstEQzIbMyC20zxlx9/kzGQEqmME3xhBhBvBH5TCQO7foUMTb+7xZNNbzraBMWwsz+orXNvNMliqiAPcJIRJBeh7OCwi5wssrO2ujtiTrG5uln0/0uNBaIWTKSR7yI1Ddnfd4c7gR1Q2N/Uyz0+TRGDeJsnd/jB5Qn6Ur10eAEyxL+uwHbjXemMntHRHad3CtsD2+3wV3VQL4jBC6bCYJp9TrEiCsYn/eqrSceDLWu54li8iN+RS7B4U=]]></Encrypt>";
        MessageSignature messageSignature = new MessageSignature(timestamp, nonce, encryptType);
        String encrypt = messageCipher.encrypt(messageSignature, rawMessage, WeChatMpEncryptEchoXmlMessage.class);
        log.info("{}", encrypt);
        Assert.assertTrue(encrypt != null && encrypt.contains(exceptEncryptMessage));
    }
}
