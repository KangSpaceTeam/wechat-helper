package org.kangspace.wechat.helper.work;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.kangspace.wechat.helper.work.bean.MessageRecallRequest;
import org.kangspace.wechat.helper.work.bean.MessageSendResponse;
import org.kangspace.wechat.helper.work.bean.MessageUpdateTemplateCardResponse;
import org.kangspace.wechat.helper.work.bean.WeComResponseEntity;
import org.kangspace.wechat.helper.work.config.WeComConfig;
import org.kangspace.wechat.helper.work.message.MessageConstant;
import org.kangspace.wechat.helper.work.message.push.*;
import org.kangspace.wechat.helper.work.message.push.update.*;
import org.kangspace.wechat.helper.work.token.DefaultWeComAccessTokenService;

import java.util.Arrays;
import java.util.Collections;

/**
 * 企业微信"消息推送"相关 Service测试
 */
@Slf4j
@RunWith(JUnit4.class)
public class MessageServiceTest {

    private final String corpId = WeComAppConstant.GLOBAL_CORP_ID;
    private final String corpSecret = WeComAppConstant.GLOBAL_CORP_SECRET;
    private final String agentId = WeComAppConstant.GLOBAL_AGENT_ID;
    private MessageService messageService;

    private final static String URL = "https://kangspace.org";

    @Before
    public void before() {
        WeComConfig weChatMpConfig = new WeComConfig(corpId, corpSecret);
        DefaultWeComAccessTokenService weComAccessTokenService = new DefaultWeComAccessTokenService(weChatMpConfig);
        messageService = new DefaultMessageService(weComAccessTokenService);
    }

    @Test
    public void textMessageSend() {
        String text = "https://kangspace.org\n2023-08-04 23:31:08";
        String user = "Kang";
        TextMessage message = TextMessage.builder()
                .text(new TextMessage.Text(text))
                .safe(MessageConstant.Safe.SAFE.getType())
                .toUser(user)
                .agentId(agentId)
                .build();
        MessageSendResponse response = messageService.messageSend(message);
        log.info("response: {}", response);
    }

    @Test
    public void imageMessageSend() {
        // TODO xx
        String mediaId = "";
        String user = "Kang";
        ImageMessage message = ImageMessage.builder()
                .image(new ImageMessage.Image(mediaId))
                .safe(MessageConstant.Safe.SAFE.getType())
                .toUser(user)
                .agentId(agentId)
                .build();
        MessageSendResponse response = messageService.messageSend(message);
        log.info("response: {}", response);
    }

    @Test
    public void voiceMessageSend() {
        // TODO xx
        String mediaId = "";
        String user = "Kang";
        VoiceMessage message = VoiceMessage.builder()
                .voice(new VoiceMessage.Voice(mediaId))
                .safe(MessageConstant.Safe.SAFE.getType())
                .toUser(user)
                .agentId(agentId)
                .build();
        MessageSendResponse response = messageService.messageSend(message);
        log.info("response: {}", response);
    }

    @Test
    public void videoMessageSend() {
        String mediaId = "";
        String user = "Kang";
        VideoMessage message = VideoMessage.builder()
                .video(new VideoMessage.Voice(mediaId))
                .safe(MessageConstant.Safe.SAFE.getType())
                .toUser(user)
                .agentId(agentId).build();
        MessageSendResponse response = messageService.messageSend(message);
        log.info("response: {}", response);
    }

    @Test
    public void fileMessageSend() {
        // TODO  xxx
        String mediaId = "";
        String user = "Kang";
        FileMessage message = FileMessage.builder()
                .file(new FileMessage.File(mediaId))
                .safe(MessageConstant.Safe.SAFE.getType())
                .toUser(user)
                .agentId(agentId).build();
        MessageSendResponse response = messageService.messageSend(message);
        log.info("response: {}", response);
    }

