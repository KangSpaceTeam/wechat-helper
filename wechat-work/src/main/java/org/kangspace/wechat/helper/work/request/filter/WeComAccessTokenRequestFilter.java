package org.kangspace.wechat.helper.work.request.filter;

import lombok.extern.slf4j.Slf4j;
import org.kangspace.wechat.helper.core.request.filter.OAuth2UrlTokenRequestFilter;
import org.kangspace.wechat.helper.work.bean.WeComResponseEntity;
import org.kangspace.wechat.helper.work.constant.WeComResponseCode;

/**
 * 企业微信AccessToken处理过滤器
 * <p>
 * 作用:
 * 1. 补充需要AccessToken的URL
 * 2. 替换请求URL中失效的AccessToken
 * 3. AccessToken过期时刷新AccessToken
 * </p>
 *
 * @author kango2gler@gmail.com
 * @since 2023/6/22
 */
@Slf4j
public class WeComAccessTokenRequestFilter extends OAuth2UrlTokenRequestFilter {

    @Override
    public <T> boolean testToken(T response) {
        return response instanceof WeComResponseEntity
                && WeComResponseCode.isInvalidToken(((WeComResponseEntity) response).getErrCode());
    }
}
