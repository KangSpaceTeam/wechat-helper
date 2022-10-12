package org.kangspace.wechat.helper.core.request.filter;

import org.kangspace.wechat.helper.core.request.WeChatRequest;

/**
 * AccessToken抽象过滤器
 *
 * @author kango2gler@gmail.com
 * @since 2022/10/3
 */
public abstract class AbstractAccessTokenRequestFilter implements RequestFilter {

    @Override
    public boolean isSupported(WeChatRequest request) {
        return request != null && request.isNeedAccessToken();
    }
}
