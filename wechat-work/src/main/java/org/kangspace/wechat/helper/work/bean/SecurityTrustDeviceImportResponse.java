package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 安全管理-设备管理-导入可信企业设备 响应参数<br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/31
 */
@Setter
@Getter
public class SecurityTrustDeviceImportResponse extends WeComResponseEntity {
    /**
     *
     */
    @JsonProperty("result")
    private List<Device> result;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "SecurityTrustDeviceImportResponse{" +
                        "result=" + result +
                        "}"
        );
    }

    @Data
    public static class Device {
        /**
         * 导入设备记录的标识，对应请求中设备的顺序，从1开始
         */
        @JsonProperty("device_index")
        private String deviceIndex;
        /**
         * 设备的唯一标识，仅导入成功的记录返回
         */
        @JsonProperty("device_code")
        private String deviceCode;
        /**
         * 导入结果，1-成功 2-重复导入 3-不支持的设备 4-数据格式错误
         */
        @JsonProperty("status")
        private String status;
    }
}
