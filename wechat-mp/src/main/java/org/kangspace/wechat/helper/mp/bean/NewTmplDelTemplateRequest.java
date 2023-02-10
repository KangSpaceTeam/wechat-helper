package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.kangspace.wechat.helper.mp.constant.WeChatMpApiPaths;

import javax.annotation.Nonnull;

/**
 * 订阅通知接口-delTemplate删除模板请求对象
 *
 * @author kango2gler@gmail.com
 * @see WeChatMpApiPaths#NEW_TMPL_DEL_TEMPLATE
 * @since 2023/02/10 23:58:56
 */
@Data
public class NewTmplDelTemplateRequest {
    /**
     * 要删除的模板id
     * 必填:是
     */
    @Nonnull
    @JsonProperty("priTmplId")
    private String priTmplId;

}
