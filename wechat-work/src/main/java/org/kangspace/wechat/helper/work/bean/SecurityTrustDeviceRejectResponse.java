package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 安全管理-设备管理-驳回可信设备申请 响应参数<br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/31
 */
@Setter
@Getter
public class SecurityTrustDeviceRejectResponse extends WeComResponseEntity {
    /**
     * 驳回成功设备code列表
     */
    @JsonProperty("success_list")
    private String successList;

    /**
     * 驳回失败设备code列表
     */
    @JsonProperty("fail_list")
    private String failList;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "SecurityTrustDeviceApproveResponse{" +
                        "successList='" + successList + '\'' +
                        ", failList='" + failList + '\'' +
                        "}"
        );
    }
}
