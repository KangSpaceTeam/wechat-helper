package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * 安全管理-设备管理-导入可信企业设备 请求对象
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/31
 */
@Data
@Builder
public class SecurityTrustDeviceImportRequest {
    @JsonProperty("device_list")
    private List<Device> deviceList;

    @Data
    public static class Device {
        /**
         * 设备的类型，Windows或Mac
         */
        @JsonProperty("system")
        private String system;
        /**
         * 设备MAC地址，当system为Windows时必填，Mac选填，每个设备最多100个
         */
        @JsonProperty("mac_addr")
        private List<String> macAddr;
        /**
         * 主板UUID，当system为Windows可选填此参数
         */
        @JsonProperty("motherboard_uuid")
        private String motherBoardUuid;
        /**
         * 硬盘序列号，当system为Windows时可选填此参数，每个设备最多100个
         */
        @JsonProperty("harddisk_uuid")
        private List<String> hardDiskUuid;
        /**
         * Windows域名，当system为Windows时可选填此参数
         */
        @JsonProperty("domain")
        private String domain;
        /**
         * Windows计算机名，当system为Windows时可选填此参数
         */
        @JsonProperty("pc_name")
        private String pcName;
        /**
         * Mac序列号，当system为Mac时必填
         */
        @JsonProperty("seq_no")
        private String seqNo;
    }
}
