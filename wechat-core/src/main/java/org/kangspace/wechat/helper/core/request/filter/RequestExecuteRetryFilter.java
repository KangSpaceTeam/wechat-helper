package org.kangspace.wechat.helper.core.request.filter;

import io.netty.channel.ConnectTimeoutException;
import io.netty.handler.timeout.TimeoutException;
import lombok.extern.slf4j.Slf4j;
import org.kangspace.wechat.helper.core.constant.TimeConstant;
import org.kangspace.wechat.helper.core.exception.WeChatHttpFaultException;
import org.kangspace.wechat.helper.core.exception.WeChatServerErrorException;
import org.kangspace.wechat.helper.core.request.HttpUtil;
import org.kangspace.wechat.helper.core.request.WeChatRequest;
import org.kangspace.wechat.helper.core.request.WeChatResponse;
import org.kangspace.wechat.helper.core.retry.RetryRunner;
import org.kangspace.wechat.helper.core.util.ThreadUtil;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;

/**
 * 执行Http请求重试过滤器
 * <pre>
 * 1. 处理Http请求超时重试,包括:
 *  {@link UnknownHostException},
 *  {@link ConnectException}({@link ConnectTimeoutException}),
 *  {@link IOException}({@link java.net.SocketTimeoutException}),
 *  {@link TimeoutException}({@link io.netty.handler.timeout.ReadTimeoutException})
 * 2. 处理Http 502,503,504错误重试
 * 3. 处理微信服务器异常{@link org.kangspace.wechat.helper.core.constant.WeChatResponseCode#CODE_NE_1}时,重试
 *
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/26
 */
@Slf4j
public class RequestExecuteRetryFilter implements RequestFilter {

    /**
     * 重试间隔时间
     */
    private static final int RETRY_INTERVAL_MILLIS = (int) TimeConstant.MillisSecond.ONE_SECOND;

    @Override
    public <Req, Resp> Mono<Resp> doFilter(WeChatRequest<Req, Resp> request, RequestFilterChain chain) {
        log.debug("request execute retry filter run.");
        Resp resp = RetryRunner.run(request::doExecute, request.getWechatConfig().requestConfig().getMaxRetryCount(), (exception) -> {
            // 1. 请求异常
            boolean isHttpConnectExceptionRetry = isRetryException(exception) || isRetryException(exception.getCause());
            if (isHttpConnectExceptionRetry) {
                return true;
            }
            // 2. Http 502,503,504错误重试
            if (exception instanceof WeChatHttpFaultException) {
                WeChatResponse<?> response;
                return (response = ((WeChatHttpFaultException) exception).getWeChatResponse()) != null && HttpUtil.isRetryHttpStatus(response.status());
            }
            // 3. 微信服务器异常重试
            if (exception instanceof WeChatServerErrorException) {
                ThreadUtil.randomSleep(RETRY_INTERVAL_MILLIS);
                return true;
            }
            return false;
        });
        return resp != null ? Mono.just(resp) : Mono.empty();
    }

    /**
     * 是否重试异常
     *
     * @param exception {@link Exception}
     * @return boolean
     */
    private boolean isRetryException(Throwable exception) {
        return (exception instanceof UnknownHostException ||
                exception instanceof ConnectException ||
//                exception instanceof IOException ||
                exception instanceof TimeoutException);
    }

    @Override
    public <Req, Resp> boolean isSupported(WeChatRequest<Req, Resp> request) {
        return true;
    }

    @Override
    public int order() {
        return RequestFilterOrder.REQUEST_EXECUTE_RETRY_FILTER.getOrder();
    }
}
