package org.kangspace.wechat.helper.work;

import org.kangspace.wechat.helper.work.bean.MediaUploadRequest;
import org.kangspace.wechat.helper.work.bean.WeComResponseEntity;
import org.kangspace.wechat.helper.work.bean.WebHookUploadMediaResponse;
import org.kangspace.wechat.helper.work.constant.WeComConstant;
import org.kangspace.wechat.helper.work.message.webhook.WebHookMessage;

import javax.annotation.Nonnull;

/**
 * 企业微信"群机器人"相关 Service <br>
 * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/99110">https://developer.work.weixin.qq.com/document/path/99110</a> <br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/08/14
 */
public interface WebHookService extends WeComService {

    /**
     * 群机器人-应用推送消息
     *
     * @param key     调用接口凭证, 机器人webhookurl中的key参数
     * @param message {@link WebHookMessage}
     * @return {@link WeComResponseEntity}
     */
    WeComResponseEntity webhookSend(@Nonnull String key, @Nonnull WebHookMessage message);

    /**
     * 群机器人-文件上传接口
     * <p>
     * 上传的文件限制： <br>
     * 所有类型的文件大小均要求大于5个字节<br>
     * 普通文件(file)：文件大小不超过20M<br>
     * 语音(voice)：文件大小不超过2M，播放长度不超过60s，仅支持AMR格式</p>
     *
     * @param key     调用接口凭证, 机器人webhookurl中的key参数
     * @param type    文件类型，分别有语音(voice)和普通文件(file) {@link WeComConstant.WebHookUploadMediaType}
     * @param request 上传对象
     * @return {@link WeComResponseEntity}
     */
    WebHookUploadMediaResponse webhookUploadMedia(@Nonnull String key, @Nonnull String type, @Nonnull MediaUploadRequest request);
}
