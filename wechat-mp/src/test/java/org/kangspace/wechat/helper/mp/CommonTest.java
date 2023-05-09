package org.kangspace.wechat.helper.mp;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.kangspace.wechat.helper.core.util.ProjectCore;

import java.text.MessageFormat;

/**
 * 公共测试
 *
 * @author kango2gler@gmail.com
 * @since 2023/02/05 13:49
 */
@Slf4j
@RunWith(JUnit4.class)
public class CommonTest {

    /**
     * coreVersion测试
     */
    @Test
    public void coreVersionTest() {
        log.info("coreVersion: {}", ProjectCore.coreVersion());
        log.info("userAgent: {}", ProjectCore.USER_AGENT);
    }

    /**
     * MessageFormat
     */
    @Test
    public void messageFormatTest() {
        log.info("{}", MessageFormat.format("1{0}{1}",1,null));
    }
}
