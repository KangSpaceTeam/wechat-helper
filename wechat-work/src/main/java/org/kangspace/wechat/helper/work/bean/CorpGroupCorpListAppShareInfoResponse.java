package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 企业互联-获取应用共享信息 响应参数<br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/30
 */
@Setter
@Getter
public class CorpGroupCorpListAppShareInfoResponse extends WeComResponseEntity {
    /**
     * 应用共享信息
     */
    @JsonProperty("corp_list")
    private List<Corp> corpList;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "CorpGroupCorpListAppShareInfoResponse{" +
                        "corpList=" + corpList +
                        "}"
        );
    }

    @Data
    public static class Corp {
        /**
         * 下级/下游企业corpid
         */
        @JsonProperty("corpid")
        private String corpId;

        /**
         * 下级/下游企业名称
         */
        @JsonProperty("corpName")
        private String corp_name;

        /**
         * 下级/下游企业应用id
         */
        @JsonProperty("agentid")
        private String agentId;
    }

}
