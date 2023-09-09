package org.kangspace.wechat.helper.work;

import org.kangspace.wechat.helper.work.bean.*;
import org.kangspace.wechat.helper.work.constant.MediaConstant;

import javax.annotation.Nonnull;

/**
 * 企业微信"素材管理"相关 Service <br>
 * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/91054">https://developer.work.weixin.qq.com/document/path/91054</a> <br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/09/6
 */
public interface MediaService extends WeComService {
    /**
     * 素材管理-上传临时素材
     *
     * @param request 上传文件请求
     * @return {@link MediaUploadResponse}
     * @see MediaConstant.MediaUploadMediaType
     */
    MediaUploadResponse mediaUpload(@Nonnull MediaUploadRequest request);

    /**
     * 素材管理-上传图片
     *
     * @param request 上传文件请求
     * @return {@link MediaUploadResponse}
     */
    MediaUploadImgResponse mediaUploadImg(@Nonnull MediaUploadImgRequest request);

    /**
     * 素材管理-获取临时素材
     *
     * @param mediaId 媒体ID
     * @return {@link MediaGetResponse}
     */
    MediaGetResponse mediaGet(@Nonnull String mediaId);

    /**
     * 素材管理-获取高清语音素材
     *
     * @param mediaId 媒体ID
     * @return {@link MediaGetResponse}
     */
    MediaGetResponse mediaGetJsSdK(@Nonnull String mediaId);

    /**
     * 素材管理-异步上传临时素材 <br>
     * 上传的媒体文件限制 <br>
     * 所有文件size必须大于5个字节 <br>
     * <p>
     * 图片（image）：暂不支持 <br>
     * 语音（voice） ：暂不支持 <br>
     * 视频（video） ：200MB，仅支持MP4格式 <br>
     * 普通文件（file）：200MB <br>
     *
     * @param request {@link MediaUploadByUrlResponse}
     * @return {@link MediaGetResponse}
     */
    MediaUploadByUrlResponse mediaUploadByUrl(@Nonnull MediaUploadByUrlRequest request);

    /**
     * 素材管理-查询异步任务结果 <br>
     *
     * @param request {@link MediaGetUploadByUrlResultRequest}
     * @return {@link MediaGetResponse}
     */
    MediaGetUploadByUrlResultResponse mediaGetUploadByUrlResult(@Nonnull MediaGetUploadByUrlResultRequest request);
}