    @Test
    public void textCardMessageSend() {
        String user = "Kang";
        TextCardMessage message = TextCardMessage.builder()
                .textCard(TextCardMessage.TextCard.builder()
                        .title("领奖通知")
                        .description("<div class=\"gray\">2016年9月26日</div> <div class=\"normal\">恭喜你抽中iPhone 7一台，领奖码：xxxx</div><div class=\"highlight\">请于2016年10月10日前联系行政同事领取</div>")
                        .url(URL)
                        .btnTxt("更多")
                        .build())
                .safe(MessageConstant.Safe.SAFE.getType())
                .toUser(user)
                .agentId(agentId).build();
        MessageSendResponse response = messageService.messageSend(message);
        log.info("response: {}", response);
    }

    @Test
    public void newsMessageSend() {
        String user = "Kang";
        NewsMessage message = NewsMessage.builder()
                .news(new NewsMessage.News(Arrays.asList(
                        NewsMessage.Article.builder()
                                .title("中秋节礼品领取")
                                .description("今年中秋节公司有豪礼相送")
                                .url(URL)
                                .picUrl("http://res.mail.qq.com/node/ww/wwopenmng/images/independent/doc/test_pic_msg1.png")
                                .build(),
                        NewsMessage.Article.builder()
                                .title("wechat-helper")
                                .description("\uD83D\uDEE0️ 微信开发助手，通过整合微信公众号、服务号、微信开放平台和企业微信的开发API，提供统一微信API调用SDK、OPEN-API和微信应用的管理平台")
                                .url("https://github.com/KangSpaceTeam/wechat-helper")
                                .picUrl("https://avatars.githubusercontent.com/u/107765481?s=48&v=4")
                                .build()

                )))
                .safe(MessageConstant.Safe.UN_SAFE.getType())
                .toUser(user)
                .agentId(agentId).build();
        MessageSendResponse response = messageService.messageSend(message);
        log.info("response: {}", response);
    }

    @Test
    public void mpNewsMessageSend() {
        String user = "Kang";
        MpNewsMessage message = MpNewsMessage.builder()
                .mpNews(new MpNewsMessage.MpNews(Arrays.asList(
                        MpNewsMessage.Article.builder()
                                .title("中秋节礼品领取")
                                .author("KangSpace")
                                .contentSourceUrl(URL)
                                // TODO xx
                                .thumbMediaId("")
                                .content("中秋节礼品领取-KangSpace")
                                .digest("中秋节礼品领取-详情")
                                .build(),
                        MpNewsMessage.Article.builder()
                                .title("wechat-helper")
                                .author("KangSpace")
                                .contentSourceUrl("https://github.com/KangSpaceTeam/wechat-helper")
                                // TODO xx
                                .thumbMediaId("")
                                .content("\uD83D\uDEE0️ 微信开发助手，通过整合微信公众号、服务号、微信开放平台和企业微信的开发API，提供统一微信API调用SDK、OPEN-API和微信应用的管理平台")
                                .digest("wechat-helper-详情")
                                .build()

                )))
                .safe(MessageConstant.Safe.UN_SAFE.getType())
                .toUser(user)
                .agentId(agentId).build();
        MessageSendResponse response = messageService.messageSend(message);
        log.info("response: {}", response);
    }

    @Test
    public void markDownMessageSend() {
        String user = "Kang";
        MarkDownMessage message = MarkDownMessage.builder()
                .markDown(new MarkDownMessage.MarkDown("您的会议室已经预定，稍后会同步到`邮箱`  \n>**事项详情**  \n>" +
                        "事　项：<font color=\"info\">开会</font>  \n>组织者：@miglioguan  \n>" +
                        "参与者：@miglioguan、@kunliu、@jamdeezhou、@kanexiong、@kisonwang  \n>  \n>" +
                        "会议室：<font color=\"info\">广州TIT 1楼 301</font>  \n>" +
                        "日　期：<font color=\"warning\">2018年5月18日</font>  \n>" +
                        "时　间：<font color=\"comment\">上午9:00-11:00</font>  \n>  \n>" +
                        "请准时参加会议。  \n>  \n>如需修改会议信息，请点击：[修改会议信息](https://work.weixin.qq.com)"))
                .safe(MessageConstant.Safe.UN_SAFE.getType())
                .toUser(user)
                .agentId(agentId).build();
        MessageSendResponse response = messageService.messageSend(message);
        log.info("response: {}", response);
    }

