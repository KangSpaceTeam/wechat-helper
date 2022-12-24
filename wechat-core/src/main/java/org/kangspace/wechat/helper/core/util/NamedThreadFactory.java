package org.kangspace.wechat.helper.core.util;

import javax.annotation.Nonnull;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义名称的线程工厂
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/24
 */
public class NamedThreadFactory implements ThreadFactory {
    /**
     * 默认线程名前缀
     */
    public final static String DEFAULT_THREAD_NAME_PREFIX = "NamedThread-";
    /**
     * 线程计数器
     */
    private final AtomicInteger counter = new AtomicInteger();
    /**
     * 线程名前缀
     */
    private final String threadNamePrefix;

    public NamedThreadFactory() {
        this(DEFAULT_THREAD_NAME_PREFIX);
    }

    public NamedThreadFactory(String threadNamePrefix) {
        this.threadNamePrefix = threadNamePrefix;
    }

    @Override
    public Thread newThread(@Nonnull Runnable r) {
        return new Thread(r, getThreadName());
    }

    private String getThreadName() {
        return threadNamePrefix != null ? threadNamePrefix : "" + counter.incrementAndGet();
    }
}
