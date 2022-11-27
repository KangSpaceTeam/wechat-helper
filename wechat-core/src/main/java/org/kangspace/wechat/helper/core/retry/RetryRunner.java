package org.kangspace.wechat.helper.core.retry;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 重试器
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/26
 */
@Slf4j
public class RetryRunner {

    /**
     * 执行需要重试的方法
     *
     * @param execute        需要执行的方法
     * @param maxRetryCount  最大重试次数
     * @param retryPredicate 重试条件
     * @return T
     */
    public static <T> T run(Supplier<T> execute, int maxRetryCount, Predicate<Exception> retryPredicate) {
        int retryCount = 0;
        do {
            try {
                return execute.get();
            } catch (Exception e) {
                if (!retryPredicate.test(e)) {
                    throw e;
                }
                int currRetryCount = retryCount + 1;
                if (currRetryCount > maxRetryCount) {
                    throw e;
                }
                log.debug("run retry: maxRetryCount: {}, currRetryCount: {}", maxRetryCount, currRetryCount);
            }
        } while (retryCount++ < maxRetryCount);
        return null;
    }
}
