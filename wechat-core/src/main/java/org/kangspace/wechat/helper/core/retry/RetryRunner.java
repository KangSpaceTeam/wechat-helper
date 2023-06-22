package org.kangspace.wechat.helper.core.retry;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.util.function.Function;
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
                log.debug("retryRunner run retry: maxRetryCount: {}, currRetryCount: {}", maxRetryCount, currRetryCount);
            }
        } while (retryCount++ < maxRetryCount);
        return null;
    }

    /**
     * 执行需要重试的方法(基于方法返回值Mono)
     *
     * @param execute        需要执行的方法,参数为重试标记
     * @param maxRetryCount  最大重试次数
     * @param retryPredicate 重试条件
     * @return T
     */
    public static <T> Mono<T> run(Function<Boolean, Mono<T>> execute, int maxRetryCount, Predicate<T> retryPredicate) {
        int retryCount = 0;
        Mono<T> resultMono;
        do {
            Mono<T> runWithResult = execute.apply(retryCount > 0);
            T runWithResultData = runWithResult.block();
            resultMono = runWithResultData != null ? Mono.just(runWithResultData) : Mono.empty();
            if (!retryPredicate.test(runWithResultData)) {
                return resultMono;
            }
            int currRetryCount = retryCount + 1;
            if (currRetryCount > maxRetryCount) {
                return resultMono;
            }
            log.debug("retryRunner run runWithMonoResult: maxRetryCount: {}, currRetryCount: {}", maxRetryCount, currRetryCount);
        } while (retryCount++ < maxRetryCount);
        return resultMono;
    }
}