    @Test
    public void miniProgramNoticeMessageSend() {
        String user = "Kang";
        MiniProgramNoticeMessage message = MiniProgramNoticeMessage.builder()
                .miniProgramNotice(MiniProgramNoticeMessage.MiniProgramNotice.builder().build())
                .safe(MessageConstant.Safe.UN_SAFE.getType())
                .toUser(user)
                .agentId(agentId).build();
        MessageSendResponse response = messageService.messageSend(message);
        log.info("response: {}", response);
    }

    @Test
    public void textCardTemplateCardMessageSend() {
        String user = "Kang";
        TemplateCardMessage message = TemplateCardMessage.builder()
                .templateCard(TemplateCard.TextNotice.builder()
                        .subTitleText("下载企业微信还能抢红包！")
                        .source(new TemplateCard.Source("https://avatars.githubusercontent.com/u/107765481?s=48&v=4", "企业微信", MessageConstant.SourceColor.RED.getColor()))
                        .actionMenu(new TemplateCard.ActionMenu("卡片副交互辅助文本说明", Arrays.asList(
                                new TemplateCard.ActionList("接受推送", "A"),
                                new TemplateCard.ActionList("不再推送", "B")
                        )))
                        .taskId(System.currentTimeMillis() + "")
                        .mainTitle(new TemplateCard.MainTitle("欢迎使用企业微信", "您的好友正在邀请您加入企业微信"))
                        .quoteArea(new TemplateCard.QuoteArea(1, URL, "企业微信的引用样式", "企业微信真好用呀真好用"))
                        .emphasisContent(new TemplateCard.EmphasisContent("100", "核心数据"))
                        .horizontalContentList(Arrays.asList(
                                new TemplateCard.HorizontalContentList("邀请人", "张三"),
                                new TemplateCard.HorizontalContentList(1, "企业微信官网", "点击访问", URL)
                        ))
                        .jumpList(Collections.singletonList(
                                new TemplateCard.JumpList(1, "企业微信官网", URL)
//                                ,new TemplateCard.JumpList(2,"跳转小程序","a","/")
                        ))
                        .cardAction(new TemplateCard.CardAction(1, URL))
                        .build())
                .safe(MessageConstant.Safe.UN_SAFE.getType())
                .toUser(user)
                .agentId(agentId).build();
        MessageSendResponse response = messageService.messageSend(message);
        log.info("response: {}", response);
    }

    @Test
    public void newsNoticeTemplateCardMessageSend() {
        String user = "Kang";
        TemplateCardMessage message = TemplateCardMessage.builder()
                .templateCard(TemplateCard.NewsNotice.builder()
                        .imageTextArea(new TemplateCard.ImageTextArea(1, URL, "企业微信的左图右文样式", "企业微信真好用呀真好用", "https://img.iplaysoft.com/wp-content/uploads/2019/free-images/free_stock_photo_2x.jpg"))
                        .cardImage(new TemplateCard.CardImage("https://img.iplaysoft.com/wp-content/uploads/2019/free-images/free_stock_photo_2x.jpg", 1.3F))
                        .verticalContentList(Arrays.asList(
                                new TemplateCard.VerticalContentList("惊喜红包等你来拿", "下载企业微信还能抢红包！"),
                                new TemplateCard.VerticalContentList("白云苍狗", "光怪陆离")
                        ))
                        .source(new TemplateCard.Source("https://avatars.githubusercontent.com/u/107765481?s=48&v=4", "企业微信", MessageConstant.SourceColor.RED.getColor()))
                        /*.actionMenu(new TemplateCard.ActionMenu("卡片副交互辅助文本说明",Arrays.asList(
                                new TemplateCard.ActionList("接受推送","A"),
                                new TemplateCard.ActionList("不再推送","B")
                        )))*/
                        .taskId(System.currentTimeMillis() + "")
                        .mainTitle(new TemplateCard.MainTitle("欢迎使用企业微信", "您的好友正在邀请您加入企业微信"))
                        .quoteArea(new TemplateCard.QuoteArea(1, URL, "企业微信的引用样式", "企业微信真好用呀真好用"))
                        .horizontalContentList(Arrays.asList(
                                new TemplateCard.HorizontalContentList("邀请人", "张三"),
                                new TemplateCard.HorizontalContentList(1, "企业微信官网", "点击访问", URL)
                        ))
                        .jumpList(Collections.singletonList(
                                new TemplateCard.JumpList(1, "企业微信官网", URL)
//                                ,new TemplateCard.JumpList(2,"跳转小程序","a","/")
                        ))
                        .cardAction(new TemplateCard.CardAction(1, URL))
                        .build())
                .safe(MessageConstant.Safe.UN_SAFE.getType())
                .toUser(user)
                .agentId(agentId).build();
        MessageSendResponse response = messageService.messageSend(message);
        log.info("response: {}", response);
    }

