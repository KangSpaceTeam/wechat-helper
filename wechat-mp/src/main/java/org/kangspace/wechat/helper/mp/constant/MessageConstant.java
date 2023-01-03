package org.kangspace.wechat.helper.mp.constant;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 基础消息能力-常量
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/11
 */
public interface MessageConstant {
    /**
     * 行业枚举
     */
    enum Industry {
        /**
         * IT科技
         */
        CODE_1("1", "电子商务", "互联网/IT科技"),
        /**
         * IT软件与服务
         */
        CODE_2("2", "IT科技", "IT软件与服务"),
        /**
         * IT硬件与设备
         */
        CODE_3("3", "IT科技", "IT硬件与设备"),
        /**
         * 电子技术
         */
        CODE_4("4", "IT科技", "电子技术"),
        /**
         * 通信与运营商
         */
        CODE_5("5", "IT科技", "通信与运营商"),
        /**
         * 网络游戏
         */
        CODE_6("6", "IT科技", "网络游戏"),
        /**
         * 银行
         */
        CODE_7("7", "金融业", "银行"),
        /**
         * 基金理财信托
         */
        CODE_8("8", "金融业", "基金理财信托"),
        /**
         * 保险
         */
        CODE_9("9", "金融业", "保险"),
        /**
         * 餐饮
         */
        CODE_10("10", "餐饮", "餐饮"),
        /**
         * 酒店
         */
        CODE_11("11", "酒店旅游", "酒店"),
        /**
         * 旅游
         */
        CODE_12("12", "酒店旅游", "旅游"),
        /**
         * 快递
         */
        CODE_13("13", "运输与仓储", "快递"),
        /**
         * 物流
         */
        CODE_14("14", "运输与仓储", "物流"),
        /**
         * 仓储
         */
        CODE_15("15", "运输与仓储", "仓储"),
        /**
         * 培训
         */
        CODE_16("16", "教育", "培训"),
        /**
         * 院校
         */
        CODE_17("17", "教育", "院校"),
        /**
         * 学术科研
         */
        CODE_18("18", "政府与公共事业", "学术科研"),
        /**
         * 交警
         */
        CODE_19("19", "政府与公共事业", "交警"),
        /**
         * 博物馆
         */
        CODE_20("20", "政府与公共事业", "博物馆"),
        /**
         * 公共事业非盈利机构
         */
        CODE_21("21", "政府与公共事业", "公共事业非盈利机构"),
        /**
         * 医药医疗
         */
        CODE_22("22", "医药护理", "医药医疗"),
        /**
         * 护理美容
         */
        CODE_23("23", "医药护理", "护理美容"),
        /**
         * 保健与卫生
         */
        CODE_24("24", "医药护理", "保健与卫生"),
        /**
         * 汽车相关
         */
        CODE_25("25", "交通工具", "汽车相关"),
        /**
         * 摩托车相关
         */
        CODE_26("26", "交通工具", "摩托车相关"),
        /**
         * 火车相关
         */
        CODE_27("27", "交通工具", "火车相关"),
        /**
         * 飞机相关
         */
        CODE_28("28", "交通工具", "飞机相关"),
        /**
         * 建筑
         */
        CODE_29("29", "房地产", "建筑"),
        /**
         * 物业
         */
        CODE_30("30", "房地产", "物业"),
        /**
         * 消费品
         */
        CODE_31("31", "消费品", "消费品"),
        /**
         * 法律
         */
        CODE_32("32", "商业服务", "法律"),
        /**
         * 会展
         */
        CODE_33("33", "商业服务", "会展"),
        /**
         * 中介服务
         */
        CODE_34("34", "商业服务", "中介服务"),
        /**
         * 认证
         */
        CODE_35("35", "商业服务", "认证"),
        /**
         * 审计
         */
        CODE_36("36", "商业服务", "审计"),
        /**
         * 传媒
         */
        CODE_37("37", "文体娱乐", "传媒"),
        /**
         * 体育
         */
        CODE_38("38", "文体娱乐", "体育"),
        /**
         * 娱乐休闲
         */
        CODE_39("39", "文体娱乐", "娱乐休闲"),
        /**
         * 印刷
         */
        CODE_40("40", "印刷", "印刷"),
        /**
         * 其它
         */
        CODE_41("41", "其它", "其它"),
        ;

        private final String code;
        private final String first;
        private final String second;

        Industry(String code, String first, String second) {
            this.code = code;
            this.first = first;
            this.second = second;
        }

        @JsonValue
        public String getCode() {
            return code;
        }

        public String getFirst() {
            return first;
        }

        public String getSecond() {
            return second;
        }
    }

    /**
     * 消息颜色
     */
    enum Color {
        /**
         * 默认颜色: 黑色
         */
        DEFAULT("#000000"),
        /**
         * 默认蓝色
         */
        DEFAULT_BLUE("#173177"),
        /**
         * 默认红色
         */
        DEFAULT_RED("#FF0000"),
        /**
         * 默认橙色
         */
        DEFAULT_ORANGE("#FFA500"),
        ;
        private final String color;

        Color(String color) {
            this.color = color;
        }

        @JsonValue
        public String getColor() {
            return color;
        }
    }

    /**
     * 消息类型
     */
    enum MessageType {
        /**
         * 事件消息: event
         */
        EVENT,
        /**
         * 文本消息: text
         */
        TEXT,
        /**
         * 图片消息: image
         */
        IMAGE,
        /**
         * 语音消息: voice
         */
        VOICE,
        /**
         * 视频消息: video
         */
        VIDEO,
        /**
         * 小视频消息:shortvideo
         */
        SHORTVIDEO,
        /**
         * 地理位置消息: location
         */
        LOCATION,
        /**
         * 链接消息: link
         */
        LINK,
        /**
         * 音乐消息
         */
        MUSIC,
        /**
         * 图文消息
         */
        NEWS,
        ;

        @JsonValue
        public String getValue() {
            return this.name().toLowerCase();
        }

    }
}
