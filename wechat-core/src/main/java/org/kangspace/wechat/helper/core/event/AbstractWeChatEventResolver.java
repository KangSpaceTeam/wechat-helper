package org.kangspace.wechat.helper.core.event;

import org.kangspace.wechat.helper.core.WeChatService;
import org.kangspace.wechat.helper.core.message.BaseMessageSignature;
import org.kangspace.wechat.helper.core.message.WeChatMessageHandler;
import org.kangspace.wechat.helper.core.message.response.WeChatEchoMessage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 事件处理器抽象类
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/24
 */
public abstract class AbstractWeChatEventResolver<Service extends WeChatService,
        Event extends WeChatEvent, EchoMessage extends WeChatEchoMessage>
        implements WeChatEventResolver<Service, Event, EchoMessage> {

    private final Service wechatService;

    /**
     * 事件处理器
     */
    private final List<WeChatEventHandler<Service, ?, EchoMessage>> weChatEventHandlers;


    public AbstractWeChatEventResolver(Service wechatService) {
        this(wechatService, new ArrayList<>());
    }

    public AbstractWeChatEventResolver(Service wechatService, List<WeChatEventHandler<Service, ?, EchoMessage>> weChatEventHandlers) {
        this.wechatService = wechatService;
        this.weChatEventHandlers = weChatEventHandlers;
    }

    public AbstractWeChatEventResolver(Service wechatService, Collection<? extends WeChatEventHandler<Service, ?, EchoMessage>> weChatEventHandlers) {
        this.wechatService = wechatService;
        this.weChatEventHandlers = new ArrayList<>();
        this.weChatEventHandlers.addAll(weChatEventHandlers);
    }

    @Override
    public List<? extends WeChatMessageHandler<Service, ?, EchoMessage>> getWeChatHandlers() {
        return this.weChatEventHandlers;
    }

    @Override
    public boolean checkSignature(BaseMessageSignature signature) {
        return false;
    }


    @Override
    public Service getWeChatService() {
        return this.wechatService;
    }
}
