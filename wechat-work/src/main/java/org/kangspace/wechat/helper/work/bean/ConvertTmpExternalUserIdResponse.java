package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 帐号ID 接口-自建应用与第三方应用的对接-userid转换 响应参数
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/2
 */
@Getter
@Setter
public class ConvertTmpExternalUserIdResponse extends WeComResponseEntity{

    /**
     * 	转换成功的结果列表
     */
    @JsonProperty("results")
    private List<Result> results;

    /**
     * 无法转换的tmp_external_userid。可能非法或没有权限
     */
    @JsonProperty("invalid_tmp_external_userid_list")
    private List<String> invalidTmpExternalUserIdList;


    public ConvertTmpExternalUserIdResponse() {
    }

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "ConvertTmpExternalUserIdResponse{" +
                        "results=" + results +
                        ", invalidTmpExternalUserIdList=" + invalidTmpExternalUserIdList +
                        "}"
        );
    }

    @Data
    public static class Result {
        /**
         * 输入的tmp_external_userid
         */
        @JsonProperty("tmp_external_userid")
        private String tmpExternalUserId;

        /**
         * 转换后的userid，user_type为1时返回
         */
        @JsonProperty("external_userid")
        private String externalUserId;

        /**
         * 	userid对应的corpid，user_type为2、3、4时返回
         */
        @JsonProperty("corpid")
        private String corpId;

        /**
         * 转换后的userid，user_type为2、3、4时返回
         */
        @JsonProperty("userid")
        private String userId;

    }

}
