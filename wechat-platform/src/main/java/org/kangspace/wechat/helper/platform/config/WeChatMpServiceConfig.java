package org.kangspace.wechat.helper.platform.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kangspace.wechat.helper.core.message.WeChatMessageHandler;
import org.kangspace.wechat.helper.mp.DefaultWeChatMpService;
import org.kangspace.wechat.helper.mp.WeChatMpService;
import org.kangspace.wechat.helper.mp.config.WeChatMpConfig;
import org.kangspace.wechat.helper.mp.message.WeChatMpMessage;
import org.kangspace.wechat.helper.mp.message.WeChatMpMessageHandler;
import org.kangspace.wechat.helper.mp.message.WeChatMpMessageResolver;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Nonnull;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 微信公众号配置
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/25
 */
@Slf4j
@Data
@Configuration
@ConfigurationProperties(prefix = "wechat.config")
public class WeChatMpServiceConfig implements InitializingBean {
    /**
     * 应用和WeChatMpService的map <br>
     * 格式: key: rawId, value: {@link WeChatMpService}
     */
    public final static ConcurrentHashMap<String,WeChatMpService> APP_MP_SERVICE_MAP = new ConcurrentHashMap<>(2);
    /**
     * 应用和WeChatMpMessageResolver的map
     * 格式: key: rawId, value: {@link WeChatMpMessageResolver}
     */
    public final static ConcurrentHashMap<String, WeChatMpMessageResolver> APP_MP_MESSAGE_RESOLVER_MAP = new ConcurrentHashMap<>(2);
    /**
     * 公众号配置列表
     */
    private List<MpServiceConfig> mps = new ArrayList<>(0);

    @Resource
    private List<WeChatMpMessageHandler<WeChatMpMessage>> messageHandlers;

    /**
     * 配置信息
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MpServiceConfig {
        @Nonnull
        private String appId;
        @Nonnull
        private String appSecret;
        private String encodingAESKey;
        private String token;
        @Nonnull
        private String rawId;
    }

    /**
     * 配置初始化
     */
    public void initConfig() {
        this.mps.forEach(config ->{
            String rawId = config.getRawId();
            WeChatMpConfig mpConfig = new WeChatMpConfig(config.getAppId(), config.getAppSecret());
            mpConfig.setToken(config.getToken());
            mpConfig.setEncodingAESKey(config.getEncodingAESKey());
            WeChatMpService mpService = new DefaultWeChatMpService(mpConfig);
            WeChatMpMessageResolver mpMessageResolver = new WeChatMpMessageResolver(mpService);
            mpMessageResolver.addWeChatHandlers(messageHandlers);
            APP_MP_SERVICE_MAP.put(rawId, mpService);
            APP_MP_MESSAGE_RESOLVER_MAP.put(rawId, mpMessageResolver);
        });
    }

    @Override
    public void afterPropertiesSet() {
        initConfig();
        log.info("微信公众号配置加载完成: this: {}", this);
    }

    /**
     * 通过RawId获取WeChatMpMessageResolver
     * @param rawId rawId
     * @return {@link WeChatMpMessageResolver}
     */
    public WeChatMpMessageResolver getMessageResolver(String rawId) {
        return APP_MP_MESSAGE_RESOLVER_MAP.get(rawId);
    }

    /**
     * 获取所有消息解析器
     * @return {@link Collection}&lt;{@link WeChatMpMessageResolver}&gt;
     */
    public Collection<WeChatMpMessageResolver> getMessageResolvers() {
        return APP_MP_MESSAGE_RESOLVER_MAP.values();
    }
}
