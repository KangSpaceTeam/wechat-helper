package org.kangspace.wechat.helper.work;

import org.kangspace.wechat.helper.core.request.filter.RequestFilterChain;
import org.kangspace.wechat.helper.work.bean.*;
import org.kangspace.wechat.helper.work.config.WeComConfig;
import org.kangspace.wechat.helper.work.constant.WeComApiPaths;
import org.kangspace.wechat.helper.work.token.WeComAccessTokenService;

/**
 * <p>
 * 企业微信"帐号ID"相关 Service默认实现
 * </p>
 *
 * @author kango2gler@gmail.com
 * @since 2023/6/27
 */
public class DefaultWeComIDService extends AbstractWeComService implements WeComIDService {

    public DefaultWeComIDService(WeComConfig weChatConfig) {
        super(weChatConfig);
    }

    public DefaultWeComIDService(WeComAccessTokenService weComAccessTokenService) {
        super(weComAccessTokenService);
    }

    public DefaultWeComIDService(WeComAccessTokenService weComAccessTokenService, RequestFilterChain requestFilterChain) {
        super(weComAccessTokenService, requestFilterChain);
    }

    @Override
    public BatchOpenUserIdToUserIdResponse batchOpenUserIdToUserId(BatchOpenUserIdToUserIdRequest request) {
        String url = WeComApiPaths.BATCH_OPEN_USERID_TO_USERID;
        return post(url,request, BatchOpenUserIdToUserIdResponse.class);
    }

    @Override
    public FromServiceExternalUserIdResponse externalContactFromServiceExternalUserId(FromServiceExternalUserIdRequest request) {
        String url = WeComApiPaths.EXTERNAL_CONTACT_FROM_SERVICE_EXTERNAL_USERID;
        return post(url,request, FromServiceExternalUserIdResponse.class);
    }

    @Override
    public ConvertTmpExternalUserIdResponse idConvertConvertTmpExternalUserId(ConvertTmpExternalUserIdRequest request) {
        String url = WeComApiPaths.ID_CONVERT_CONVERT_TMP_EXTERNAL_USERID;
        return post(url,request, ConvertTmpExternalUserIdResponse.class);
    }
}
