package org.kangspace.wechat.helper.core.util;

import io.netty.buffer.ByteBuf;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * IO流工具类
 *
 * @author kango2gler@gmail.com
 * @since 2023/1/17
 */
@Slf4j
public class IoStreamUtil {
    /**
     * 默认临时文件目录配置名
     */
    public static String DEFAULT_TEMP_DIR_PROPERTY_NAME = "java.io.tmpdir";
    /**
     * 当前项目临时目录名
     */
    public static String DEFAULT_WECHAT_HELPER_TEMP_DIR_PROPERTY_NAME = ".wechat-helper";


    /**
     * 获取系统临时目录
     *
     * @return 系统临时目录
     */
    public static String getSystemTempDir() {
        return System.getProperty(DEFAULT_TEMP_DIR_PROPERTY_NAME);
    }

    /**
     * 获取当前项目在系统临时目录中使用的目录
     *
     * @return 系统临时目录
     */
    public static String getWeChatHelperTempDir() {
        return getSystemTempDir() + File.separator + DEFAULT_WECHAT_HELPER_TEMP_DIR_PROPERTY_NAME;
    }

    /**
     * file转换为输入流
     *
     * @param file 文件
     * @return {@link InputStream}
     */
    public static InputStream toInputStream(File file) {
        try {
            return Files.newInputStream(file.toPath(), StandardOpenOption.READ);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 保存文件
     *
     * @param fileName 文件名
     * @param path     文件路径
     * @param body     文件流
     * @return 文件
     */
    public static File save(String fileName, String path, ByteBuf body) {
        File file = new File(path + File.separator + fileName);
        try {
            Files.createDirectories(file.getParentFile().toPath());
            Path filePath = file.toPath();
            try (FileChannel channel = FileChannel.open(filePath, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING)) {
                channel.write(body.nioBuffer());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return file;
    }
}
