package org.kangspace.wechat.helper.work;

import org.kangspace.wechat.helper.core.WeChatService;
import org.kangspace.wechat.helper.core.constant.StringLiteral;
import org.kangspace.wechat.helper.core.util.ReflectUtil;
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
}
