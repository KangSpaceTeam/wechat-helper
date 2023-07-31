package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.annotation.Nonnull;

/**
 * 安全管理-设备管理-获取设备信息 请求对象
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/31
 */
@Data
@Builder
public class SecurityTrustDeviceListRequest {
    /**
     * 分页cursor,用于获取分页数据
     */
    @JsonProperty("cursor")
    private String cursor;
    /**
     * 查询设备类型，1-可信企业设备 2-未知设备 3-可信个人设备
     */
    @Nonnull
    @JsonProperty("type")
    private Integer type;
    /**
     * 查询返回的最大记录数，最高不超过100，默认为100
     */
    @JsonProperty("limit")
    private Integer limit;

    public SecurityTrustDeviceListRequest(String cursor, @Nonnull Integer type, Integer limit) {
        this.cursor = cursor;
        this.type = type;
        this.limit = limit;
    }

    public SecurityTrustDeviceListRequest() {
    }
}
