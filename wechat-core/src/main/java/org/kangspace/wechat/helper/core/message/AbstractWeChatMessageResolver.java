package org.kangspace.wechat.helper.core.message;

import org.kangspace.wechat.helper.core.WeChatService;
import org.kangspace.wechat.helper.core.message.response.WeChatEchoMessage;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 消息处理器抽象类
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/24
 */
public abstract class AbstractWeChatMessageResolver<Service extends WeChatService,
        Message extends WeChatMessage,
        EchoMessage extends WeChatEchoMessage>
        implements WeChatMessageResolver<Service, Message, EchoMessage> {

    private final Service wechatService;

    /**
     * 消息处理器
     */
    private final List<WeChatMessageHandler<Service, ?, EchoMessage>> weChatMessageHandlers;

    public AbstractWeChatMessageResolver(Service wechatService) {
        this(wechatService, new ArrayList<>());
    }

    public AbstractWeChatMessageResolver(Service wechatService, List<WeChatMessageHandler<Service, ?, EchoMessage>> weChatMessageHandlers) {
        this.wechatService = wechatService;
        this.weChatMessageHandlers = weChatMessageHandlers;
    }

    public AbstractWeChatMessageResolver(Service wechatService, Collection<? extends WeChatMessageHandler<Service, ?, EchoMessage>> weChatMessageHandlers) {
        this.wechatService = wechatService;
        this.weChatMessageHandlers = new ArrayList<>();
        this.weChatMessageHandlers.addAll(weChatMessageHandlers);
    }

    @Override
    public List<? extends WeChatMessageHandler<Service, ?, EchoMessage>> getWeChatHandlers() {
        return this.weChatMessageHandlers;
    }

    @Override
    public List<? extends WeChatMessageHandler<Service, ?, EchoMessage>> getWeChatHandlers(Message message) {
        return getWeChatHandlers().stream().filter(t -> t.supportType().isAssignableFrom(message.getClass())).sorted().collect(Collectors.toList());
    }

    @SuppressWarnings("unchecked")
    @Override
    public <Handle extends WeChatMessageHandler<Service, ?, EchoMessage>,
            Resolver extends WeChatMessageResolver<Service, Message, EchoMessage>> Resolver addWeChatHandler(Handle messageHandler) {
        this.weChatMessageHandlers.add(messageHandler);
        return (Resolver) this;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <Handle extends WeChatMessageHandler<Service, ?, EchoMessage>,
            Resolver extends WeChatMessageResolver<Service, Message, EchoMessage>> Resolver addWeChatHandlers(Collection<? extends Handle> messageHandlers) {
        this.weChatMessageHandlers.addAll(messageHandlers);
        return (Resolver) this;
    }

    @Override
    public Service getWeChatService() {
        return this.wechatService;
    }
}
