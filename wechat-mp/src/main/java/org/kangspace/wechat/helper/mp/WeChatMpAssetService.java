package org.kangspace.wechat.helper.mp;

import org.kangspace.wechat.helper.mp.bean.*;

import javax.annotation.Nonnull;

/**
 * 微信公众号"素材管理"相关Service<br>
 * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Asset_Management/New_temporary_materials.html">https://developers.weixin.qq.com/doc/offiaccount/Asset_Management/New_temporary_materials.html</a><br>
 * 公众号经常有需要用到一些临时性的多媒体素材的场景，例如在使用接口特别是发送消息时，对多媒体文件、多媒体消息的获取和调用等操作，是通过media_id来进行的。素材管理接口对所有认证的订阅号和服务号开放。通过本接口，公众号可以新增临时素材（即上传临时多媒体文件）
 *
 * @author kango2gler@gmail.com
 * @since 2023/01/17
 */
public interface WeChatMpAssetService extends WeChatMpService {

    /**
     * 新增临时素材
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Asset_Management/New_temporary_materials.html">https://developers.weixin.qq.com/doc/offiaccount/Asset_Management/New_temporary_materials.html</a>
     *
     * @param request {@link MediaUploadRequest}
     * @return {@link MediaUploadResponse}
     */
    MediaUploadResponse mediaUpload(MediaUploadRequest request);

    /**
     * 获取临时素材<br>
     * 公众号可以使用本接口获取临时素材（即下载临时的多媒体文件）。
     * 本接口即为原“下载多媒体文件”接口。
     *
     * @param mediaId 素材ID
     * @return {@link MediaGetResponse}
     */
    MediaGetResponse mediaGet(@Nonnull String mediaId);

    /**
     * 高清语音素材获取接口 <br/>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Asset_Management/Get_temporary_materials.html">https://developers.weixin.qq.com/doc/offiaccount/Asset_Management/Get_temporary_materials.html</a> <br>
     * 公众号可以使用本接口获取从 JSSDK 的uploadVoice接口上传的临时语音素材，格式为speex，16K采样率。该音频比上文的临时素材获取接口（格式为amr，8K采样率）更加清晰，适合用作语音识别等对音质要求较高的业务。
     *
     * @param mediaId 素材ID
     * @return {@link MediaGetResponse}
     */
    MediaGetResponse mediaGetJsSdk(@Nonnull String mediaId);

    /**
     * 新增永久素材,上传图文消息内的图片获取URL<br>
     * <pre>
     * 对于常用的素材，开发者可通过本接口上传到微信服务器，永久使用。新增的永久素材也可以在公众平台官网素材管理模块中查询管理。
     * 请注意：
     * 1、最近更新：永久图片素材新增后，将带有 URL 返回给开发者，开发者可以在腾讯系域名内使用（腾讯系域名外使用，图片将被屏蔽）。
     * 2、公众号的素材库保存总数量有上限：图文消息素材、图片素材上限为100000，其他类型为1000。
     * 3、素材的格式大小等要求与公众平台官网一致：
     * 图片（image）: 10M，支持bmp/png/jpeg/jpg/gif格式
     * 语音（voice）：2M，播放长度不超过60s，mp3/wma/wav/amr格式
     * 视频（video）：10MB，支持MP4格式
     * 缩略图（thumb）：64KB，支持 JPG 格式
     * 4、图文消息的具体内容中，微信后台将过滤外部的图片链接，图片 url 需通过"上传图文消息内的图片获取URL"接口上传图片获取。
     * 5、"上传图文消息内的图片获取URL"接口所上传的图片，不占用公众号的素材库中图片数量的100000个的限制，图片仅支持jpg/png格式，大小必须在1MB以下。
     * 6、图文消息支持正文中插入自己帐号和其他公众号已群发文章链接的能力。
     * </pre>
     *
     * @param request {@link MediaUploadImgRequest}
     * @return {@link MediaUploadImgResponse}
     */
    MediaUploadImgResponse mediaUploadImg(MediaUploadImgRequest request);

