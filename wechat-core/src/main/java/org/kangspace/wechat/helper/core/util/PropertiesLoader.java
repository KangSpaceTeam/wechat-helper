package org.kangspace.wechat.helper.core.util;

import org.kangspace.wechat.helper.core.exception.WeChatException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Properties工具类
 *
 * @author kango2gler@gmail.com
 * @since 2022/9/29
 */
public class PropertiesLoader {

    /**
     * 按文件名加载Properties
     *
     * @param fileName 文件名
     * @return {@link Properties}
     */
    public static Properties load(String fileName) {
        InputStream inputStream = PropertiesLoader.class.getClassLoader().getResourceAsStream(fileName);
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new WeChatException(e);
        }
        return properties;
    }
}
