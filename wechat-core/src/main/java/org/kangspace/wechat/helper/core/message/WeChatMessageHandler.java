package org.kangspace.wechat.helper.core.message;

import org.kangspace.wechat.helper.core.WeChatService;
import org.kangspace.wechat.helper.core.message.response.WeChatEchoMessage;
import org.kangspace.wechat.helper.core.util.NamedThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 微信消息处理器<br>
 * 注意: 需重写{@link #execute(WeChatService, WeChatMessage, MessageResolverContext)} 或 {@link #handle(WeChatService, WeChatMessage, MessageResolverContext)}方法
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/12
 */
public interface WeChatMessageHandler<Service extends WeChatService, Message extends WeChatMessage, EchoMessage extends WeChatEchoMessage>
        extends Comparable<WeChatMessageHandler<Service, Message, EchoMessage>> {
    /**
     * 线程池线程名称前缀
     */
    String EXECUTOR_THREAD_NAME_PREFIX = "WeChatMessageHandlerThread-";

    /**
     * 处理消息
     *
     * @param service       {@link WeChatService}
     * @param weChatMessage {@link WeChatMessage}
     * @param context       {@link MessageResolverContext} 消息处理上下文对象
     * @return {@link WeChatEchoMessage}
     */
    default EchoMessage handle(Service service, Message weChatMessage, MessageResolverContext context) {
        this.execute(service, weChatMessage, context);
        return null;
    }

    /**
     * 处理消息(无返回值)
     *
     * @param service       {@link WeChatService}
     * @param weChatMessage {@link WeChatMessage}
     * @param context       {@link MessageResolverContext} 消息处理上下文对象
     */
    default void execute(WeChatService service, WeChatMessage weChatMessage, MessageResolverContext context) {
        throw new UnsupportedOperationException("need implements execute or handle method!");
    }

    /**
     * 支持的类型
     *
     * @return {@link Class}&lt;{@link WeChatMessage}&gt;
     */
    Class<? extends WeChatMessage> supportType();

    /**
     * 获取排序值
     *
     * @return 排序值
     */
    default Integer getOrder() {
        return Integer.MIN_VALUE;
    }

    /**
     * 排序比较
     *
     * @param o the object to be compared.
     * @return int
     */
    @Override
    default int compareTo(WeChatMessageHandler o) {
        return this.getOrder() - o.getOrder();
    }

    /**
     * 是否异步
     *
     * @return boolean
     */
    default boolean isAsync() {
        return false;
    }

    /**
     * 获取Executors
     *
     * @return {@link ExecutorService}
     */
    default ExecutorService getExecutor() {
        int processors = Runtime.getRuntime().availableProcessors();
        int nThreads = processors * 2;
        return new ThreadPoolExecutor(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(), new NamedThreadFactory(EXECUTOR_THREAD_NAME_PREFIX));
    }
}
