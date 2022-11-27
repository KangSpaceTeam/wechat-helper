package org.kangspace.wechat.helper.core.request.filter;

/**
 * 请求过滤器排序枚举
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/26
 */
public enum RequestFilterOrder {
    /**
     * Http执行过滤器
     */
    REQUEST_EXECUTE_FILTER(Integer.MAX_VALUE),
    /**
     * 请求重试过滤器
     */
    REQUEST_EXECUTE_RETRY_FILTER(Integer.MAX_VALUE - 1),
    /**
     * Token处理过滤器
     */
    TOKEN_REQUEST_FILTER(Integer.MAX_VALUE - 100),

    ;
    private final int order;

    RequestFilterOrder(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }
}
