package org.kangspace.wechat.helper.core.message;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.kangspace.wechat.helper.core.constant.WeChatConstant;

import java.util.HashMap;
import java.util.Map;

/**
 * 消息解析器上下文
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/28
 */
@Getter
@Setter
@Accessors(chain = true)
public class MessageResolverContext extends HashMap<String, Object> {

    /**
     * 是否是加密消息
     */
    private Boolean encryptMessage;

    /**
     * 消息加解密对象
     */
    private MessageCipher messageCipher;

    public MessageResolverContext() {
    }

    public MessageResolverContext(Boolean encryptMessage, MessageCipher messageCipher) {
        this.messageCipher = messageCipher;
        this.encryptMessage = encryptMessage;
    }

    /**
     * 创建新的上下文对象
     *
     * @return {@link MessageResolverContext}
     */
    public static MessageResolverContext newContext() {
        return new MessageResolverContext();
    }

    /**
     * 创建新的上下文对象 <br>
     * 该字段以key为{@link WeChatConstant.Params#OPEN_ID}保存在对象中.
     *
     * @param openId openId
     * @return {@link MessageResolverContext}
     */
    public static MessageResolverContext newContext(String openId) {
        MessageResolverContext context = new MessageResolverContext();
        context.put(WeChatConstant.Params.OPEN_ID, openId);
        return context;
    }

    /**
     * 创建新的上下文对象 <br>
     *
     * @return {@link MessageResolverContext}
     */
    public static MessageResolverContext newContext(Map<String, Object> map) {
        MessageResolverContext context = new MessageResolverContext();
        context.putAll(map);
        return context;
    }

    /**
     * 获取OpenId <br>
     * 该字段以key为{@link WeChatConstant.Params#OPEN_ID}保存在对象中.
     *
     * @return openId
     */
    public String getOpenId() {
        return (String) this.get(WeChatConstant.Params.OPEN_ID);
    }


    @Override
    public String toString() {
        return "(MessageResolverContext) " + "encryptMessage=" + encryptMessage + ", " + super.toString();
    }
}
