package org.kangspace.wechat.helper.work;

import org.kangspace.wechat.helper.work.bean.MessageRecallRequest;
import org.kangspace.wechat.helper.work.bean.MessageSendResponse;
import org.kangspace.wechat.helper.work.bean.MessageUpdateTemplateCardResponse;
import org.kangspace.wechat.helper.work.bean.WeComResponseEntity;
import org.kangspace.wechat.helper.work.message.push.WeComPushMessage;
import org.kangspace.wechat.helper.work.message.push.update.UpdateTemplateCardMessage;

/**
 * 企业微信"消息推送"相关 Service
 *
 * @author kango2gler@gmail.com
 * @since 2023/08/01
 */
public interface MessageService extends WeComService {
    /**
     * 消息推送-发送应用消息<br>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/90236">https://developer.work.weixin.qq.com/document/path/90236</a><br>
     * 如果部分接收人无权限或不存在，发送仍然执行，但会返回无效的部分（即invaliduser或invalidparty或invalidtag或unlicenseduser），常见的原因是接收人不在应用的可见范围内。<br>
     * 权限包含应用可见范围和基础接口权限(基础账号、互通账号均可)，unlicenseduser中的用户在应用可见范围内但没有基础接口权限。<br>
     * 如果全部接收人无权限或不存在，则本次调用返回失败，errcode为81013。<br>
     * 返回包中的userid，不区分大小写，统一转为小写<br>
     *
     * @param message {@link WeComPushMessage}
     * @return {@link MessageSendResponse}
     */
    MessageSendResponse messageSend(WeComPushMessage message);

    /**
     * 消息推送-更新模版卡片消息
     *
     * @param updateMessage {@link UpdateTemplateCardMessage}
     * @return {@link MessageUpdateTemplateCardResponse}
     */
    MessageUpdateTemplateCardResponse messageUpdateTemplateCard(UpdateTemplateCardMessage updateMessage);

    /**
     * 消息推送-撤回应用消息
     *
     * @param request {@link MessageRecallRequest}
     * @return {@link WeComResponseEntity}
     */
    WeComResponseEntity messageRecall(MessageRecallRequest request);
}
