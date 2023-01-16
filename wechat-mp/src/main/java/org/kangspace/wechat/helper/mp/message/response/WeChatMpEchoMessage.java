package org.kangspace.wechat.helper.mp.message.response;

import org.kangspace.wechat.helper.core.message.response.WeChatEchoMessage;

import static org.kangspace.wechat.helper.core.constant.WeChatConstant.SUCCESS_FLAG;

/**
 * 微信公众号响应消息
 * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Passive_user_reply_message.html">https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Passive_user_reply_message.html</a>
 * <pre>
 * 假如服务器无法保证在五秒内处理并回复，必须做出下述回复，这样微信服务器才不会对此作任何处理，并且不会发起重试（这种情况下，可以使用客服消息接口进行异步回复），否则，将出现严重的错误提示。详见下面说明：
 * 1、直接回复success（推荐方式） 2、直接回复空串（指字节长度为0的空字符串，而不是 XML 结构体中 content 字段的内容为空）
 * 一旦遇到以下情况，微信都会在公众号会话中，向用户下发系统提示“该公众号暂时无法提供服务，请稍后再试”：
 * 1、开发者在5秒内未回复任何内容 2、开发者回复了异常数据，比如 JSON 数据等
 * 另外，请注意，回复图片（不支持 gif 动图）等多媒体消息时需要预先通过素材管理接口上传临时素材到微信服务器，可以使用素材管理中的临时素材，也可以使用永久素材。
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/29
 */
public interface WeChatMpEchoMessage extends WeChatEchoMessage {
    /**
     * 输出success
     */
    String ECHO_SUCCESS = SUCCESS_FLAG;

    /**
     * 回复{@link #ECHO_SUCCESS}
     *
     * @return {@value ECHO_SUCCESS}
     */
    static String echoSuccess() {
        return ECHO_SUCCESS;
    }

    /**
     * 回复空字符串
     *
     * @return 空字符串
     */
    static String echo() {
        return "";
    }
}
