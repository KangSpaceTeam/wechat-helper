package org.kangspace.wechat.helper.work.env;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.kangspace.wechat.helper.core.env.WeChatPropertiesPropertySource;
import org.kangspace.wechat.helper.work.constant.WeComApiPathMapping;

import java.util.Properties;

/**
 * 企微Api配置源测试类
 *
 * @author kango2gler@gmail.com
 * @since 2022/10/2
 */
@RunWith(JUnit4.class)
@Slf4j
public class WeComApiPropertySourceTest {

    @Test
    public void apiEnumPropertySourceTest() {
        WeComApiEnumPropertySource weComApiPropertySource = new WeComApiEnumPropertySource();
        String apiBasePath = weComApiPropertySource.getApiBasePath();
        String abc = weComApiPropertySource.getProperty("ABC", "abc");
        log.info("apiBasePath:{}, ABC:{}", apiBasePath, abc);
        Assert.assertTrue("枚举配置新信息apiBasePath不存在", StringUtils.isNotBlank(apiBasePath));
        Assert.assertTrue("枚举配置新信息ABC获取默认值失败", StringUtils.isNotBlank(abc));
    }


    @Test
    public void multiPropertySourceTest() {
        Properties weChatProperty = new Properties();
        weChatProperty.put(WeComApiPathMapping.API_BASE_PATH.getPathName(), "http://localhost:8080");
        weChatProperty.put("ABC", "abc");
        WeComApiEnumPropertySource weComApiPropertySource = new WeComApiEnumPropertySource();
        WeChatPropertiesPropertySource weChatPropertiesPropertySource = new WeChatPropertiesPropertySource(weChatProperty);
        String weComApiEnumValue = weComApiPropertySource.getApiBasePath();
        String weChatPropertiesValue = weChatPropertiesPropertySource.getPropertyString(WeComApiPathMapping.API_BASE_PATH.getPathName());
        log.info("weComApiPropertySource api_base_path:{}", weComApiEnumValue);
        log.info("weChatPropertiesPropertySource api_base_path:{}", weChatPropertiesValue);

        Assert.assertTrue("weComApiPropertySource配置新信息apiBasePath不存在", StringUtils.isNotBlank(weComApiEnumValue));
        Assert.assertTrue("weChatPropertiesPropertySource配置新信息apiBasePath不存在", StringUtils.isNotBlank(weChatPropertiesValue));
    }

    @Test
    public void apiPropertiesPropertySourceTest() {
        WeComApiPropertiesPropertySource weComApiPropertiesPropertySource = new WeComApiPropertiesPropertySource();
        String weComApiPropertiesBasePath = weComApiPropertiesPropertySource.getApiBasePath();
        log.info("weComApiPropertiesBasePath api_base_path:{}", weComApiPropertiesBasePath);
        Assert.assertTrue("weComApiPropertiesBasePath配置信息apiBasePath不存在", StringUtils.isNotBlank(weComApiPropertiesBasePath));
    }

}
