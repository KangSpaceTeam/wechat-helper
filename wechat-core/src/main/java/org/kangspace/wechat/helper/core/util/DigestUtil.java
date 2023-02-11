package org.kangspace.wechat.helper.core.util;

import lombok.extern.slf4j.Slf4j;
import org.kangspace.wechat.helper.core.constant.StringLiteral;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
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
     * 字母数组表
     */
    static final String ALPHA_NUMERIC_BASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    /**
     * 随机生成指定长度位字符串
     *
     * @return 字符串
     */
    public static String getRandomStr(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            int number = random.nextInt(ALPHA_NUMERIC_BASE.length());
            sb.append(ALPHA_NUMERIC_BASE.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 随机生成16位字符串
     *
     * @return 16位随机字符串
     */
    public static String get16RandomStr() {
        return getRandomStr(16);
    }

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
     * signParam转换为url参数类型再sha1
     *
     * @param signParams 签名参数
     * @return 摘要结果
     */
    public static String sha1Url(SortedMap<String, String> signParams) {
        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<String, String>> es = signParams.entrySet();
        for (Map.Entry<String, String> entry : es) {
            String k = entry.getKey();
            String v = entry.getValue();
            sb.append(k).append(StringLiteral.EQUALS).append(v).append(StringLiteral.AND);
        }
        String params = sb.substring(0, sb.lastIndexOf(StringLiteral.AND));
        log.debug("sha1Url raw: {}", params);
        return sha1(params);
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

    /**
     * AES 编码
     *
     * @param data    原始字符串
     * @param aesKey  aes key
     * @param mode    AES 模式 {@link AES.Mode}
     * @param padding AES 填充方式 {@link AES.Padding}
     * @return 编码后的字符串
     * @see Cipher
     */
    public static String aes(String data, byte[] aesKey, AES.Mode mode, AES.Padding padding) {
        byte[] encrypted = aes(data.getBytes(StandardCharsets.UTF_8), aesKey, mode, padding);
        return Base64.getEncoder().encodeToString(encrypted);
    }

    /**
     * AES 编码
     *
     * @param data    原始数据
     * @param aesKey  aes key
     * @param mode    AES 模式 {@link AES.Mode}
     * @param padding AES 填充方式 {@link AES.Padding}
     * @return 编码后的字符串
     * @see Cipher
     */
    public static byte[] aes(byte[] data, byte[] aesKey, AES.Mode mode, AES.Padding padding) {
        Objects.requireNonNull(data, "data must be not null");
        Objects.requireNonNull(aesKey, "aesKey must be not null");
        SecretKeySpec keySpec = new SecretKeySpec(aesKey, "AES");
        try {
            //"算法/模式/补码方式"
            Cipher cipher = Cipher.getInstance("AES/" + mode + "/" + padding);
            IvParameterSpec iv = new IvParameterSpec(Arrays.copyOfRange(aesKey, 0, 16));
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, iv);
            return cipher.doFinal(data);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException | InvalidAlgorithmParameterException e) {
            throw new IllegalArgumentException("can not encrypt specified data with aesKey: " + e.getMessage(), e);
        }
    }

    /**
     * AES 编码(CBC,PKCS7Padding)
     *
     * @param dataByteGroup 原始数据
     * @param aesKey        aes key
     * @return 编码后的字符串
     * @see Cipher
     */
    public static byte[] aesCBCWithPKCS7(ByteGroup dataByteGroup, byte[] aesKey) {
        Objects.requireNonNull(dataByteGroup, "dataByteGroup must be not null");
        Objects.requireNonNull(aesKey, "aesKey must be not null");
        byte[] padBytes = PKCS7Encoder.encode(dataByteGroup.size());
        dataByteGroup.addBytes(padBytes);
        return aes(dataByteGroup.toBytes(), aesKey, AES.Mode.CBC, AES.Padding.NoPadding);
    }

    /**
     * AES 解码
     *
     * @param encoded 被编码的字符串(AES)
     * @param aesKey  aes key
     * @param mode    AES 模式 {@link AES.Mode}
     * @param padding AES 填充方式 {@link AES.Padding}
     * @return 解码内容
     */
    public static byte[] deAes(String encoded, String aesKey, AES.Mode mode, AES.Padding padding) {
        return deAes(encoded.getBytes(StandardCharsets.UTF_8), aesKey.getBytes(StandardCharsets.UTF_8), mode, padding);
    }

    /**
     * AES 解码
     *
     * @param encoded 被编码的原始数据(AES)
     * @param aesKey  aes key
     * @param mode    AES 模式 {@link AES.Mode}
     * @param padding AES 填充方式 {@link AES.Padding}
     * @return 解码内容
     */
    public static byte[] deAes(byte[] encoded, byte[] aesKey, AES.Mode mode, AES.Padding padding) {
        Objects.requireNonNull(encoded, "encoded must be not null");
        Objects.requireNonNull(aesKey, "aesKey must be not null");
        SecretKeySpec keySpec = new SecretKeySpec(aesKey, "AES");
        try {
            //"算法/模式/补码方式"
            Cipher cipher = Cipher.getInstance("AES/" + mode + "/" + padding);
            IvParameterSpec iv = new IvParameterSpec(Arrays.copyOfRange(aesKey, 0, 16));
            cipher.init(Cipher.DECRYPT_MODE, keySpec, iv);
            return cipher.doFinal(encoded);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException | InvalidAlgorithmParameterException e) {
            throw new IllegalArgumentException("can not encrypt specified data with aesKey: " + e.getMessage(), e);
        }
    }

    /**
     * AES 解码(CBC,PKCS7Padding)
     *
     * @param data   原始数据(AES)
     * @param aesKey aes key
     * @return 编码后的字符串
     * @see Cipher
     */
    public static byte[] deAesCBCWithPKCS7(byte[] data, byte[] aesKey) {
        Objects.requireNonNull(data, "data must be not null");
        Objects.requireNonNull(aesKey, "aesKey must be not null");
        if (aesKey.length != 32) {
            throw new IllegalArgumentException("invalid aesKey, not 32 length. aesKey.length: " + aesKey.length);
        }
        byte[] noPaddingByte = deAes(data, aesKey, AES.Mode.CBC, AES.Padding.NoPadding);
        // 去除Padding
        return PKCS7Encoder.decode(noPaddingByte);
    }

    /**
     * encodingAESKey 转换为AES Key
     *
     * @param encodingAESKey encodingAESKey
     * @return aesKey
     */
    public static byte[] extractAESKey(String encodingAESKey) {
        return Base64.getDecoder().decode(encodingAESKey + StringLiteral.EQUALS);
    }

    /**
     * AES 解码(CBC,PKCS7Padding)
     *
     * @param data   原始数据
     * @param aesKey aes key
     * @return 编码后的字符串
     * @see Cipher
     */
    public static String deAesCBCWithPKCS7(String data, byte[] aesKey) {
        Objects.requireNonNull(data, "data must be not null");
        Objects.requireNonNull(aesKey, "aesKey must be not null");
        if (aesKey.length != 32) {
            throw new IllegalArgumentException("invalid aesKey, not 32 length.  aseKey.length: " + aesKey.length);
        }
        byte[] decodedBytes = deAesCBCWithPKCS7(data.getBytes(StandardCharsets.UTF_8), aesKey);
        return new String(decodedBytes);
    }

    /**
     * AES 相关常量,枚举
     *
     * @see Cipher
     */
    public interface AES {
        /**
         * 编码模式
         */
        enum Mode {
            /**
             * ECB（默认）
             */
            ECB,
            /**
             * CEC
             */
            CBC,
            /**
             * CFB
             */
            CFB
        }

        /**
         * 对齐填充
         */
        enum Padding {
            /**
             * NoPadding
             */
            NoPadding,
            /**
             * PKCS5Padding（默认）
             */
            PKCS5Padding,
        }
    }
}
