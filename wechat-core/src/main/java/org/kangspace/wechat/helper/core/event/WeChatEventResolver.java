package org.kangspace.wechat.helper.core.event;

import org.kangspace.wechat.helper.core.WeChatService;
import org.kangspace.wechat.helper.core.message.BaseMessageSignature;
import org.kangspace.wechat.helper.core.message.GetMessageSignature;
import org.kangspace.wechat.helper.core.message.WeChatMessageResolver;
import org.kangspace.wechat.helper.core.message.response.WeChatEchoMessage;

import java.util.List;

/**
 * 微信事件解析器, 同微信消息解析器
 *
 * @author kango2gler@gmail.com
 * @see WeChatMessageResolver
 * @since 2022/12/24
 */
public interface WeChatEventResolver<Service extends WeChatService, Handler extends WeChatEventHandler<Service, Event, EchoMessage>, Event extends WeChatEvent, EchoMessage extends WeChatEchoMessage> extends WeChatMessageResolver<Service, Handler, Event, EchoMessage> {

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
    WeChatEventResolver addWeChatHandler(Handler eventHandler);

    /**
     * EventResolver不支持该方法
     *
     * @param signature {@link GetMessageSignature}
     * @return empty
     */
    @Override
    default boolean checkSignature(BaseMessageSignature signature) {
        throw new UnsupportedOperationException("EventResolver不支持该方法!");
    }
}
