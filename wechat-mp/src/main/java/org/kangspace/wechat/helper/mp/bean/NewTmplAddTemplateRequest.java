package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.kangspace.wechat.helper.mp.constant.WeChatMpApiPaths;

import javax.annotation.Nonnull;

/**
 * 订阅通知接口-addTemplate选用模板请求对象
 *
 * @author kango2gler@gmail.com
 * @see WeChatMpApiPaths#NEW_TMPL_ADD_TEMPLATE
 * @since 2023/02/09 22:57
 */
@Data
public class NewTmplAddTemplateRequest {
    /**
     * 模板标题 id，可通过 getPubTemplateTitleList 接口获取，也可登录公众号后台查看获取。
     * 必填:是
     */
    @Nonnull
    @JsonProperty("tid")
    private String tId;

    /**
     * 开发者自行组合好的模板关键词列表，关键词顺序可以自由搭配（例如 [3,5,4] 或 [4,5,3]），最多支持5个，最少2个关键词组合。
     * 必填: 是
     */
    @Nonnull
    @JsonProperty("kidList")
    private String kIdList;

    /**
     * 服务场景描述，15个字以内。
     * 必填:是
     */
    @Nonnull
    @JsonProperty("sceneDesc")
    private String sceneDesc;
}
