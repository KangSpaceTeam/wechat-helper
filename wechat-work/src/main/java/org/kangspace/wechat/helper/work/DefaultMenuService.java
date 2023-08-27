package org.kangspace.wechat.helper.work;

import org.kangspace.wechat.helper.core.request.filter.RequestFilterChain;
import org.kangspace.wechat.helper.work.bean.WeComResponseEntity;
import org.kangspace.wechat.helper.work.bean.menu.MenuCreateRequest;
import org.kangspace.wechat.helper.work.bean.menu.MenuGetResponse;
import org.kangspace.wechat.helper.work.config.WeComConfig;
import org.kangspace.wechat.helper.work.constant.WeComApiPaths;
import org.kangspace.wechat.helper.work.token.WeComAccessTokenService;

import javax.annotation.Nonnull;

/**
 * <p>
 * 企业微信"应用管理-自定义菜单"相关 Service默认实现
 * </p>
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/26
 */
public class DefaultMenuService extends AbstractWeComService implements MenuService {

    public DefaultMenuService(WeComConfig weChatConfig) {
        super(weChatConfig);
    }

    public DefaultMenuService(WeComAccessTokenService weComAccessTokenService) {
        super(weComAccessTokenService);
    }

    public DefaultMenuService(WeComAccessTokenService weComAccessTokenService, RequestFilterChain requestFilterChain) {
        super(weComAccessTokenService, requestFilterChain);
    }

    @Override
    public WeComResponseEntity menuCreate(@Nonnull Integer agentId, MenuCreateRequest request) {
        String url = urlTransfer(WeComApiPaths.MENU_CREATE, agentId);
        return post(url, request, WeComResponseEntity.class);
    }

    @Override
    public MenuGetResponse menuGet(@Nonnull Integer agentId) {
        String url = urlTransfer(WeComApiPaths.MENU_GET, agentId);
        return get(url, MenuGetResponse.class);
    }

    @Override
    public WeComResponseEntity menuDelete(@Nonnull Integer agentId) {
        String url = urlTransfer(WeComApiPaths.MENU_DELETE, agentId);
        return get(url, WeComResponseEntity.class);
    }
}
