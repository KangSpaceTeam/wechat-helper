package org.kangspace.wechat.helper.work.bean.agent;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.annotation.Nonnull;

/**
 * 应用管理-获取应用在工作台展示的模版-列表型 请求对象<br>
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/19
 */
@Data
@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class AgentSetWorkbenchListDataRequest extends AgentSetWorkbenchDataRequest {
    @JsonIgnore
    public final String TYPE = "list";
    /**
     * 模版类型，目前支持的自定义类型包括 "keydata"、 "image"、 "list"、 "webview" 。若设置的type为 "normal",则相当于从自定义模式切换为普通宫格或者列表展示模式
     */
    @Nonnull
    @JsonProperty("type")
    private final String type = TYPE;

    /**
     * 若type指定为 "list"，且需要设置企业级别默认数据，则需要设置列表型模版数据,数据结构参考“列表型”
     */
    @JsonProperty("list")
    private ListItems list;
}
