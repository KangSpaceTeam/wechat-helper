package org.kangspace.wechat.helper.core.constant;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * Api配置文件相关常量
 *
 * @author kango2gler@gmail.com
 * @since 2022/10/2
 */
public interface WeChatConstant {

    /**
     * Api基础路径前缀名称
     */
    String API_BASE_PATH_NAME = "api_base_path";
    /**
     * 成功标记
     */
    String SUCCESS_FLAG = "success";


    /**
     * oAuth认证GrateType枚举
     */
    enum OAuthGrantType {
        /**
         * 客户端认证模式
         */
        CLIENT_CREDENTIAL,
        ;

        @Override
        public String toString() {
            return super.toString().toLowerCase();
        }
    }


    /**
     * 开启状态，0代表未开启，1代表开启
     */
    enum OpenStatus {
        /**
         * 未开启
         */
        NO(0),
        /**
         * 已开启
         */
        YES(1),
        ;
        private final int value;

        OpenStatus(int value) {
            this.value = value;
        }

        @JsonValue
        public int getValue() {
            return this.value;
        }

        /**
         * 通过value获取 IsMenuOpen
         *
         * @param value value
         * @return {@link OpenStatus}
         */
        public OpenStatus parse(int value) {
            return Arrays.stream(values()).filter(t -> t.value == value).findFirst().orElse(null);
        }

        @Override
        public String toString() {
            return String.valueOf(getValue());
        }
    }

    /**
     * 是否显示封面，0为不显示，1为显示
     */
    enum ShowCover {
        /**
         * 不显示
         */
        NO(0),
        /**
         * 显示
         */
        YES(1),
        ;
        private final int value;

        ShowCover(int value) {
            this.value = value;
        }

        @JsonValue
        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(getValue());
        }
    }

    /**
     * 加密类型
     */
    enum EncryptType {
        /**
         * AES
         */
        AES;

        @JsonValue
        public String getValue() {
            return name().toLowerCase();
        }
    }

    /**
     * 公共参数名称
     */
    interface Params {
        /**
         * OpenId
         */
        String OPEN_ID = "openId";
        /**
         * appId
         */
        String APP_ID = "appId";
    }
}
