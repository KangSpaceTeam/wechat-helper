package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * 帐号ID 接口-tmp_external_userid的转换 请求参数
 * <pre>
 * 如:
 * {
 *   "business_type": 1,
 *   "user_type": 1,
 *   "tmp_external_userid_list": [
 *     "ouXXX1",
 *     "ouXXX2",
 *     "ouXXX3"
 *   ]
 * }
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/2
 */
@Data
public class ConvertTmpExternalUserIdRequest {
    /**
     * 业务类型。1-会议 2-收集表
     */
    @Nonnull
    @JsonProperty("business_type")
    private Integer businessType;
    /**
     * 转换的目标用户类型。1-客户 2-企业互联 3-上下游 4-互联企业（圈子）
     * 详见上面关于user_type的说明
     */
    @Nonnull
    @JsonProperty("user_type")
    private Integer userType;
    /**
     * 外部用户临时id，最多不超过100个
     */
    @Nonnull
    @JsonProperty("tmp_external_userid_list")
    private List<String> tmpExternalUserIdList;

    public ConvertTmpExternalUserIdRequest() {
    }

    public ConvertTmpExternalUserIdRequest(@Nonnull Integer businessType, @Nonnull Integer userType, @Nonnull List<String> tmpExternalUserIdList) {
        this.businessType = businessType;
        this.userType = userType;
        this.tmpExternalUserIdList = tmpExternalUserIdList;
    }
}