    @Test
    public void buttonInteractionTemplateCardMessageSend() {
        String user = "Kang";
        TemplateCardMessage message = TemplateCardMessage.builder()
                .templateCard(TemplateCard.ButtonInteraction.builder()
                        .subTitleText("下载企业微信还能抢红包！")
                        .buttonSelection(new TemplateCard.ButtonSelection(
                                "btn_question_key1", "企业微信评分", Arrays.asList(
                                new TemplateCard.OptionList("btn_selection_id1", "100分"),
                                new TemplateCard.OptionList("btn_selection_id2", "101分")
                        ), "btn_selection_id1"
                        ))
                        .buttonList(Arrays.asList(
                                new TemplateCard.ButtonList("按钮1", 1, "button_key_1"),
                                new TemplateCard.ButtonList("按钮2", "button_key_2")
                        ))
                        .source(new TemplateCard.Source("https://avatars.githubusercontent.com/u/107765481?s=48&v=4", "企业微信", MessageConstant.SourceColor.RED.getColor()))
                        .actionMenu(new TemplateCard.ActionMenu("卡片副交互辅助文本说明", Arrays.asList(
                                new TemplateCard.ActionList("接受推送", "A"),
                                new TemplateCard.ActionList("不再推送", "B")
                        )))
                        .taskId(System.currentTimeMillis() + "")
                        .mainTitle(new TemplateCard.MainTitle("欢迎使用企业微信", "您的好友正在邀请您加入企业微信"))
                        .quoteArea(new TemplateCard.QuoteArea(1, URL, "企业微信的引用样式", "企业微信真好用呀真好用"))
                        .horizontalContentList(Arrays.asList(
                                new TemplateCard.HorizontalContentList("邀请人", "张三"),
                                new TemplateCard.HorizontalContentList(1, "企业微信官网", "点击访问", URL)
                        ))
                        .cardAction(new TemplateCard.CardAction(1, URL))
                        .build())
                .safe(MessageConstant.Safe.UN_SAFE.getType())
                .toUser(user)
                .agentId(agentId).build();
        MessageSendResponse response = messageService.messageSend(message);
        log.info("response: {}", response);
    }

    @Test
    public void voteInteractionTemplateCardMessageSend() {
        String user = "Kang";
        TemplateCardMessage message = TemplateCardMessage.builder()
                .templateCard(TemplateCard.VoteInteraction.builder()
                        .checkbox(new TemplateCard.CheckBox("question_key1", 1,
                                Arrays.asList(
                                        new TemplateCard.CheckBoxOptionList("option_id1", "选择题选项1", true),
                                        new TemplateCard.CheckBoxOptionList("option_id2", "选择题选项2", false)
                                )))
                        .submitButton(new TemplateCard.SubmitButton("提交", "key"))
                        .source(new TemplateCard.Source("https://avatars.githubusercontent.com/u/107765481?s=48&v=4", "企业微信", MessageConstant.SourceColor.RED.getColor()))
                        .taskId(System.currentTimeMillis() + "")
                        .mainTitle(new TemplateCard.MainTitle("欢迎使用企业微信", "您的好友正在邀请您加入企业微信"))
                        .build())
                .safe(MessageConstant.Safe.UN_SAFE.getType())
                .toUser(user)
                .agentId(agentId).build();
        MessageSendResponse response = messageService.messageSend(message);
        log.info("response: {}", response);
    }

