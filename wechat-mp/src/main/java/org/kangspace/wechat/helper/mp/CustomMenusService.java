package org.kangspace.wechat.helper.mp;

import org.kangspace.wechat.helper.mp.bean.*;

import javax.annotation.Nonnull;

/**
 * <p>
 * 微信公众号"自定义菜单"相关Service
 * </p>
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/09
 */
public interface CustomMenusService extends WeChatMpService {

    /**
     * 创建接口
     *
     * @param request {@link MenuCreateRequest}
     * @return {@link WeChatMpResponseEntity}
     * @see org.kangspace.wechat.helper.mp.constant.WeChatMpApiPaths#MENU_CREATE
     */
    WeChatMpResponseEntity menuCreate(@Nonnull MenuCreateRequest request);

    /**
     * 获取自定义菜单配置
     *
     * @return {@link MenuGetResponse}
     * @see org.kangspace.wechat.helper.mp.constant.WeChatMpApiPaths#MENU_GET
     */
    MenuGetResponse menuGet();

    /**
     * 删除接口(删除当前的自定义菜单)
     *
     * @return {@link WeChatMpResponseEntity}
     * @see org.kangspace.wechat.helper.mp.constant.WeChatMpApiPaths#MENU_DELETE
     */
    WeChatMpResponseEntity menuDelete();

    /**
     * 查询自定义菜单的配置接口
     *
     * @return {@link CurrentSelfMenuInfoResponse}
     * @see org.kangspace.wechat.helper.mp.constant.WeChatMpApiPaths#GET_CURRENT_SELFMENU_INFO
     */
    CurrentSelfMenuInfoResponse getCurrentSelfMenuInfo();

    /**
     * 创建个性化菜单
     *
     * @param request {@link MenuAddConditionalRequest}
     * @return {@link MenuAddConditionalResponse}
     * @see org.kangspace.wechat.helper.mp.constant.WeChatMpApiPaths#MENU_ADD_CONDITIONAL
     */
    MenuAddConditionalResponse menuAddConditional(@Nonnull MenuAddConditionalRequest request);

    /**
     * 删除个性化菜单
     *
     * @param request {@link MenuDelConditionalRequest}
     * @return {@link WeChatMpResponseEntity}
     * @see org.kangspace.wechat.helper.mp.constant.WeChatMpApiPaths#MENU_DEL_CONDITIONAL
     */
    WeChatMpResponseEntity menuDelConditional(@Nonnull MenuDelConditionalRequest request);

    /**
     * 测试个性化菜单匹配结果
     *
     * @param request {@link MenuTryMatchRequest}
     * @return {@link MenuTryMatchResponse}
     * @see org.kangspace.wechat.helper.mp.constant.WeChatMpApiPaths#MENU_TRY_MATCH
     */
    MenuTryMatchResponse menuTryMatch(@Nonnull MenuTryMatchRequest request);

}
