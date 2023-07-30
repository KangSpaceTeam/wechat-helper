package org.kangspace.wechat.helper.work.bean;

import lombok.Getter;
import lombok.Setter;
import org.kangspace.wechat.helper.core.token.AccessTokenResponse;

/**
 * 企业互联-获取下级/下游企业的access_token 响应参数<br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/30
 */
@Setter
@Getter
public class CorpGroupCorpGetTokenResponse extends AccessTokenResponse {
    @Override
    public String toString() {
        return super.toString();
    }
}
