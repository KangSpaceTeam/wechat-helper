package org.kangspace.wechat.helper.core.message;

import org.kangspace.wechat.helper.core.WeChatService;

import java.util.List;

/**
 * 微信消息解析器
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/24
 */
public interface WeChatMessageResolver<Service extends WeChatService, Handler extends WeChatMessageHandler<Service, Message>, Message extends WeChatMessage> {

    /**
     * 获取所有消息的事件处理器
     *
     * @return {@link List}&lt;{@link Handler}&gt;
     */
    List<Handler> getWeChatHandlers();

    /**
     * 根据{@link Message}获取事件处理器列表
     *
     * @param Message {@link Message}
     * @return {@link List}&lt;{@link Handler}&gt;
     */
    List<Handler> getWeChatHandlers(Message Message);

    /**
     * 添加事件处理器
     *
     * @param messageHandler {@link Handler}
     */
    void addWeChatHandler(Handler messageHandler);

    /**
     * 获取WeChatService
     *
     * @return {@link Service}
     */
    Service getWeChatService();

    /**
     * 签名检查
     *
     * @param signature {@link BaseMessageSignature}
     * @return String
     */
    String checkSignature(GetMessageSignature signature);

    /**
     * 处理消息
     *
     * @param messageFormat    消息类型{@link MessageFormat}
     * @param messageSignature {@link MessageSignature}
     * @param message          消息
     */
    void resolve(MessageFormat messageFormat, MessageSignature messageSignature, String message);

    /**
     * 处理消息(默认XML消息)
     *
     * @param messageSignature {@link MessageSignature}
     * @param message          消息
     */
    default void resolve(MessageSignature messageSignature, String message) {
        this.resolve(MessageFormat.XML, messageSignature, message);
    }
}
