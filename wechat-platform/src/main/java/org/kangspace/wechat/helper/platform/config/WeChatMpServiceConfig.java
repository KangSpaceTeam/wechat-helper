package org.kangspace.wechat.helper.platform.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.kangspace.wechat.helper.mp.DefaultWeChatMpService;
import org.kangspace.wechat.helper.mp.WeChatMpService;
import org.kangspace.wechat.helper.mp.config.WeChatMpConfig;
import org.kangspace.wechat.helper.mp.message.WeChatMpMessageResolver;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 微信公众号配置
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/25
 */
@Slf4j
@Data
@Configuration
@ConfigurationProperties(prefix = "wechat.mp")
public class WeChatMpServiceConfig implements InitializingBean {
    private String appId;
    private String appSecret;
    private String token;

    @Bean
    public WeChatMpService weChatMpService() {
        WeChatMpConfig config = new WeChatMpConfig(appId, appSecret);
        config.setToken(token);
        return new DefaultWeChatMpService(config);
    }

    @Bean
    public WeChatMpMessageResolver weChatMpMessageResolver() {
        return new WeChatMpMessageResolver(weChatMpService());
    }

    @Override
    public void afterPropertiesSet() {
        log.info("微信公众号配置加载完成: this: {}", this);
    }
}
