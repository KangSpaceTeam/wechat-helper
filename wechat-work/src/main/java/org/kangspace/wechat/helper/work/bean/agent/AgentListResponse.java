package org.kangspace.wechat.helper.work.bean.agent;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.kangspace.wechat.helper.work.bean.WeComResponseEntity;

import java.util.List;

/**
 * 应用管理-获取access_token对应的应用列表 响应参数<br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/19
 */
@Setter
@Getter
public class AgentListResponse extends WeComResponseEntity {
    /**
     * 当前凭证可访问的应用列表
     */
    @JsonProperty("agentlist")
    private List<AgentItem> agentList;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "AgentListResponse{" +
                        "agentList=" + agentList +
                        "}"
        );
    }

    @Data
    public static class AgentItem {
        /**
         * 企业应用id
         */
        @JsonProperty("agentid")
        private Integer agentId;
        /**
         * 企业应用名称
         */
        @JsonProperty("name")
        private String name;
        /**
         * 企业应用方形头像url
         */
        @JsonProperty("square_logo_url")
        private String squareLogoUrl;
    }
}
