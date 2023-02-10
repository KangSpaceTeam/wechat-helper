package org.kangspace.wechat.helper.mp.constant;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 订阅通知常量
 *
 * @author kango2gler@gmail.com
 * @since 2023/02/08 22:59
 */
public interface SubscriptionMessagesConstant {

    /**
     * 用户点击行为（同意、取消发送通知）
     */
    enum SubscribeStatusString {
        /**
         * 用户点击“同意”
         */
        ACCEPT,
        /**
         * 用户点击“取消”
         */
        REJECT;

        /**
         * 获取用户点击行为值
         *
         * @return 用户点击行为值
         */
        @JsonValue
        public String getValue() {
            return this.name().toLowerCase();
        }
    }

    /**
     * 场景
     */
    enum PopupScene {
        /**
         * 弹窗来自 H5 页面
         */
        H5(1),
        /**
         * 弹窗来自图文消息
         */
        NEWS(2);

        /**
         * value
         */
        private final Integer value;

        PopupScene(Integer value) {
            this.value = value;
        }

        @JsonValue
        public Integer getValue() {
            return value;
        }
    }

    /**
     * 模版类型
     */
    enum TemplateType {
        /**
         * 一次性订阅
         */
        DISPOSABLE(2),
        /**
         * 为长期订阅
         */
        LONG(3);

        private final Integer type;

        TemplateType(Integer type) {
            this.type = type;
        }

        @JsonValue
        public Integer getType() {
            return type;
        }
    }
}
