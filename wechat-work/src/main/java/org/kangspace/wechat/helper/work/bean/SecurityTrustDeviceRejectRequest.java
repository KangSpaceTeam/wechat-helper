package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * 安全管理-设备管理-驳回可信设备申请 请求对象
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/31
 */
@Data
@Builder
public class SecurityTrustDeviceRejectRequest {
    /**
     * 设备编码列表
     */
    @Nonnull
    @JsonProperty("device_code_list")
    private List<String> deviceCodeList;

    public SecurityTrustDeviceRejectRequest(@Nonnull List<String> deviceCodeList) {
        this.deviceCodeList = deviceCodeList;
    }

    public SecurityTrustDeviceRejectRequest() {
    }
}
