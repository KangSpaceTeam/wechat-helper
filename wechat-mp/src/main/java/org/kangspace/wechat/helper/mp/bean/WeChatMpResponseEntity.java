package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.kangspace.wechat.helper.core.bean.WeChatResponseEntity;

/**
 * 微信公众号响应对象
 * <pre>
 * 如:{"errcode":40013,"errmsg":"invalid appid"}
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/24
 */
@Data
public class WeChatMpResponseEntity extends WeChatResponseEntity {

    /**
     * 错误码
     */
    @JsonProperty("errcode")
    private String errCode;

    /**
     * 错误消息
     */
    @JsonProperty("errmsg")
    private String errMsg;
}
