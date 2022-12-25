package org.kangspace.wechat.helper.core.event;

import org.kangspace.wechat.helper.core.WeChatService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 事件处理器抽象类
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/24
 */
public abstract class AbstractWeChatEventResolver<Service extends WeChatService, Handler extends WeChatEventHandler<Service, Event>, Event extends WeChatEvent> implements WeChatEventResolver<Service, Handler, Event> {
    private final Service wechatService;
    /**
     * 事件处理器
     */
    private final List<Handler> weChatEventHandlers;

    public AbstractWeChatEventResolver(Service wechatService) {
        this(wechatService, new ArrayList<>());
    }

    public AbstractWeChatEventResolver(Service wechatService, List<Handler> weChatEventHandlers) {
        this.wechatService = wechatService;
        this.weChatEventHandlers = weChatEventHandlers;
    }

    @Override
    public List<Handler> getWeChatHandlers() {
        return this.weChatEventHandlers;
    }

    @Override
    public List<Handler> getWeChatHandlers(Event event) {
        return getWeChatHandlers().stream().filter(t -> t.supportType().isAssignableFrom(event.getClass())).sorted().collect(Collectors.toList());
    }

    @Override
    public void addWeChatHandler(Handler eventHandler) {
        this.weChatEventHandlers.add(eventHandler);
    }

    @Override
    public Service getWeChatService() {
        return this.wechatService;
    }
}