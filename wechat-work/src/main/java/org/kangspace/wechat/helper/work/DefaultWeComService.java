package org.kangspace.wechat.helper.work;

import org.kangspace.wechat.helper.core.request.filter.RequestFilterChain;
import org.kangspace.wechat.helper.work.config.WeComConfig;
import org.kangspace.wechat.helper.work.token.WeComAccessTokenService;

/**
 * <p>
 * WeComService默认实现
 * </p>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/26
 */
public class DefaultWeComService extends AbstractWeComService implements WeComService {

    public DefaultWeComService(WeComConfig weChatConfig) {
        super(weChatConfig);
    }

    public DefaultWeComService(WeComAccessTokenService weComAccessTokenService) {
        super(weComAccessTokenService);
    }

    public DefaultWeComService(WeComAccessTokenService weComAccessTokenService, RequestFilterChain requestFilterChain) {
        super(weComAccessTokenService, requestFilterChain);
    }
}
