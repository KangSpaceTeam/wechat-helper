package org.kangspace.wechat.helper.work;

import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.kangspace.wechat.helper.core.util.MimeContentTypes;
import org.kangspace.wechat.helper.work.bean.*;
import org.kangspace.wechat.helper.work.config.WeComConfig;
import org.kangspace.wechat.helper.work.constant.MediaConstant;
import org.kangspace.wechat.helper.work.token.DefaultWeComAccessTokenService;

import java.io.InputStream;

/**
 * 企业微信"素材管理"相关 测试
 *
 * @author kango2gler@gmail.com
 * @since 2023/9/9
 */

@Slf4j
@RunWith(JUnit4.class)
public class MediaServiceTest extends TestCase {
    private final String corpId = WeComAppConstant.GLOBAL_CORP_ID;
    private final String corpSecret = WeComAppConstant.GLOBAL_CORP_SECRET;
    private MediaService mediaService;

    @Before
    public void before() {
        WeComConfig weChatMpConfig = new WeComConfig(corpId, corpSecret);
        DefaultWeComAccessTokenService weComAccessTokenService = new DefaultWeComAccessTokenService(weChatMpConfig);
        mediaService = new DefaultMediaService(weComAccessTokenService);
    }

    @Test
    public void testMediaUpload() {
        MediaConstant.MediaType mediaType = MediaConstant.MediaType.IMAGE;
        String fileName = "logo_240.png";
        String filePath = "files/" + fileName;
        InputStream inputStream = ClassLoader.getSystemResourceAsStream(filePath);
        String contentType = "image/png";
        MediaUploadRequest request = new MediaUploadRequest(fileName, mediaType.getValue(), inputStream, contentType);
        MediaUploadResponse response = mediaService.mediaUpload(request);
        log.info("response: {}", response);
    }

    @Test
    public void testMediaUploadImg() {
        String fileName = "logo_240.png";
        String filePath = "files/" + fileName;
        InputStream inputStream = ClassLoader.getSystemResourceAsStream(filePath);
        String contentType = MimeContentTypes.IMAGE_PNG;
        MediaUploadImgRequest request = new MediaUploadImgRequest(fileName, inputStream, contentType);
        MediaUploadImgResponse response = mediaService.mediaUploadImg(request);
        log.info("response: {}", response);
    }

    @Test
    public void testMediaGet() {
        String mediaId = "";
        MediaGetResponse response = mediaService.mediaGet(mediaId);
        log.info("response: {}", response);
    }

    @Test
    public void testMediaGetJsSdK() {
        String mediaId = "";
        MediaGetResponse response = mediaService.mediaGetJsSdK(mediaId);
        log.info("response: {}", response);
    }

    @Test
    public void testMediaUploadByUrl() {
        MediaUploadByUrlRequest request = MediaUploadByUrlRequest.builder().build();
        MediaUploadByUrlResponse response = mediaService.mediaUploadByUrl(request);
        log.info("response: {}", response);
    }

    @Test
    public void testMediaGetUploadByUrlResult() {
        String jobId = "";
        MediaGetUploadByUrlResultRequest request = new MediaGetUploadByUrlResultRequest(jobId);
        MediaGetUploadByUrlResultResponse response = mediaService.mediaGetUploadByUrlResult(request);
        log.info("response: {}", response);
    }
}