package org.kangspace.wechat.helper.work;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.kangspace.wechat.helper.work.bean.MediaUploadRequest;
import org.kangspace.wechat.helper.work.bean.WeComResponseEntity;
import org.kangspace.wechat.helper.work.bean.WebHookUploadMediaResponse;
import org.kangspace.wechat.helper.work.config.WeComConfig;
import org.kangspace.wechat.helper.work.constant.MediaConstant;
import org.kangspace.wechat.helper.work.constant.WeComConstant;
import org.kangspace.wechat.helper.work.message.webhook.FileMessage;
import org.kangspace.wechat.helper.work.message.webhook.TextMessage;
import org.kangspace.wechat.helper.work.message.webhook.WebHookMessage;
import org.kangspace.wechat.helper.work.token.DefaultWeComAccessTokenService;

import java.io.InputStream;
import java.util.Collections;


/**
 * 企业微信"群机器人"相关 Service测试
 */
@Slf4j
@RunWith(JUnit4.class)
public class WebHookServiceTest {


    private final String corpId = WeComAppConstant.GLOBAL_CORP_ID;
    private final String corpSecret = WeComAppConstant.GLOBAL_CORP_SECRET;
    private WebHookService webHookService;

    private final String KEY = "35078566-df61-42f6-98d5-cbad459ee476";

    @Before
    public void before() {
        WeComConfig weChatMpConfig = new WeComConfig(corpId, corpSecret);
        DefaultWeComAccessTokenService weComAccessTokenService = new DefaultWeComAccessTokenService(weChatMpConfig);
        webHookService = new DefaultWebHookService(weComAccessTokenService);
    }

    @Test
    public void webhookSend() {
        WebHookMessage message = TextMessage.builder()
                .text(TextMessage.Text.builder()
                        .content("0123456789")
                        .mentionedList(Collections.singletonList("@all"))
                        .build())
                .build();
        WeComResponseEntity response = webHookService.webhookSend(KEY, message);
        log.info("response: {}", response);
    }

    @Test
    public void fileMessageWebhookSend() {
        WebHookMessage message = FileMessage.builder()
                .file(FileMessage.File.builder()
                        .mediaId("35ZUsBDmSJ89Xy3uemH2b1Bmc73z-653FZOV_IRNxaCBzEb5i6PWtOuggpQVClps7")
                        .build())
                .build();
        WeComResponseEntity response = webHookService.webhookSend(KEY, message);
        log.info("response: {}", response);
    }

    @Test
    public void webhookUploadMedia() {
        MediaConstant.MediaType mediaType = MediaConstant.MediaType.IMAGE;
        String type = MediaConstant.WebHookUploadMediaType.FILE.getType();
        String fileName = "logo_240.png";
        String filePath = "files/" + fileName;
        InputStream inputStream = ClassLoader.getSystemResourceAsStream(filePath);
        String contentType = "image/png";
        assert inputStream != null;
        MediaUploadRequest request = new MediaUploadRequest(fileName, mediaType.getValue(), inputStream, contentType);
        WebHookUploadMediaResponse response = webHookService.webhookUploadMedia(KEY, type, request);
        log.info("response: {}", response);
    }
}