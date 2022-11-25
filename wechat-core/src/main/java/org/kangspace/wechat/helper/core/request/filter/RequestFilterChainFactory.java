package org.kangspace.wechat.helper.core.request.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * RequestFilter工厂类
 *
 * @author kango2gler@gmail.com
 * @since 2022/10/4
 */
public class RequestFilterChainFactory {

    /**
     * 获取默认的带{@link RequestExecuteFilter}过滤器链
     *
     * @return {@link RequestFilterChain}
     */
    public static RequestFilterChain defaultRequestChain() {
        RequestExecuteFilter executeFilter = new RequestExecuteFilter();
        return new DefaultRequestFilterChain(executeFilter);
    }

    /**
     * 获取默认的带{@link RequestExecuteFilter}过滤器链
     *
     * @param requestFilters 过滤器
     * @return {@link RequestFilterChain}
     */
    public static RequestFilterChain defaultRequestChain(RequestFilter... requestFilters) {
        List<RequestFilter> filterList = new ArrayList<>(requestFilters.length);
        boolean containRequestExecuteFilter = false;
        for (RequestFilter requestFilter : requestFilters) {
            filterList.add(requestFilter);
            if (!containRequestExecuteFilter && requestFilter instanceof RequestExecuteFilter) {
                containRequestExecuteFilter = true;
            }
        }
        if (!containRequestExecuteFilter) {
            filterList.add(new RequestExecuteFilter());
        }
        return new DefaultRequestFilterChain(filterList);
    }
}
