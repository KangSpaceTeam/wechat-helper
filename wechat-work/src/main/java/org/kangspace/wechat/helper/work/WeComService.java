package org.kangspace.wechat.helper.work;

import org.kangspace.devhelper.ReflectUtil;
import org.kangspace.devhelper.str.StringLiteral;
import org.kangspace.wechat.helper.core.WeChatService;
import org.kangspace.wechat.helper.work.config.WeComConfig;
import org.kangspace.wechat.helper.work.exception.WeComException;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 企业微信Service
 *
 * @author kango2gler@gmail.com
 * @since 2022/10/3
 */
public interface WeComService extends WeChatService {
    /**
     * Service类型转换缓存, 按appId缓存.<br>
     * 缓存内容: key: appId:{serviceClassName}, value: {@link WeComService} <br>
     */
    ConcurrentHashMap<String, WeComService> OF_COLLECTION = new ConcurrentHashMap<>();


    /**
     * 将当前{@link WeComService}转换为其他{@link WeComService}
     *
     * @param toWeChatService 需要转换的目标WeChatService
     * @return {@link T}
     */
    @SuppressWarnings("unchecked")
    @Override
    default <T extends WeChatService> T of(Class<T> toWeChatService) {
        if (!WeComService.class.isAssignableFrom(toWeChatService)) {
            throw new WeComException("toWeChatService must be assignable by WeComService!");
        }
        if (Objects.equals(this.getClass(), toWeChatService)) {
            return (T) this;
        }
        String appId = getWeChatConfig().getAppId();
        String key = appId + StringLiteral.COLON + toWeChatService.getName();
        WeComService weChatMpService = OF_COLLECTION.get(key);
        if (weChatMpService == null) {
            weChatMpService = (WeComService) ReflectUtil.newInstance(toWeChatService, WeComConfig.class, getWeChatConfig());
            OF_COLLECTION.put(key, weChatMpService);
        }
        return (T) weChatMpService;
    }


    /**
     * 转换为{@link WeComServerService}
     *
     * @return {@link WeComServerService}
     */
    default WeComServerService ofWeComServerService() {
        return of(DefaultWeComServerService.class);
    }

    /**
     * 转换为{@link WeComIDService}
     *
     * @return {@link WeComIDService}
     */
    default WeComIDService ofWeComIDService() {
        return of(DefaultWeComIDService.class);
    }

    /**
     * 转换为{@link UserService}
     *
     * @return {@link UserService}
     */
    default UserService ofUserService() {
        return of(DefaultUserService.class);
    }

    /**
     * 转换为{@link DepartmentService}
     *
     * @return {@link DepartmentService}
     */
    default DepartmentService ofDepartmentService() {
        return of(DefaultDepartmentService.class);
    }

    /**
     * 转换为{@link TagService}
     *
     * @return {@link TagService}
     */
    default TagService ofTagService() {
        return of(DefaultTagService.class);
    }

    /**
     * 转换为{@link LinkedCorpService}
     *
     * @return {@link LinkedCorpService}
     */
    default LinkedCorpService ofLinkedCorpService() {
        return of(DefaultLinkedCorpService.class);
    }

    /**
     * 转换为{@link AuthService}
     *
     * @return {@link AuthService}
     */
    default AuthService ofAuthService() {
        return of(DefaultAuthService.class);
    }

    /**
     * 转换为{@link CorpGroupService}
     *
     * @return {@link CorpGroupService}
     */
    default CorpGroupService ofCorpGroupService() {
        return of(DefaultCorpGroupService.class);
    }

    /**
     * 转换为{@link SecurityService}
     *
     * @return {@link SecurityService}
     */
    default SecurityService ofSecurityService() {
        return of(DefaultSecurityService.class);
    }

    /**
     * 转换为{@link AppChatService}
     *
     * @return {@link AppChatService}
     */
    default AppChatService ofAppChatService() {
        return of(DefaultAppChatService.class);
    }

    /**
     * 转换为{@link WebHookService}
     *
     * @return {@link WebHookService}
     */
    default WebHookService ofWebHookService() {
        return of(DefaultWebHookService.class);
    }

    /**
     * 转换为{@link AgentService}
     *
     * @return {@link AgentService}
     */
    default AgentService ofAgentService() {
        return of(DefaultAgentService.class);
    }

    /**
     * 转换为{@link MenuService}
     *
     * @return {@link MenuService}
     */
    default MenuService ofMenuService() {
        return of(DefaultMenuService.class);
    }

    /**
     * 转换为{@link MediaService}
     *
     * @return {@link MediaService}
     */
    default MediaService ofMediaService() {
        return of(DefaultMediaService.class);
    }

}
