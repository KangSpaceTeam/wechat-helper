package org.kangspace.wechat.helper.mp;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.kangspace.devhelper.NonceGenerator;
import org.kangspace.wechat.helper.mp.bean.*;
import org.kangspace.wechat.helper.mp.config.WeChatMpConfig;
import org.kangspace.wechat.helper.mp.constant.MessageConstant;

/**
 * 微信公众号"基础消息能力"Service 测试
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/11
 */
@Slf4j
@RunWith(JUnit4.class)
public class MessageServiceTest {

    private final String appId = WeChatMpAppConstant.GLOBAL_APPID;
    private final String appSecret = WeChatMpAppConstant.GLOBAL_APPSECRET;

    private MessageService messageService;

    @Before
    public void before() {
        WeChatMpConfig weChatMpConfig = new WeChatMpConfig(appId, appSecret);
        messageService = new DefaultMessageService(weChatMpConfig);
    }

    /**
     * 模板消息-设置所属行业 测试
     *
     * @see MessageConstant.Industry
     */
    @Test
    public void templateApiSetIndustryTest() {
        TemplateApiSetIndustryRequest request = new TemplateApiSetIndustryRequest(MessageConstant.Industry.CODE_1, MessageConstant.Industry.CODE_2);
        WeChatMpResponseEntity response = messageService.templateApiSetIndustry(request);
        log.info("response: {}", response);
    }

    /**
     * 模板消息-获取设置的行业信息 测试
     */
    @Test
    public void templateGetIndustryTest() {
        TemplateGetIndustryResponse response = messageService.templateGetIndustry();
        log.info("response: {}", response);
    }

    /**
     * 模板消息-设置所属行业 测试 <br>
     * <pre>
     * templateIdShort: TM00004
     * templateId: vvRvUUJWSMPi69zeAVxUvJlMeSqzt5esUE27ZKJeb14 (同一个模板删除重新添加后模板ID会变,pz9GrV0WOOruzZKY24AO7qUa7uFeNHHJqRBHR2pELQ8)
     * title: 退款通知
     * primaryIndustry:IT科技, deputyIndustry:互联网|电子商务,
     * content:{{first.DATA}}
     *
     * 退款原因：{{reason.DATA}}
     * 退款金额：{{refund.DATA}}
     * {{remark.DATA}}, example=您好，您对微信影城影票的抢购未成功，已退款。
     *
     * 退款原因：未抢购成功
     * 退款金额：70元
     * 备注：如有疑问，请致电13912345678联系我们，或回复M来了解详情。
     * </pre>
     */
    @Test
    public void templateApiAddTemplateTest() {
        TemplateApiAddTemplateRequest request = new TemplateApiAddTemplateRequest("TM00004");
        TemplateApiAddTemplateResponse response = messageService.templateApiAddTemplate(request);
        log.info("response: {}", response);
    }

    /**
     * 模板消息-删除模板 测试
     */
    @Test
    public void templateDelPrivateTemplateTest() {
        TemplateDelPrivateTemplateRequest request = new TemplateDelPrivateTemplateRequest("vvRvUUJWSMPi69zeAVxUvJlMeSqzt5esUE27ZKJeb14");
        WeChatMpResponseEntity response = messageService.templateDelPrivateTemplate(request);
        log.info("response: {}", response);
    }

    /**
     * 模板消息-获取模板列表 测试
     */
    @Test
    public void templateGetAllPrivateTemplateTest() {
        TemplateGetAllPrivateTemplateResponse response = messageService.templateGetAllPrivateTemplate();
        log.info("response: {}", response);
    }

    /**
     * 模板消息-发送模板消息 测试
     *
     * <pre>
     * templateIdShort: TM00004
     * templateId: vvRvUUJWSMPi69zeAVxUvJlMeSqzt5esUE27ZKJeb14,pz9GrV0WOOruzZKY24AO7qUa7uFeNHHJqRBHR2pELQ8
     * title: 退款通知
     * primaryIndustry:IT科技, deputyIndustry:互联网|电子商务,
     * content:{{first.DATA}}
     *
     * 退款原因：{{reason.DATA}}
     * 退款金额：{{refund.DATA}}
     * {{remark.DATA}}, example=您好，您对微信影城影票的抢购未成功，已退款。
     *
     * 退款原因：未抢购成功
     *  退款金额：70元
     *  备注：如有疑问，请致电13912345678联系我们，或回复M来了解详情。
     *  </pre>
     */
    @Test
    public void messageTemplateSendTest() {
        String toUser = "oOIaHt5IOo6rI8BH8IOiG3lA0yHU";
        String templateId = "pz9GrV0WOOruzZKY24AO7qUa7uFeNHHJqRBHR2pELQ8";
        MessageTemplateSendRequest.MessageData messageData = new MessageTemplateSendRequest.MessageData();
        messageData.put("first", new MessageTemplateSendRequest.MessageDataValue("API测试退款通知", MessageConstant.Color.DEFAULT_ORANGE.getColor()));
        messageData.put("reason", new MessageTemplateSendRequest.MessageDataValue("API测试退款"));
        messageData.put("refund", new MessageTemplateSendRequest.MessageDataValue("100元", MessageConstant.Color.DEFAULT_BLUE.getColor()));
        messageData.put("remark", new MessageTemplateSendRequest.MessageDataValue("请确认该笔交易", MessageConstant.Color.DEFAULT_RED.getColor()));
        MessageTemplateSendRequest request = MessageTemplateSendRequest.newRequest(toUser, templateId);
        request.setUrl("https://kangspace.org");
        request.setData(messageData);
        MessageTemplateSendResponse response = messageService.messageTemplateSend(request);
        log.info("response: {}", response);
    }

    /**
     * 获取公众号的自动回复规则 测试
     */
    @Test
    public void getCurrentAutoReplyInfoTest() {
        GetCurrentAutoReplyInfoResponse response = messageService.getCurrentAutoReplyInfo();
        log.info("response: {}", response);
    }

    /**
     * 公众号一次性订阅消息: 获取授权链接 测试
     */
    @Test
    public void subscribeMsg() {
        String scene = "";
        String templateId = "TEMP";
        String redirectUrl = "https://kangspace.org/";
        String reserved = NonceGenerator.numeric();
        String url = messageService.subscribeMsg(appId, scene, templateId, redirectUrl, reserved);
        log.info("url: {}", url);
    }

    /**
     * 公众号一次性订阅消息: 发送订阅消息 测试
     */
    @Test
    public void subscribe() {
        String toUser = "";
        String templateId = "";
        String title = "";
        String scene = "1";
        String url = "https://kangspace.org";
        MessageTemplateSubscribeRequest.MiniProgram miniProgram = new MessageTemplateSubscribeRequest.MiniProgram("appId", "/path");
        MessageTemplateSubscribeRequest request = new MessageTemplateSubscribeRequest();
        request.setToUser(toUser);
        request.setTemplateId(templateId);
        request.setUrl(url);
        request.setMiniProgram(miniProgram);
        request.setTitle(title);
        request.setScene(scene);
        request.setData(new MessageTemplateSubscribeRequest.TemplateData(new MessageTemplateSubscribeRequest.TemplateDataContent("MESSAGE CONTENT")));
        WeChatMpResponseEntity response = messageService.subscribe(request);
        log.info("response: {}", response);
    }
}
