package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * 邀请成员 请求对象<br>
 * user, party, tag三者不能同时为空；<br>
 * 如果部分接收人无权限或不存在，邀请仍然执行，但会返回无效的部分（即invaliduser或invalidparty或invalidtag）;<br>
 * 同一用户只须邀请一次，被邀请的用户如果未安装企业微信，在3天内每天会收到一次通知，最多持续3天。<br>
 * 因为邀请频率是异步检查的，所以调用接口返回成功，并不代表接收者一定能收到邀请消息（可能受上述频率限制无法接收）。<br>
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/20
 */
@Data
@Builder
public class BatchInviteRequest {
    /**
     * 成员ID列表, 最多支持1000个。
     */
    @JsonProperty("user")
    private List<String> user;
    /**
     * 部门ID列表，最多支持100个。
     */
    @JsonProperty("party")
    private List<Long> party;
    /**
     * 标签ID列表，最多支持100个。
     */
    @JsonProperty("tag")
    private List<String> tag;

    public BatchInviteRequest(List<String> user, List<Long> party, List<String> tag) {
        this.user = user;
        this.party = party;
        this.tag = tag;
    }

    public BatchInviteRequest() {
    }
}
