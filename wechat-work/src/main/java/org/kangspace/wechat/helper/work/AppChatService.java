package org.kangspace.wechat.helper.work;

import org.kangspace.wechat.helper.work.bean.*;
import org.kangspace.wechat.helper.work.bean.appchat.*;

import javax.annotation.Nonnull;

/**
 * 企业微信"应用发送消息到群聊会话"相关 Service <br>
 * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/90245">https://developer.work.weixin.qq.com/document/path/90245</a> <br>
 * @author kango2gler@gmail.com
 * @since 2023/08/14
 */
public interface AppChatService extends WeComService {
    /**
     * 应用发送消息到群聊会话-创建群聊会话
     * @param request {@link AppChatCreateRequest}
     * @return {@link AppChatCreateResponse}
     */
    AppChatCreateResponse appChatCreate(@Nonnull AppChatCreateRequest request);

    /**
     * 应用发送消息到群聊会话-更新群聊会话
     * @param request {@link AppChatUpdateRequest}
     * @return {@link WeComResponseEntity}
     */
    WeComResponseEntity appChatUpdate(@Nonnull AppChatUpdateRequest request);

    /**
     * 应用发送消息到群聊会话-获取群聊会话
     * @param chatId 会话ID
     * @return {@link AppChatGetResponse}
     */
    AppChatGetResponse appChatGet(@Nonnull String chatId);

    /**
     * 应用发送消息到群聊会话-应用推送消息
     * @param message 消息
     * @return {@link AppChatGetResponse}
     * @see TextMessage
     * @see ImageMessage
     * @see VoiceMessage
     * @see VideoMessage
     * @see FileMessage
     * @see NewsMessage
     * @see MpNewsMessage
     * @see MarkdownMessage
     */
    WeComResponseEntity appChatSend(@Nonnull AppChatMessage message);
}
