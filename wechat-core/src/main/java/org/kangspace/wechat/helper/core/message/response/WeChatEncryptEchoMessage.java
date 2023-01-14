package org.kangspace.wechat.helper.core.message.response;

/**
 * 微信响应加密消息<br>
 * 接口文档: <a href="https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/2.0/api/Before_Develop/Message_encryption_and_decryption.html">https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/2.0/api/Before_Develop/Message_encryption_and_decryption.html</a>
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/29
 */
public interface WeChatEncryptEchoMessage extends WeChatEchoMessage{
    /**
     * 获取加密数据
     *
     * @return 加密数据(Base64)
     */
    String getEncrypt();

    /**
     * 设置加密数据
     *
     * @param encrypt encrypt
     */
    void setEncrypt(String encrypt);

    /**
     * 获取消息签名
     *
     * @return 消息签名
     */
    String getMsgSignature();

    /**
     * 设置消息签名
     *
     * @param msgSignature msgSignature
     */
    void setMsgSignature(String msgSignature);

    /**
     * 获取时间戳
     *
     * @return 时间戳
     */
    String getTimestamp();

    /**
     * 获取时间戳
     *
     * @param timestamp timestamp
     */
    void setTimestamp(String timestamp);

    /**
     * 获取随机数
     *
     * @return 随机数
     */
    String getNonce();

    /**
     * 获取随机数
     *
     * @param nonce nonce
     */
    void setNonce(String nonce);
}