    @Test
    public void multipleInteractionTemplateCardMessageSend() {
        String user = "Kang";
        TemplateCardMessage message = TemplateCardMessage.builder()
                .templateCard(TemplateCard.MultipleInteraction.builder()
                        .selectList(Arrays.asList(
                                new TemplateCard.SelectList("question_key1", "选择器标签1",
                                        Arrays.asList(new TemplateCard.OptionList("selection_id1", "选择器选项1"),
                                                new TemplateCard.OptionList("selection_id2", "选择器选项2")),
                                        "selection_id1"),
                                new TemplateCard.SelectList("question_key2", "选择器标签2",
                                        Arrays.asList(new TemplateCard.OptionList("selection_id21", "选择器选项21"),
                                                new TemplateCard.OptionList("selection_id22", "选择器选项22")),
                                        "selection_id2")

                        ))
                        .submitButton(new TemplateCard.SubmitButton("提交", "key"))
                        .source(new TemplateCard.Source("https://avatars.githubusercontent.com/u/107765481?s=48&v=4", "企业微信", MessageConstant.SourceColor.RED.getColor()))
                        .taskId(System.currentTimeMillis() + "")
                        .mainTitle(new TemplateCard.MainTitle("欢迎使用企业微信", "您的好友正在邀请您加入企业微信"))
                        .build())
                .safe(MessageConstant.Safe.UN_SAFE.getType())
                .toUser(user)
                .agentId(agentId).build();
        MessageSendResponse response = messageService.messageSend(message);
        log.info("response: {}", response);
    }

    @Test
    public void unClickableMessageUpdateTemplateCard() {
        String user = "Kang";
        UpdateTemplateCardMessage message = UnClickableUpdateMessage.builder()
                .userIds(Collections.singletonList(user))
                .atAll(1)
                .responseCode("NdxJtsmT09LCQgCvGiG1bbL0Jq7pBqwkrhbL_R7TDQY")
                .button(new UnClickableUpdateMessage.Button("已完成"))
                .agentId(agentId).build();
        MessageUpdateTemplateCardResponse response = messageService.messageUpdateTemplateCard(message);
        log.info("response: {}", response);
    }

    @Test
    public void textNoticeUpdateMessageUpdateTemplateCard() {
        String user = "Kang";
        UpdateTemplateCardMessage message = TextNoticeUpdateMessage.builder()
                .templateCard(TemplateCard.TextNotice.builder()
                        .subTitleText("下载企业微信还能抢红包！")
                        .source(new TemplateCard.Source("https://avatars.githubusercontent.com/u/107765481?s=48&v=4", "企业微信", MessageConstant.SourceColor.RED.getColor()))
                        .actionMenu(new TemplateCard.ActionMenu("卡片副交互辅助文本说明", Arrays.asList(
                                new TemplateCard.ActionList("接受推送", "A"),
                                new TemplateCard.ActionList("不再推送", "B")
                        )))
                        .taskId(System.currentTimeMillis() + "")
                        .mainTitle(new TemplateCard.MainTitle("欢迎使用企业微信", "您的好友正在邀请您加入企业微信"))
                        .quoteArea(new TemplateCard.QuoteArea(1, URL, "企业微信的引用样式", "企业微信真好用呀真好用"))
                        .emphasisContent(new TemplateCard.EmphasisContent("100", "核心数据"))
                        .horizontalContentList(Arrays.asList(
                                new TemplateCard.HorizontalContentList("邀请人", "张三"),
                                new TemplateCard.HorizontalContentList(1, "企业微信官网", "点击访问", URL)
                        ))
                        .jumpList(Collections.singletonList(
                                new TemplateCard.JumpList(1, "企业微信官网", URL)
//                                ,new TemplateCard.JumpList(2,"跳转小程序","a","/")
                        ))
                        .cardAction(new TemplateCard.CardAction(1, URL))
                        .build())
                .userIds(Collections.singletonList(user))
                .responseCode("gh4TldqYEFbaFgYB9hhe7ycNXcc4sUVaC25HOi-dMNU")
                .agentId(agentId).build();
        MessageUpdateTemplateCardResponse response = messageService.messageUpdateTemplateCard(message);
        log.info("response: {}", response);
    }

