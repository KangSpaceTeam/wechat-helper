package org.kangspace.wechat.helper.core.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.kangspace.wechat.helper.core.request.HttpUtil;

import java.util.Map;

/**
 * HttpUtil 测试
 *
 * @author kango2gler@gmail.com
 * @since 2023/9/9
 */
@Slf4j
@RunWith(JUnit4.class)
public class HttpUtilTest {

    /**
     * Http响应头值转换为key=Value <br>
     */
    @Test
    public void testHeaderValues() {
        String val = "attachment; filename*=utf-8''logo_240.png; filename=\"logo_240.png\"";
        Map<String, String> valueMap = HttpUtil.headerValues(val);
        System.out.println(valueMap);

    }
}
