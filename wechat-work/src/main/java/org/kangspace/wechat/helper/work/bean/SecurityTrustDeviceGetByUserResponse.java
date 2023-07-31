package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 安全管理-设备管理-获取成员使用设备 响应参数<br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/31
 */
@Setter
@Getter
public class SecurityTrustDeviceGetByUserResponse extends WeComResponseEntity {

    /**
     * 设备列表
     */
    @JsonProperty("device_list")
    private List<Device> deviceList;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "SecurityTrustDeviceGetByUserResponse{" +
                        "deviceList=" + deviceList +
                        "}"
        );
    }

    @Data
    public static class Device {
        /**
         * 设备编码
         */
        @JsonProperty("device_code")
        private String deviceCode;
        /**
         * 设备的类型，Windows或Mac
         */
        @JsonProperty("system")
        private String system;
        /**
         * 设备MAC地址
         */
        @JsonProperty("mac_addr")
        private List<String> macAddr;
        /**
         * 主板UUID
         */
        @JsonProperty("motherboard_uuid")
        private String motherBoardUuid;
        /**
         * 硬盘UUID
         */
        @JsonProperty("harddisk_uuid")
        private List<String> hardDiskUuid;
        /**
         * Windows域
         */
        @JsonProperty("domain")
        private String domain;
        /**
         * 计算机名
         */
        @JsonProperty("pc_name")
        private String pcName;
        /**
         * Mac序列号
         */
        @JsonProperty("seq_no")
        private String seqNo;
        /**
         * 设备最后登录时间戳
         */
        @JsonProperty("last_login_time")
        private Integer lastLoginTime;
        /**
         * 设备最后登录成员userid
         */
        @JsonProperty("last_login_userid")
        private String lastLoginUserid;
        /**
         * 设备归属/确认时间戳
         */
        @JsonProperty("confirm_timestamp")
        private Integer confirmTimestamp;
        /**
         * 设备归属/确认成员userid
         */
        @JsonProperty("confirm_userid")
        private String confirmUserid;
        /**
         * 设备来源 0-未知 1-成员确认 2-管理员导入 3-成员自主申报
         */
        @JsonProperty("source")
        private Integer source;
        /**
         * 设备状态 1-已导入未登录 2-待邀请 3-待管理员确认为企业设备 4-待管理员确认为个人设备 5-已确认为可信企业设备 6-已确认为可信个人设备
         */
        @JsonProperty("status")
        private Integer status;
    }
}