    @Test
    public void newsNoticeUpdateMessageUpdateTemplateCard() {
        String user = "Kang";
        UpdateTemplateCardMessage message = NewsNoticeUpdateMessage.builder()
                .templateCard(TemplateCard.NewsNotice.builder()
                        .imageTextArea(new TemplateCard.ImageTextArea(1, URL, "企业微信的左图右文样式", "企业微信真好用呀真好用", "https://img.iplaysoft.com/wp-content/uploads/2019/free-images/free_stock_photo_2x.jpg"))
                        .cardImage(new TemplateCard.CardImage("https://img.iplaysoft.com/wp-content/uploads/2019/free-images/free_stock_photo_2x.jpg", 1.3F))
                        .verticalContentList(Arrays.asList(
                                new TemplateCard.VerticalContentList("惊喜红包等你来拿", "下载企业微信还能抢红包！"),
                                new TemplateCard.VerticalContentList("白云苍狗", "光怪陆离")
                        ))
                        .source(new TemplateCard.Source("https://avatars.githubusercontent.com/u/107765481?s=48&v=4", "企业微信", MessageConstant.SourceColor.RED.getColor()))
                        /*.actionMenu(new TemplateCard.ActionMenu("卡片副交互辅助文本说明",Arrays.asList(
                                new TemplateCard.ActionList("接受推送","A"),
                                new TemplateCard.ActionList("不再推送","B")
                        )))*/
                        .taskId(System.currentTimeMillis() + "")
                        .mainTitle(new TemplateCard.MainTitle("欢迎使用企业微信", "您的好友正在邀请您加入企业微信"))
                        .quoteArea(new TemplateCard.QuoteArea(1, URL, "企业微信的引用样式", "企业微信真好用呀真好用"))
                        .horizontalContentList(Arrays.asList(
                                new TemplateCard.HorizontalContentList("邀请人", "张三"),
                                new TemplateCard.HorizontalContentList(1, "企业微信官网", "点击访问", URL)
                        ))
                        .jumpList(Collections.singletonList(
                                new TemplateCard.JumpList(1, "企业微信官网", URL)
//                                ,new TemplateCard.JumpList(2,"跳转小程序","a","/")
                        ))
                        .cardAction(new TemplateCard.CardAction(1, URL))
                        .build())
                .userIds(Collections.singletonList(user))
                .responseCode("l4HkzUsn_9A9EAH_mspMLAXZ3vsnz0HrBJU1SpfWiTY")
                .agentId(agentId).build();
        MessageUpdateTemplateCardResponse response = messageService.messageUpdateTemplateCard(message);
        log.info("response: {}", response);
    }

    @Test
    public void buttonInteractionUpdateMessageUpdateTemplateCard() {
        String user = "Kang";
        UpdateTemplateCardMessage message = ButtonInteractionUpdateMessage.builder()
                .templateCard(TemplateCard.ButtonInteraction.builder()
                        .subTitleText("下载企业微信还能抢红包！")
                        .buttonSelection(new TemplateCard.ButtonSelection(
                                "btn_question_key1", "企业微信评分", Arrays.asList(
                                new TemplateCard.OptionList("btn_selection_id1", "100分"),
                                new TemplateCard.OptionList("btn_selection_id2", "101分")
                        ), "btn_selection_id1"
                        ))
                        .buttonList(Arrays.asList(
                                new TemplateCard.ButtonList("按钮1", 1, "button_key_1"),
                                new TemplateCard.ButtonList("按钮2", "button_key_2")
                        ))
                        .source(new TemplateCard.Source("https://avatars.githubusercontent.com/u/107765481?s=48&v=4", "企业微信", MessageConstant.SourceColor.RED.getColor()))
                        .actionMenu(new TemplateCard.ActionMenu("卡片副交互辅助文本说明", Arrays.asList(
                                new TemplateCard.ActionList("接受推送", "A"),
                                new TemplateCard.ActionList("不再推送", "B")
                        )))
                        .taskId(System.currentTimeMillis() + "")
                        .mainTitle(new TemplateCard.MainTitle("欢迎使用企业微信", "您的好友正在邀请您加入企业微信"))
                        .quoteArea(new TemplateCard.QuoteArea(1, URL, "企业微信的引用样式", "企业微信真好用呀真好用"))
                        .horizontalContentList(Arrays.asList(
                                new TemplateCard.HorizontalContentList("邀请人", "张三"),
                                new TemplateCard.HorizontalContentList(1, "企业微信官网", "点击访问", URL)
                        ))
                        .cardAction(new TemplateCard.CardAction(1, URL))
                        .build())
                .userIds(Collections.singletonList(user))
                .responseCode("En4nMIkShUnKLUn7AT2WsVOVHAOYF00DJEeia_qtA_Q")
                .agentId(agentId).build();
        MessageUpdateTemplateCardResponse response = messageService.messageUpdateTemplateCard(message);
        log.info("response: {}", response);
    }

