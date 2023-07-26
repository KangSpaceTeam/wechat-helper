package org.kangspace.wechat.helper.work.message.response;

import org.kangspace.wechat.helper.core.message.response.WeChatEchoMessage;

import static org.kangspace.wechat.helper.core.constant.WeChatConstant.SUCCESS_FLAG;

/**
 * 企业微信回调响应消息
 * // TODO
 * 接口文档: <a href=""></a>
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/25
 */
public interface WeComEchoMessage extends WeChatEchoMessage {
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
