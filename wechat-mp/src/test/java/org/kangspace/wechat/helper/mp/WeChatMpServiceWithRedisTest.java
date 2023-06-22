package org.kangspace.wechat.helper.mp;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.kangspace.wechat.helper.core.config.WeChatRedisConfig;
import org.kangspace.wechat.helper.core.config.WeChatRedisConfigFactory;
import org.kangspace.wechat.helper.core.constant.StringLiteral;
import org.kangspace.wechat.helper.core.storage.redis.RedisWeChatTokenStorage;
import org.kangspace.wechat.helper.core.token.AccessTokenResponse;
import org.kangspace.wechat.helper.mp.bean.MpServerIpListResponse;
import org.kangspace.wechat.helper.mp.bean.WeChatMpAccessTokenRequest;
import org.kangspace.wechat.helper.mp.config.WeChatMpConfig;
import org.kangspace.wechat.helper.mp.constant.WeChatMpApiPaths;
import org.kangspace.wechat.helper.mp.token.DefaultWeChatMpAccessTokenService;

/**
 * 微信公众号相关Service(使用Redis)测试类
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/24
 */
@Slf4j
@RunWith(JUnit4.class)
public class WeChatMpServiceWithRedisTest {
    private final String appId = WeChatMpAppConstant.GLOBAL_APPID;
    private final String appSecret = WeChatMpAppConstant.GLOBAL_APPSECRET;
    private ServerService mpServerService;
    private DefaultWeChatMpAccessTokenService weChatMpAccessTokenService;

    @Before
    public void before() {
        String redisAddress = "redis://127.0.0.1:6379";
        Integer database = 0;

        WeChatMpConfig weChatMpConfigWithRedis = new WeChatMpConfig(appId, appSecret);
        weChatMpConfigWithRedis.setRedisConfig(WeChatRedisConfigFactory.newConfig(WeChatRedisConfig.ServerType.SingleServer, redisAddress, database));
        RedisWeChatTokenStorage mpServerServiceWithRedisStorage = new RedisWeChatTokenStorage(weChatMpConfigWithRedis);
        weChatMpConfigWithRedis.setWeChatTokenStorage(mpServerServiceWithRedisStorage);

        weChatMpAccessTokenService = new DefaultWeChatMpAccessTokenService(weChatMpConfigWithRedis);
        mpServerService = new DefaultServerService(weChatMpAccessTokenService);
    }

    /**
     * 业务接口token自动刷新
     */
    @Test
    public void tokenRefreshTest() {
        // 1. 获取token,并缓存
        AccessTokenResponse token = weChatMpAccessTokenService.token();
        log.info("获取token,并缓存: token: {}", token);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
        }
        // 2. http获取新token
        String param = WeChatMpAccessTokenRequest.toQueryString(appId, appSecret);
        String newTokenUrl = WeChatMpApiPaths.TOKEN + StringLiteral.QUESTION_MARK + param;
        String result = mpServerService.get(newTokenUrl, String.class, false);
        log.info("http获取新token: token: {}", result);
        // 3. 旧token失效, 请求业务接口,token自动刷新
        this.getApiDomainIpTest();
    }

    /**
     * 获取微信 API 接口 IP地址测试
     */
    @Test
    public void getApiDomainIpTest() {
        MpServerIpListResponse response = mpServerService.getApiDomainIp();
        Assert.assertTrue("获取失败!", response != null);
        log.info("response: {}", response);
    }
}
