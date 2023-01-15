package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;
import lombok.ToString;

import javax.annotation.Nonnull;

/**
 * 网络检测请求参数
 * <pre>
 * 如:
 * {
 *     "action": "all",
 *     "check_operator": "DEFAULT"
 * }
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/24
 */
@Data
@ToString(callSuper = true)
public class CallbackCheckRequest {
    /**
     * 执行的检测动作，允许的值：dns（做域名解析）、ping（做 ping 检测）、all（dns和 ping 都做）,
     * 必填
     */
    @Nonnull
    private Action action;
    /**
     * 指定平台从某个运营商进行检测，允许的值：CHINANET（电信出口）、UNICOM（联通出口）、CAP（腾讯自建出口）、DEFAULT（根据 ip 来选择运营商）,
     * 必填
     */
    @Nonnull
    @JsonProperty("check_operator")
    private CheckOperator checkOperator;

    public CallbackCheckRequest() {
    }

    public CallbackCheckRequest(@Nonnull Action action, @Nonnull CheckOperator checkOperator) {
        this.action = action;
        this.checkOperator = checkOperator;
    }

    public enum Action {
        /**
         * dns（做域名解析）
         */
        DNS,
        /**
         * ping（做 ping 检测）
         */
        PING,
        /**
         * all（dns和 ping 都做）
         */
        ALL;

        @JsonValue
        public String getValue() {
            return this.name().toLowerCase();
        }
    }

    public enum CheckOperator {
        /**
         * CHINANET（电信出口）
         */
        CHINANET,
        /**
         * UNICOM（联通出口）
         */
        UNICOM,
        /**
         * CAP（腾讯自建出口）
         */
        CAP,
        /**
         * DEFAULT（根据 ip 来选择运营商）
         */
        DEFAULT
    }
}
