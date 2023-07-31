package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * 安全管理-设备管理-删除设备信息 请求对象
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/31
 */
@Data
@Builder
public class SecurityTrustDeviceDeleteRequest {
    /**
     * 设备编码列表
     */
    @Nonnull
    @JsonProperty("device_code_list")
    private List<String> deviceCodeList;

    /**
     * 删除设备类型，1-可信企业设备 2-未知设备 3-可信个人设备
     */
    @Nonnull
    @JsonProperty("type")
    private Integer type;

    public SecurityTrustDeviceDeleteRequest(@Nonnull List<String> deviceCodeList, @Nonnull Integer type) {
        this.deviceCodeList = deviceCodeList;
        this.type = type;
    }

    public SecurityTrustDeviceDeleteRequest() {
    }
}
