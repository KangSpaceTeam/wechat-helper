package org.kangspace.wechat.helper.work.bean.agent;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.kangspace.wechat.helper.work.bean.WeComResponseEntity;

import java.util.List;

/**
 * 应用管理-获取指定的应用详情 响应参数<br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/19
 */
@Setter
@Getter
public class AgentGetResponse extends WeComResponseEntity {

    /**
     * 企业应用id
     */
    @JsonProperty("agentid")
    private String agentId;
    /**
     * 企业应用名称
     */
    @JsonProperty("name")
    private String name;
    /**
     * 企业应用方形头像
     */
    @JsonProperty("square_logo_url")
    private String squareLogoUrl;
    /**
     * 企业应用详情
     */
    @JsonProperty("description")
    private String description;
    /**
     * 企业应用可见范围（人员），其中包括userid
     */
    @JsonProperty("allow_userinfos")
    private UserInfos allowUserInfos;
    /**
     * 企业应用可见范围（部门）
     */
    @JsonProperty("allow_partys")
    private Partys allowPartys;
    /**
     * 企业应用可见范围（标签）
     */
    @JsonProperty("allow_tags")
    private Tags allowTags;
    /**
     * 企业应用是否被停用。0：未被停用；1：被停用
     */
    @JsonProperty("close")
    private Integer close;
    /**
     * 企业应用可信域名
     */
    @JsonProperty("redirect_domain")
    private String redirectDomain;
    /**
     * 企业应用是否打开地理位置上报 0：不上报；1：进入会话上报；
     */
    @JsonProperty("report_location_flag")
    private Integer reportLocationFlag;
    /**
     * 是否上报用户进入应用事件。0：不接收；1：接收
     */
    @JsonProperty("isreportenter")
    private Integer isReportEnter;
    /**
     * 应用主页url
     */
    @JsonProperty("home_url")
    private String homeUrl;
    /**
     * 代开发自建应用返回该字段，表示代开发发布状态。0：待开发（企业已授权，服务商未创建应用）；1：开发中（服务商已创建应用，未上线）；2：已上线（服务商已上线应用且不存在未上线版本）；3：存在未上线版本（服务商已上线应用但存在未上线版本）
     */
    @JsonProperty("customized_publish_status")
    private Integer customizedPublishStatus;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "AgentGetResponse{" +
                        "agentId='" + agentId + '\'' +
                        ", name='" + name + '\'' +
                        ", squareLogoUrl='" + squareLogoUrl + '\'' +
                        ", description='" + description + '\'' +
                        ", allowUserInfos=" + allowUserInfos +
                        ", allowPartys=" + allowPartys +
                        ", allowTags=" + allowTags +
                        ", close=" + close +
                        ", redirectDomain='" + redirectDomain + '\'' +
                        ", reportLocationFlag=" + reportLocationFlag +
                        ", isReportEnter=" + isReportEnter +
                        ", homeUrl='" + homeUrl + '\'' +
                        ", customizedPublishStatus=" + customizedPublishStatus +
                        "}"
        );
    }

    @Data
    public static class UserInfos {
        @JsonProperty("user")
        List<UserInfo> user;
    }

    @Data
    public static class UserInfo {
        @JsonProperty("userid")
        private String userId;
    }

    @Data
    public static class Partys {
        @JsonProperty("partyid")
        private List<Long> partyId;
    }

    @Data
    public static class Tags {
        @JsonProperty("tagid")
        private List<Long> tagId;
    }
}
