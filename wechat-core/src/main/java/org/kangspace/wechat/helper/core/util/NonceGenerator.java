package org.kangspace.wechat.helper.core.util;

import java.util.Random;

/**
 * Nonce 生成器
 *
 * @author kango2gler@gmail.com
 * @since 2023/1/1
 */
public class NonceGenerator {

    /**
     * 数字
     */
    public static final String NUMERIC = "0123456789";

    /**
     * 生成指定长度的数字Nonce
     *
     * @return 数字Nonce
     */
    public static String numeric(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(NUMERIC.length());
            sb.append(NUMERIC.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 生成16位长度的数组Nonce
     *
     * @return 数字Nonce
     */
    public static String numeric() {
        return numeric(16);
    }
}
