package org.kangspace.wechat.helper.core.util;

import java.util.ArrayList;

public class ByteGroup {

    private ArrayList<Byte> byteContainer = new ArrayList<>();

    /**
     * 转换为byte[]
     *
     * @return byte[]
     */
    public byte[] toBytes() {
        byte[] bytes = new byte[byteContainer.size()];
        for (int i = 0; i < byteContainer.size(); i++) {
            bytes[i] = byteContainer.get(i);
        }
        return bytes;
    }

    /**
     * 添加byte[]
     *
     * @param bytes byte[]
     * @return {@link ByteGroup}
     */
    public ByteGroup addBytes(byte[] bytes) {
        for (byte b : bytes) {
            byteContainer.add(b);
        }
        return this;
    }

    /**
     * byte[] 大小
     *
     * @return int
     */
    public int size() {
        return byteContainer.size();
    }
}
