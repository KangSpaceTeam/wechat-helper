package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * 企业互联-获取应用共享信息 请求对象<br>
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/30
 */
@Data
@Builder
public class CorpGroupCorpListAppShareInfoRequest {

    /**
     * 填0则为企业互联/局校互联，填1则表示上下游企业
     */
    @JsonProperty("business_type")
    private Integer businessType;

    /**
     * 上级/上游企业应用agentid
     */
    @JsonProperty("agentid")
    private String agentId;

    /**
     * 下级/下游企业corpid，若指定该参数则表示拉取该下级/下游企业的应用共享信息
     */
    @JsonProperty("corpid")
    private String corpId;

    /**
     * 返回的最大记录数，整型，最大值100，默认情况或者值为0表示下拉取全量数据，建议分页拉取或者通过指定corpid参数拉取。
     */
    @JsonProperty("limit")
    private Integer limit;

    /**
     * 用于分页查询的游标，字符串类型，由上一次调用返回，首次调用可不填
     */
    @JsonProperty("cursor")
    private String cursor;

    public CorpGroupCorpListAppShareInfoRequest() {
    }
}
