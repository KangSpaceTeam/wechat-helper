package org.kangspace.wechat.helper.work.message.push.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * 消息推送-更新模版卡片消息 请求对象
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/3
 */
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@ToString(callSuper = true)
public abstract class UpdateTemplateCardMessage {

    /**
     * 企业的成员ID列表（最多支持1000个）
     */
    @JsonProperty("userids")
    private List<String> userIds;
    /**
     * 企业的部门ID列表（最多支持100个）
     */
    @JsonProperty("partyids")
    private List<Long> partyIds;
    /**
     * 应用的agentid
     */
    @Nonnull
    @JsonProperty("agentid")
    private String agentId;
    /**
     * 更新卡片所需要消费的code，可通过发消息接口和回调接口返回值获取，一个code只能调用一次该接口，且只能在72小时内调用
     */
    @Nonnull
    @JsonProperty("response_code")
    private String responseCode;

}
