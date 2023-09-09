package org.kangspace.wechat.helper.core.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.kangspace.devhelper.digest.DigestUtil;

/**
 * DigestUtil测试类
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/24
 */
@Slf4j
@RunWith(JUnit4.class)
public class DigestUtilTest {


    /**
     * sha1测试
     */
    @Test
    public void sha1Test() {
        String raw1 = "abc";
        String raw2 = "bcd";
        String raw3 = "mnb";
        String rawGroup = raw1 + raw2 + raw3;
        String sha1A = DigestUtil.sha1(rawGroup);
        log.info("rawGroup:{}, sha1A: {}", rawGroup, sha1A);
        String sha1B = DigestUtil.sha1(raw2, raw3, raw1);
        log.info("sha1B: {}", sha1B);
        Assert.assertEquals(sha1A, sha1B);
    }

}