    @Test
    public void voteInteractionUpdateMessageUpdateTemplateCard() {
        String user = "Kang";
        UpdateTemplateCardMessage message = VoteInteractionUpdateMessage.builder()
                .templateCard(TemplateCard.VoteInteraction.builder()
                        .checkbox(new TemplateCard.CheckBox("question_key1", 1,
                                Arrays.asList(
                                        new TemplateCard.CheckBoxOptionList("option_id1", "选择题选项1", true),
                                        new TemplateCard.CheckBoxOptionList("option_id2", "选择题选项2", false)
                                )))
                        .submitButton(new TemplateCard.SubmitButton("提交", "key"))
                        .source(new TemplateCard.Source("https://avatars.githubusercontent.com/u/107765481?s=48&v=4", "企业微信", MessageConstant.SourceColor.RED.getColor()))
                        .taskId(System.currentTimeMillis() + "")
                        .mainTitle(new TemplateCard.MainTitle("欢迎使用企业微信", "您的好友正在邀请您加入企业微信"))
                        .build())
                .userIds(Collections.singletonList(user))
                .responseCode("OVH8jEaBfWBH6obGSmJANPWZKkUdYXUo1aH0BENUETE")
                .agentId(agentId).build();
        MessageUpdateTemplateCardResponse response = messageService.messageUpdateTemplateCard(message);
        log.info("response: {}", response);
    }

    @Test
    public void multipleInteractionUpdateMessageUpdateTemplateCard() {
        String user = "Kang";
        UpdateTemplateCardMessage message = MultipleInteractionUpdateMessage.builder()
                .templateCard(TemplateCard.MultipleInteraction.builder()
                        .selectList(Arrays.asList(
                                new TemplateCard.SelectList("question_key1", "选择器标签1",
                                        Arrays.asList(new TemplateCard.OptionList("selection_id1", "选择器选项1"),
                                                new TemplateCard.OptionList("selection_id2", "选择器选项2")),
                                        "selection_id1"),
                                new TemplateCard.SelectList("question_key2", "选择器标签2",
                                        Arrays.asList(new TemplateCard.OptionList("selection_id21", "选择器选项21"),
                                                new TemplateCard.OptionList("selection_id22", "选择器选项22")),
                                        "selection_id2")

                        ))
                        .submitButton(new TemplateCard.SubmitButton("提交", "key"))
                        .source(new TemplateCard.Source("https://avatars.githubusercontent.com/u/107765481?s=48&v=4", "企业微信", MessageConstant.SourceColor.RED.getColor()))
                        .taskId(System.currentTimeMillis() + "")
                        .mainTitle(new TemplateCard.MainTitle("欢迎使用企业微信", "您的好友正在邀请您加入企业微信"))
                        .build())
                .userIds(Collections.singletonList(user))
                .responseCode("OtT6pCj-OylKcudFKJiWz4y7lFO019HhYZuPJJc-eOo")
                .agentId(agentId).build();
        MessageUpdateTemplateCardResponse response = messageService.messageUpdateTemplateCard(message);
        log.info("response: {}", response);
    }

    @Test
    public void messageRecall() {
        String messageId = "Dv0oBVNA9p2BIWPODPqgkruOZg1RsBF4OqqeM40Jikk-28CXInR4Cgi_p6EArjHyDFVNvu0kvKRL6S3uBp7kSg";
        MessageRecallRequest request = new MessageRecallRequest(messageId);
        WeComResponseEntity response = messageService.messageRecall(request);
        log.info("response: {}", response);
    }
}