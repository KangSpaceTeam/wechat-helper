package org.kangspace.wechat.helper.work.bean.agent;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.kangspace.wechat.helper.work.bean.WeComResponseEntity;

import javax.annotation.Nonnull;

/**
 * 应用管理-获取应用在工作台展示的模版 响应参数<br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/19
 */
@Setter
@Getter
public class AgentGetWorkbenchTemplateResponse extends WeComResponseEntity {
    /**
     * 应用id
     */
    @Nonnull
    @JsonProperty("agentid")
    private String agentId;

    /**
     * 是否覆盖用户工作台的数据。设置为true的时候，会覆盖企业所有用户当前设置的数据。若设置为false,则不会覆盖用户当前设置的所有数据。默认为false
     */
    @JsonProperty("replace_user_data")
    private Boolean replaceUserData;


    /**
     * 若type指定为 "image"，且需要设置企业级别默认数据，则需要设置图片型模版数据,数据结构参考“图片型”
     */
    @JsonProperty("image")
    private Image image;


    /**
     * 若type指定为 "list"，且需要设置企业级别默认数据，则需要设置列表型模版数据,数据结构参考“列表型” <br>
     */
    @JsonProperty("list")
    private ListItems list;

    /**
     * 若type指定为 "keydata"，且需要设置企业级别默认数据，则需要设置关键数据型模版数据,数据结构参考“关键数据型” <br>
     */
    @JsonProperty("keydata")
    private KeyData keyDta;


    /**
     * 若type指定为 "webview"，且需要设置企业级别默认数据，则需要设置webview型模版数据,数据结构参考“webview型”
     */
    @JsonProperty("webview")
    private Webview webview;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "AgentGetWorkbenchTemplateResponse{" +
                        "agentId='" + agentId + '\'' +
                        ", replaceUserData='" + replaceUserData + '\'' +
                        ", image=" + image +
                        ", list=" + list +
                        ", keyDta=" + keyDta +
                        ", webview=" + webview +
                        "}"
        );
    }
}
