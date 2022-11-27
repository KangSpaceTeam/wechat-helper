package org.kangspace.wechat.helper.core.util;

import java.util.Random;

/**
 * 线程工具类
 * @author kango2gler@gmail.com
 * @since 2022/11/27
 */
public class ThreadUtil {

    /**
     * 线程随机Sleep
     * @param baseMillis 基于
     */
    public static void randomSleep(int baseMillis) {
        long sleepMillis = new Random().nextInt(baseMillis);
        try {
            Thread.sleep(sleepMillis);
        } catch (InterruptedException e) {
        }
    }
}
