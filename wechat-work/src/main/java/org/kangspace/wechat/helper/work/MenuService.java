package org.kangspace.wechat.helper.work;

import org.kangspace.wechat.helper.work.bean.WeComResponseEntity;
import org.kangspace.wechat.helper.work.bean.menu.MenuCreateRequest;
import org.kangspace.wechat.helper.work.bean.menu.MenuGetResponse;

import javax.annotation.Nonnull;

/**
 * 企业微信"应用管理-自定义菜单"相关 Service <br>
 * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/90231">https://developer.work.weixin.qq.com/document/path/90231</a> <br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/08/26
 */
public interface MenuService extends WeComService {

    /**
     * 应用管理-自定义菜单-创建菜单
     *
     * @param agentId 应用ID
     * @return {@link WeComResponseEntity}
     */
    WeComResponseEntity menuCreate(@Nonnull Integer agentId, MenuCreateRequest request);

    /**
     * 应用管理-自定义菜单-获取菜单
     *
     * @param agentId 应用ID
     * @return {@link WeComResponseEntity}
     */
    MenuGetResponse menuGet(@Nonnull Integer agentId);

    /**
     * 应用管理-自定义菜单-删除菜单
     *
     * @param agentId 应用ID
     * @return {@link WeComResponseEntity}
     */
    WeComResponseEntity menuDelete(@Nonnull Integer agentId);
}
