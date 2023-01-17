package org.kangspace.wechat.helper.core.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

/**
 * IO流工具泪
 *
 * @author kango2gler@gmail.com
 * @since 2023/1/17
 */
public class IOStreamUtil {


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
}
