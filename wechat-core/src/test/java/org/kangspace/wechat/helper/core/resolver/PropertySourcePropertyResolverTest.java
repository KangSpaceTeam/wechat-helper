package org.kangspace.wechat.helper.core.resolver;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.kangspace.wechat.helper.core.env.ApiEnumPropertySource;
import org.kangspace.wechat.helper.core.env.ApiPropertiesPropertySource;
import org.kangspace.wechat.helper.core.env.MultiPropertySources;
import org.kangspace.wechat.helper.core.env.WeChatPropertiesPropertySource;

import java.util.Properties;

import static org.kangspace.wechat.helper.core.constant.WeChatConstant.API_BASE_PATH_NAME;

/**
 * PropertySourcePropertyResolver Test
 *
 * @author kango2gler@gmail.com
 * @since 2022/10/2
 */
@Slf4j
@RunWith(JUnit4.class)
public class PropertySourcePropertyResolverTest {

    /**
     * PropertySourcePropertyResolver Test
     */
    @Test
    public void test1() {
        String apiBasePathName = API_BASE_PATH_NAME;
        ApiEnumPropertySource apiEnumPropertySource = new ApiEnumPropertySource(Enum.class) {
            @Override
            public String getValue(Enum e) {
                return "enum";
            }

            @Override
            public Object getProperty(String key) {
                return "enum";
            }

            @Override
            public String getProperty(String key, String defaultVal) {
                return "enum";
            }
        };
        String apiTestPropertiesFileName = "api_test.properties";
        ApiPropertiesPropertySource apiPropertiesPropertySource = new ApiPropertiesPropertySource(apiTestPropertiesFileName) {
            @Override
            public String getApiBasePath() {
                return this.getPropertyString(apiBasePathName);
            }
        };
        Properties wechatProperties = new Properties();
        wechatProperties.put(apiBasePathName, "wechatProperties." + apiBasePathName);
        WeChatPropertiesPropertySource weChatPropertiesPropertySource = new WeChatPropertiesPropertySource(wechatProperties);
        MultiPropertySources multiPropertySources = new MultiPropertySources(apiEnumPropertySource, apiPropertiesPropertySource,
                weChatPropertiesPropertySource);
        PropertyResolver propertyResolver = new PropertySourcesPropertyResolver(multiPropertySources);
        String apiEnumPropertyApiPath = apiEnumPropertySource.getApiBasePath();
        String apiPropertiesPropertyApiPath = apiPropertiesPropertySource.getApiBasePath();
        String weChatPropertiesApiPath = weChatPropertiesPropertySource.getPropertyString(apiBasePathName);
        String propertyResolverApiPath = propertyResolver.getProperty(apiBasePathName);
        log.info("apiEnumPropertyApiPath {}:    {}", apiBasePathName, apiEnumPropertyApiPath);
        log.info("apiPropertiesPropertyApiPath {}:  {}", apiBasePathName, apiPropertiesPropertyApiPath);
        log.info("weChatPropertiesApiPath {}:   {}", apiBasePathName, weChatPropertiesApiPath);
        log.info("propertyResolver {}:  {}", apiBasePathName, propertyResolverApiPath);
        Assert.assertTrue(StringUtils.isNotBlank(apiEnumPropertyApiPath) &&
                StringUtils.isNotBlank(apiPropertiesPropertyApiPath) &&
                StringUtils.isNotBlank(weChatPropertiesApiPath) &&
                StringUtils.isNotBlank(propertyResolverApiPath)
        );
    }
}
