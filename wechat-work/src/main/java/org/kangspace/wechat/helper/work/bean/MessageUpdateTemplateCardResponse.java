package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 消息推送-更新模版卡片消息 响应参数<br>
 * 如果部分指定的用户无权限或不存在，更新仍然执行，但会返回无效的部分（即invaliduser），常见的原因是用户不在应用的可见范围内或者不在消息的接收范围内。<br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/3
 */
@Setter
@Getter
public class MessageUpdateTemplateCardResponse extends WeComResponseEntity {
    /**
     * 不合法的userid，不区分大小写，统一转为小写<br>
     * 如: "userid1|userid2"<br>
     */
    @JsonProperty("invaliduser")
    private List<String> invalidUser;

    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "MessageUpdateTemplateCardResponse{" +
                        "invalidUser=" + invalidUser +
                        "}"
        );
    }
}
