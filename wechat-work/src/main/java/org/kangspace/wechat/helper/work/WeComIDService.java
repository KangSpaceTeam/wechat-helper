package org.kangspace.wechat.helper.work;

import org.kangspace.wechat.helper.work.bean.*;

/**
 * 企业微信"帐号ID"相关 Service
 *
 * @author kango2gler@gmail.com
 * @since 2023/06/27
 */
public interface WeComIDService extends WeComService {

    /**
     * 帐号ID 接口-自建应用与第三方应用的对接-userid转换
     * @param request {@link BatchOpenUserIdToUserIdRequest}
     * @return {@link BatchOpenUserIdToUserIdResponse}
     */
    BatchOpenUserIdToUserIdResponse batchOpenUserIdToUserId(BatchOpenUserIdToUserIdRequest request);

    /**
     * 帐号ID 接口-自建应用与第三方应用的对接-userid转换
     * @param request {@link FromServiceExternalUserIdRequest}
     * @return {@link FromServiceExternalUserIdResponse}
     */
    FromServiceExternalUserIdResponse externalContactFromServiceExternalUserId(FromServiceExternalUserIdRequest request);

    /**
     * 帐号ID 接口-tmp_external_userid的转换
     * @param request {@link ConvertTmpExternalUserIdRequest}
     * @return {@link ConvertTmpExternalUserIdResponse}
     */
    ConvertTmpExternalUserIdResponse idConvertConvertTmpExternalUserId(ConvertTmpExternalUserIdRequest request);
}
