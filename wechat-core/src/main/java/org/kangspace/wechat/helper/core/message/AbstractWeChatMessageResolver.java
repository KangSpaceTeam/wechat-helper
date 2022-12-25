package org.kangspace.wechat.helper.core.message;

import org.kangspace.wechat.helper.core.WeChatService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 消息处理器抽象类
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/24
 */
public abstract class AbstractWeChatMessageResolver<Service extends WeChatService, Handler extends WeChatMessageHandler<Service, Message>, Message extends WeChatMessage> implements WeChatMessageResolver<Service, Handler, Message> {
    private final Service wechatService;
    /**
     * 事件处理器
     */
    private final List<Handler> weChatMessageHandlers;

    public AbstractWeChatMessageResolver(Service wechatService) {
        this(wechatService, new ArrayList<>());
    }

    public AbstractWeChatMessageResolver(Service wechatService, List<Handler> weChatMessageHandlers) {
        this.wechatService = wechatService;
        this.weChatMessageHandlers = weChatMessageHandlers;
    }

    @Override
    public List<Handler> getWeChatHandlers() {
        return this.weChatMessageHandlers;
    }

    @Override
    public List<Handler> getWeChatHandlers(Message message) {
        return getWeChatHandlers().stream().filter(t -> t.supportType().isAssignableFrom(message.getClass())).sorted().collect(Collectors.toList());
    }

    @Override
    public void addWeChatHandler(Handler messageHandler) {
        this.weChatMessageHandlers.add(messageHandler);
    }

    @Override
    public Service getWeChatService() {
        return this.wechatService;
    }
}