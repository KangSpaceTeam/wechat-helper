package org.kangspace.wechat.helper.mp;

import org.kangspace.wechat.helper.core.WeChatService;
import org.kangspace.wechat.helper.core.constant.StringLiteral;
import org.kangspace.wechat.helper.core.util.ReflectUtil;
import org.kangspace.wechat.helper.mp.config.WeChatMpConfig;
import org.kangspace.wechat.helper.mp.exception.WeChatMpException;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 微信公众号Service
 *
 * @author kango2gler@gmail.com
 * @since 2022/10/3
 */
public interface WeChatMpService extends WeChatService {
    /**
     * Service类型转换缓存, 按appId缓存.<br>
     * 缓存内容: key: appId:{serviceClassName}, value: {@link WeChatMpService} <br>
     */
    ConcurrentHashMap<String, WeChatMpService> OF_COLLECTION = new ConcurrentHashMap<>();

    /**
     * 将当前{@link WeChatMpService}转换为其他{@link WeChatMpService}
     *
     * @param toWeChatService 需要转换的目标WeChatService
     * @return {@link T}
     */
    @SuppressWarnings("unchecked")
    @Override
    default <T extends WeChatService> T of(Class<T> toWeChatService) {
        if (!WeChatMpService.class.isAssignableFrom(toWeChatService)) {
            throw new WeChatMpException("toWeChatService must be assignable by WeChatMpService!");
        }
        String appId = getWeChatConfig().getAppId();
        String key = appId + StringLiteral.COLON + toWeChatService.getName();
        WeChatMpService weChatMpService = OF_COLLECTION.get(key);
        if (weChatMpService == null) {
            weChatMpService = (WeChatMpService) ReflectUtil.newInstance(toWeChatService, WeChatMpConfig.class, getWeChatConfig());
            OF_COLLECTION.put(key, weChatMpService);
        }
        return (T) weChatMpService;
    }
}
