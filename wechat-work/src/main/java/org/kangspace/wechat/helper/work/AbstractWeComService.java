package org.kangspace.wechat.helper.work;

import lombok.Data;
import org.kangspace.wechat.helper.core.request.filter.RequestFilterChain;
import org.kangspace.wechat.helper.core.token.WeChatTokenService;
import org.kangspace.wechat.helper.work.config.WeComConfig;
import org.kangspace.wechat.helper.work.request.filter.WeComAccessTokenRequestFilter;
import org.kangspace.wechat.helper.work.request.filter.WeComRequestFilterChainFactory;
import org.kangspace.wechat.helper.work.token.DefaultWeComAccessTokenService;
import org.kangspace.wechat.helper.work.token.WeComAccessTokenService;

/**
 * 企业微信抽象Service
 * <pre>
 * requestFilterChain: 请求过滤器, 需添加{@link WeComAccessTokenRequestFilter}
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/6/22
 */
@Data
public abstract class AbstractWeComService implements WeComService {
    private WeComConfig weChatConfig;
    private RequestFilterChain requestFilterChain;
    private WeComAccessTokenService weComAccessTokenService;


    protected AbstractWeComService() {
    }

    public AbstractWeComService(WeComConfig weChatConfig) {
        this(new DefaultWeComAccessTokenService(weChatConfig));
    }

    public AbstractWeComService(WeComAccessTokenService WeComAccessTokenService) {
        this(WeComAccessTokenService, WeComRequestFilterChainFactory.defaultRequestFilterChain());
    }

    public AbstractWeComService(WeComAccessTokenService weComAccessTokenService, RequestFilterChain requestFilterChain) {
        this.weChatConfig = weComAccessTokenService.getWeChatConfig();
        this.requestFilterChain = requestFilterChain;
        this.weComAccessTokenService = !(this instanceof WeChatTokenService) ? weComAccessTokenService : null;
    }

    @Override
    public WeChatTokenService getWeChatTokenService() {
        return weComAccessTokenService;
    }
}
