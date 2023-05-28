package org.kangspace.wechat.helper.mp;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.kangspace.wechat.helper.core.util.MimeContentTypes;
import org.kangspace.wechat.helper.mp.bean.*;
import org.kangspace.wechat.helper.mp.config.WeChatMpConfig;
import org.kangspace.wechat.helper.mp.constant.MediaConstant;
import org.kangspace.wechat.helper.mp.token.DefaultWeChatMpAccessTokenService;

import java.io.InputStream;

/**
 * 微信公众号素材管理相关Service测试类
 *
 * @author kango2gler@gmail.com
 * @since 2023/01/17
 */
@Slf4j
@RunWith(JUnit4.class)
public class AssertServiceTest {
    private final String appId = WeChatMpAppConstant.GLOBAL_APPID;
    private final String appSecret = WeChatMpAppConstant.GLOBAL_APPSECRET;
    private AssetService mpAssetService;
    private DefaultWeChatMpAccessTokenService weChatMpAccessTokenService;

    @Before
    public void before() {
        WeChatMpConfig weChatMpConfig = new WeChatMpConfig(appId, appSecret);
        weChatMpAccessTokenService = new DefaultWeChatMpAccessTokenService(weChatMpConfig);
        mpAssetService = new DefaultAssetService(weChatMpAccessTokenService);
    }

    /**
     * 新增临时素材测试
     */
    @Test
    public void mediaUploadTest() {
        MediaConstant.MediaType mediaType = MediaConstant.MediaType.IMAGE;
        String fileName = "logo_240.png";
        String filePath = "files/" + fileName;
        InputStream inputStream = ClassLoader.getSystemResourceAsStream(filePath);
        String contentType = "image/png";
        MediaUploadRequest request = new MediaUploadRequest(fileName, mediaType, inputStream, contentType);
        MediaUploadResponse response = mpAssetService.mediaUpload(request);
        log.info("response: {}", response);
    }

    /**
     * 获取临时素材测试
     */
    @Test
    public void mediaGetTest() {
        String mediaId = "d4k7-GynE9dTWH_AX5NpAWPB-5-31W-7SlhTISDbbQUOq6SxnIY5A5kWsaJti-Dm";
        MediaGetResponse response = mpAssetService.mediaGet(mediaId);
        log.info("response: {}", response);
    }

    /**
     * 高清语音素材获取测试
     */
    @Test
    public void mediaGetJsSdkTest() {
        String mediaId = "d4k7-GynE9dTWH_AX5NpAWPB-5-31W-7SlhTISDbbQUOq6SxnIY5A5kWsaJti-Dm";
        MediaGetResponse response = mpAssetService.mediaGetJsSdk(mediaId);
        log.info("response: {}", response);
    }

    /**
     * 新增永久素材,上传图文消息内的图片获取URL测试 <br>
     * 如: http://mmbiz.qpic.cn/mmbiz_png/7y1b8ZPgjeaibDBrLtIZDdFzeiasTxYhvyiac5VK9UmEXmKjDPGbSs5IRMegSvq0J6nehiblZjRm8VcOvdOcUBRYuA/0
     */
    @Test
    public void mediaUploadImgTest() {
        String fileName = "logo_240.png";
        String filePath = "files/" + fileName;
        InputStream inputStream = ClassLoader.getSystemResourceAsStream(filePath);
        String contentType = MimeContentTypes.IMAGE_PNG;
        MediaUploadImgRequest request = new MediaUploadImgRequest(fileName, inputStream, contentType);
        MediaUploadImgResponse response = mpAssetService.mediaUploadImg(request);
        log.info("response: {}", response);
    }

    /**
     * 新增永久素材, 新增其他类型永久素材测试 <br>
     * 如: {mediaId='pZ77j-s5MUUlvpP5wHw-ad_DUyd569znfr7I7sHqoZvhtzy1Amf0JaG2H2D6T-4x', url='http://mmbiz.qpic.cn/mmbiz_png/7y1b8ZPgjeaibDBrLtIZDdFzeiasTxYhvyiac5VK9UmEXmKjDPGbSs5IRMegSvq0J6nehiblZjRm8VcOvdOcUBRYuA/0?wx_fmt=png'}
     */
    @Test
    public void materialAddTest() {
        MediaConstant.MediaType mediaType = MediaConstant.MediaType.IMAGE;
        String fileName = "logo_240.png";
        String filePath = "files/" + fileName;
        InputStream inputStream = ClassLoader.getSystemResourceAsStream(filePath);
        String contentType = MimeContentTypes.IMAGE_PNG;
        MaterialAddRequest request = new MaterialAddRequest(fileName, mediaType, inputStream, contentType);
        MediaAddResponse response = mpAssetService.materialAdd(request);
        log.info("response: {}", response);
    }

    /**
     * 获取永久素材测试
     */
    @Test
    public void materialGetTest() {
        String mediaId = "pZ77j-s5MUUlvpP5wHw-ad_DUyd569znfr7I7sHqoZvhtzy1Amf0JaG2H2D6T-4x";
        MaterialGetResponse response = mpAssetService.materialGet(new MaterialGetRequest(mediaId));
        log.info("response: {}", response);
    }

    /**
     * 删除永久素材测试
     */
    @Test
    public void materialDelTest() {
        String mediaId = "pZ77j-s5MUUlvpP5wHw-ad_DUyd569znfr7I7sHqoZvhtzy1Amf0JaG2H2D6T-4x";
        MaterialDelRequest request = new MaterialDelRequest(mediaId);
        WeChatMpResponseEntity response = mpAssetService.materialDel(request);
        log.info("response: {}", response);
    }

    /**
     * 获取素材总数
     */
    @Test
    public void materialGetCountTest() {
        WeChatMpResponseEntity response = mpAssetService.materialGetCount();
        log.info("response: {}", response);
    }

    /**
     * 获取素材列表
     */
    @Test
    public void materialBatchGetTest() {
        MediaConstant.MediaType mediaType = MediaConstant.MediaType.IMAGE;
        MaterialBatchGetResponse response = mpAssetService.materialBatchGet(new MaterialBatchGetRequest(mediaType));
        log.info("response: {}", response);
    }
}
