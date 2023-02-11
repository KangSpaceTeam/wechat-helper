package org.kangspace.wechat.helper.mp;

import org.kangspace.wechat.helper.mp.bean.*;
import org.kangspace.wechat.helper.mp.config.WeChatMpConfig;
import org.kangspace.wechat.helper.mp.constant.WeChatMpApiPaths;

import javax.annotation.Nonnull;

/**
 * <p>
 * 微信公众号"自定义菜单"相关Service默认实现
 * </p>
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/24
 */
public class DefaultCustomMenusService extends AbstractWeChatMpService implements CustomMenusService {

    public DefaultCustomMenusService(WeChatMpConfig weChatConfig) {
        super(weChatConfig);
    }

    @Override
    public WeChatMpResponseEntity menuCreate(@Nonnull MenuCreateRequest request) {
        String url = WeChatMpApiPaths.MENU_CREATE;
        return post(url, request, WeChatMpResponseEntity.class);
    }

    @Override
    public MenuGetResponse menuGet() {
        String url = WeChatMpApiPaths.MENU_GET;
        return get(url, MenuGetResponse.class);
    }

    @Override
    public WeChatMpResponseEntity menuDelete() {
        String url = WeChatMpApiPaths.MENU_DELETE;
        return post(url, null, WeChatMpResponseEntity.class);
    }

    @Override
    public CurrentSelfMenuInfoResponse getCurrentSelfMenuInfo() {
        String url = WeChatMpApiPaths.GET_CURRENT_SELFMENU_INFO;
        return get(url, CurrentSelfMenuInfoResponse.class);
    }

    @Override
    public MenuAddConditionalResponse menuAddConditional(@Nonnull MenuAddConditionalRequest request) {
        String url = WeChatMpApiPaths.MENU_ADD_CONDITIONAL;
        return post(url, request, MenuAddConditionalResponse.class);
    }

    @Override
    public WeChatMpResponseEntity menuDelConditional(@Nonnull MenuDelConditionalRequest request) {
        String url = WeChatMpApiPaths.MENU_DEL_CONDITIONAL;
        return post(url, request, WeChatMpResponseEntity.class);
    }

    @Override
    public MenuTryMatchResponse menuTryMatch(@Nonnull MenuTryMatchRequest request) {
        String url = WeChatMpApiPaths.MENU_TRY_MATCH;
        return post(url, request, MenuTryMatchResponse.class);
    }
}
