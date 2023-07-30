package org.kangspace.wechat.helper.work;

import org.kangspace.wechat.helper.work.bean.*;

/**
 * 企业微信"企业互联"相关 Service <br>
 * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/93360">https://developer.work.weixin.qq.com/document/path/93360</a> <br>
 * @author kango2gler@gmail.com
 * @since 2023/07/30
 */
public interface CorpGroupService extends WeComService {

    /**
     * 企业互联-获取应用共享信息 <br>
     * 局校互联中的局端或者上下游中的上游企业通过该接口可以获取某个应用分享给的所有企业列表。<br>
     * @param request {@link CorpGroupCorpListAppShareInfoRequest}
     * @return {@link CorpGroupCorpListAppShareInfoResponse}
     */
    CorpGroupCorpListAppShareInfoResponse corpGroupCorpListAppShareInfo(CorpGroupCorpListAppShareInfoRequest request);

    /**
     * 企业互联-获取下级/下游企业的access_token
     * @param request {@link CorpGroupCorpGetTokenRequest}
     * @return {@link CorpGroupCorpGetTokenResponse}
     */
    CorpGroupCorpGetTokenResponse corpGroupCorpGetToken(CorpGroupCorpGetTokenRequest request);

    /**
     * 企业互联-获取下级/下游企业小程序session
     * @param request {@link MiniProgramTransferSessionRequest}
     * @return {@link MiniProgramTransferSessionResponse}
     */
    MiniProgramTransferSessionResponse miniProgramTransferSession(MiniProgramTransferSessionRequest request);
}
