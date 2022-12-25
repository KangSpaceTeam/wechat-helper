package org.kangspace.wechat.helper.core.event;

import org.kangspace.wechat.helper.core.WeChatService;
import org.kangspace.wechat.helper.core.message.MessageSignature;
import org.kangspace.wechat.helper.core.message.WeChatMessageResolver;

import java.util.List;

/**
 * 微信事件解析器
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/24
 */
public interface WeChatEventResolver<Service extends WeChatService, Handler extends WeChatEventHandler<Service, Event>, Event extends WeChatEvent> extends WeChatMessageResolver<Service, Handler, Event> {

    /**
     * 获取所有订阅的事件处理器
     *
     * @return {@link List}&lt;{@link Handler}&gt;
     */
    @Override
    List<Handler> getWeChatHandlers();

    /**
     * 根据{@link Event}获取事件处理器列表
     *
     * @param event {@link Event}
     * @return {@link List}&lt;{@link Handler}&gt;
     */
    @Override
    List<Handler> getWeChatHandlers(Event event);

    /**
     * 添加事件处理器
     *
     * @param eventHandler {@link Handler}
     */
    @Override
    void addWeChatHandler(Handler eventHandler);

    /**
     * EventResolver不支持该方法
     *
     * @param signature {@link MessageSignature}
     * @return empty
     */
    @Override
    default String checkSignature(MessageSignature signature) {
        throw new IllegalStateException("EventResolver不支持该方法!");
    }
}
