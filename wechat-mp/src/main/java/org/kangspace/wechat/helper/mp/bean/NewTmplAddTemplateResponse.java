package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.kangspace.wechat.helper.mp.constant.WeChatMpApiPaths;

/**
 * 订阅通知接口-addTemplate选用模板响应对象<br>
 *
 * @author kango2gler@gmail.com
 * @see WeChatMpApiPaths#NEW_TMPL_ADD_TEMPLATE
 * @since 2023/02/09
 */
@Setter
@Getter
public class NewTmplAddTemplateResponse extends WeChatMpResponseEntity {
    /**
     * 添加至帐号下的模板id，发送订阅通知时所需
     */
    @JsonProperty("priTmplId")
    private String priTmplId;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "NewTmplAddTemplateResponse{" +
                        "priTmplId='" + priTmplId + '\'' +
                        "}"
        );
    }

}
