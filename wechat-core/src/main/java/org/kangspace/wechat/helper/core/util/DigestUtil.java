package org.kangspace.wechat.helper.core.util;

import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 签名摘要工具类
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/25
 */
@Slf4j
public class DigestUtil {

    /**
     * sha1摘要<br>
     * 说明: 将参数按字典序排序后,拼接为新的字符串,再进行sh1摘要<br>
     *
     * @param strings 需要摘要的字符串
     * @return 摘要结果
     */
    public static String sha1(String... strings) {
        List<String> rawList = Arrays.asList(strings);
        String sortedRaw = rawList.stream().sorted().collect(Collectors.joining());
        log.debug("sha1: strings: {}, sortedRaw: {}", strings, sortedRaw);
        return sha1(sortedRaw);
    }

    /**
     * sha1摘要
     *
     * @param raw 需要摘要的字符串
     * @return hexString
     */
    public static String sha1(String raw) {
        try {
            MessageDigest sha1 = MessageDigest.getInstance("SHA1");
            sha1.update(raw.getBytes(StandardCharsets.UTF_8));
            byte[] messageDigest = sha1.digest();
            StringBuilder hexString = new StringBuilder();
            // 字节数组转换为十六进制数
            for (byte b : messageDigest) {
                String shaHex = Integer.toHexString(b & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
