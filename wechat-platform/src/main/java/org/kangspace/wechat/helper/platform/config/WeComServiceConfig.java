package org.kangspace.wechat.helper.platform.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.kangspace.wechat.helper.mp.message.WeChatMpMessageResolver;
import org.kangspace.wechat.helper.work.DefaultWeComService;
import org.kangspace.wechat.helper.work.WeComService;
import org.kangspace.wechat.helper.work.config.WeComConfig;
import org.kangspace.wechat.helper.work.event.WeComEventHandler;
import org.kangspace.wechat.helper.work.message.WeComMessage;
import org.kangspace.wechat.helper.work.message.WeComMessageHandler;
import org.kangspace.wechat.helper.work.message.WeComMessageResolver;
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
 * 企业微信配置
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/6
 */
@Slf4j
@Data
@Configuration
@ConfigurationProperties(prefix = "wechat.wecom")
public class WeComServiceConfig implements InitializingBean {
    /**
     * 应用和WeChatMpService的map <br>
     * 格式: key: corpId_agentId, value: {@link WeComService}
     */
    public final static ConcurrentHashMap<String, WeComService> CORP_AGENT_SERVICE_MAP = new ConcurrentHashMap<>(2);
    /**
     * 应用和WeComMessageResolver的map
     * 格式: key: corpId_agentId, value: {@link WeComMessageResolver}
     */
    public final static ConcurrentHashMap<String, WeComMessageResolver> CORP_AGENT_MESSAGE_RESOLVER_MAP = new ConcurrentHashMap<>(2);
    /**
     * 公众号配置列表
     */
    private List<Config> configs = new ArrayList<>(0);

    @Resource
    private List<WeComMessageHandler<WeComMessage>> messageHandlers;
    @Resource
    private List<WeComEventHandler<?>> eventHandlers;
    @Resource
    private List<WeComMessageHandler<?>> allMessageHandlers;

    /**
     * 配置信息
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Config {
        @Nonnull
        private String agentId;
        @Nonnull
        private String corpId;
        @Nonnull
        @ToString.Exclude
        private String appSecret;
        @ToString.Exclude
        private String encodingAESKey;
        @ToString.Exclude
        private String token;
    }

    /**
     * 配置初始化
     */
    public void initConfig() {
        this.configs.forEach(config -> {
            String corpId = config.getCorpId();
            String agentId = config.getAgentId();
            WeComConfig weComConfig = new WeComConfig(corpId, config.getAppSecret());
            weComConfig.setToken(config.getToken());
            weComConfig.setEncodingAESKey(config.getEncodingAESKey());
            WeComService weComService = new DefaultWeComService(weComConfig);
            WeComMessageResolver weComMessageResolver = new WeComMessageResolver(weComService);
            weComMessageResolver.addWeChatHandlers(messageHandlers);
            weComMessageResolver.addWeChatHandlers(eventHandlers);
            // 或加载所有
            // weChatMpMessageResolver.addWeChatHandlers(allMessageHandlers);
            String key = getConfigMapKey(corpId, agentId);
            CORP_AGENT_SERVICE_MAP.put(key, weComService);
            CORP_AGENT_MESSAGE_RESOLVER_MAP.put(key, weComMessageResolver);
        });
    }

    @Override
    public void afterPropertiesSet() {
        initConfig();
        log.info("企业微信配置加载完成: this: {}", this);
    }

    /**
     * 获取 WeComMessageResolver
     *
     * @param corpId  企业ID
     * @param agentId 应用ID
     * @return {@link WeComMessageResolver}
     */
    public WeComMessageResolver getMessageResolver(String corpId, String agentId) {
        return CORP_AGENT_MESSAGE_RESOLVER_MAP.get(getConfigMapKey(corpId, agentId));
    }

    /**
     * 获取所有消息解析器
     *
     * @return {@link Collection}&lt;{@link WeChatMpMessageResolver}&gt;
     */
    public Collection<WeComMessageResolver> getMessageResolvers() {
        return CORP_AGENT_MESSAGE_RESOLVER_MAP.values();
    }

    private String getConfigMapKey(String corpId, String agentId) {
        return corpId + "_" + agentId;
    }
}
