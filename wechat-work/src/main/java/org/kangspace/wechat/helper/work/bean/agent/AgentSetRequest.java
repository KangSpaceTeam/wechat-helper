package org.kangspace.wechat.helper.work.bean.agent;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.annotation.Nonnull;

/**
 * 应用管理-设置应用 请求对象<br>
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/19
 */
@Data
@Builder
public class AgentSetRequest {
    /**
     * 企业应用的id
     */
    @Nonnull
    @JsonProperty("agentid")
    private Integer agentId;
    /**
     * 企业应用是否打开地理位置上报 0：不上报；1：进入会话上报；
     */
    @JsonProperty("report_location_flag")
    private Integer reportLocationFlag;
    /**
     * 企业应用头像的mediaid，通过素材管理接口上传图片获得mediaid，上传后会自动裁剪成方形和圆形两个头像
     */
    @JsonProperty("logo_mediaid")
    private String logoMediaId;
    /**
     * 企业应用名称，长度不超过32个utf8字符
     */
    @JsonProperty("name")
    private String name;
    /**
     * 企业应用详情，长度为4至120个utf8字符
     */
    @JsonProperty("description")
    private String description;
    /**
     * 企业应用可信域名。注意：域名需通过所有权校验，否则jssdk功能将受限，此时返回错误码85005
     */
    @JsonProperty("redirect_domain")
    private String redirectDomain;
    /**
     * 是否上报用户进入应用事件。0：不接收；1：接收。
     */
    @JsonProperty("isreportenter")
    private Integer isReportEnter;
    /**
     * 应用主页url。url必须以http或者https开头（为了提高安全性，建议使用https）。
     */
    @JsonProperty("home_url")
    private String homeUrl;
}
