package org.kangspace.wechat.helper.core.message;

/**
 * 微信加密消息接口<br>
 * 接口文档: <a href="https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/2.0/api/Before_Develop/Message_encryption_and_decryption.html">https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/2.0/api/Before_Develop/Message_encryption_and_decryption.html</a>
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/12
 */
public interface WeChatEncryptMessage extends WeChatMessage {
    /**
     * 获取原始加密消息内容
     *
     * @return 原始加密消息内容
     */
    String getEncrypt();

    /**
     * 设置加密消息
     *
     * @param encrypt 已经加密的消息内容
     */
    void setEncrypt(String encrypt);
}