    /**
     * 新增永久素材, 新增其他类型永久素材<br>
     * <pre>
     * 对于常用的素材，开发者可通过本接口上传到微信服务器，永久使用。新增的永久素材也可以在公众平台官网素材管理模块中查询管理。
     * 请注意：
     * 1、最近更新：永久图片素材新增后，将带有 URL 返回给开发者，开发者可以在腾讯系域名内使用（腾讯系域名外使用，图片将被屏蔽）。
     * 2、公众号的素材库保存总数量有上限：图文消息素材、图片素材上限为100000，其他类型为1000。
     * 3、素材的格式大小等要求与公众平台官网一致：
     * 图片（image）: 10M，支持bmp/png/jpeg/jpg/gif格式
     * 语音（voice）：2M，播放长度不超过60s，mp3/wma/wav/amr格式
     * 视频（video）：10MB，支持MP4格式
     * 缩略图（thumb）：64KB，支持 JPG 格式
     * 4、图文消息的具体内容中，微信后台将过滤外部的图片链接，图片 url 需通过"上传图文消息内的图片获取URL"接口上传图片获取。
     * 5、"上传图文消息内的图片获取URL"接口所上传的图片，不占用公众号的素材库中图片数量的100000个的限制，图片仅支持jpg/png格式，大小必须在1MB以下。
     * 6、图文消息支持正文中插入自己帐号和其他公众号已群发文章链接的能力。
     * </pre>
     * 通过 POST 表单来调用接口，表单 id 为media，包含需要上传的素材内容，有filename、filelength、content-type等信息。请注意：图片素材将进入公众平台官网素材管理模块中的默认分组。
     *
     * @param request {@link MaterialAddRequest}
     * @return {@link MediaAddResponse}
     */
    MediaAddResponse materialAdd(MaterialAddRequest request);

    /**
     * 获取永久素材<br>
     * 在新增了永久素材后，开发者可以根据media_id通过本接口下载永久素材。公众号在公众平台官网素材管理模块中新建的永久素材，可通过"获取素材列表"获知素材的media_id。
     * 请注意：临时素材无法通过本接口获取
     *
     * @param mediaId 素材ID
     * @return {@link MediaAddResponse}
     */
    MediaGetResponse materialGet(@Nonnull String mediaId);

    /**
     * 删除永久素材<br>
     * 在新增了永久素材后，开发者可以根据本接口来删除不再需要的永久素材，节省空间。
     * <pre>
     * 请注意：
     * 1、请谨慎操作本接口，因为它可以删除公众号在公众平台官网素材管理模块中新建的图文消息、语音、视频等素材（但需要先通过获取素材列表来获知素材的media_id）
     * 2、临时素材无法通过本接口删除
     * 3、调用该接口需 https 协议
     * </pre>
     *
     * @param request {@link MaterialDelRequest}
     * @return {@link WeChatMpResponseEntity}
     */
    WeChatMpResponseEntity materialDel(MaterialDelRequest request);

    /**
     * 获取素材总数<br>
     * 开发者可以根据本接口来获取永久素材的列表，需要时也可保存到本地。
     * <pre>
     * 请注意：
     * 1.永久素材的总数，也会计算公众平台官网素材管理中的素材
     * 2.图片和图文消息素材（包括单图文和多图文）的总数上限为100000，其他素材的总数上限为1000
     * 3.调用该接口需 https 协议
     * </pre>
     *
     * @return {@link MediaGetCountResponse}
     */
    MediaGetCountResponse materialGetCount();

    /**
     * 获取素材列表<br>
     * <pre>
     * 在新增了永久素材后，开发者可以分类型获取永久素材的列表。
     * 请注意：
     * 1、获取永久素材的列表，也包含公众号在公众平台官网素材管理模块中新建的图文消息、语音、视频等素材
     * 2、临时素材无法通过本接口获取
     * 3、调用该接口需 https 协议
     * </pre>
     *
     * @param request {@link MaterialBatchGetRequest}
     * @return {@link MaterialBatchGetResponse}
     */
    MaterialBatchGetResponse materialBatchGet(MaterialBatchGetRequest request);

}
