package org.kangspace.wechat.helper.mp.request.filter;

import lombok.extern.slf4j.Slf4j;
import org.kangspace.wechat.helper.core.request.filter.OAuth2UrlTokenRequestFilter;
import org.kangspace.wechat.helper.mp.bean.WeChatMpResponseEntity;
import org.kangspace.wechat.helper.mp.constant.WeChatMpResponseCode;

/**
 * 微信公众号AccessToken处理过滤器
 * <p>
 * 作用:
 * 1. 补充需要AccessToken的URL
 * 2. 替换请求URL中失效的AccessToken
 * 3. AccessToken过期时刷新AccessToken
 * </p>
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/24
 */
@Slf4j
public class WeChatMpAccessTokenRequestFilter extends OAuth2UrlTokenRequestFilter {

    @Override
    public <T> boolean testToken(T response) {
        return  response instanceof WeChatMpResponseEntity
                && WeChatMpResponseCode.isInvalidToken(((WeChatMpResponseEntity) response).getErrCode());
    }
}
