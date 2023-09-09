package org.kangspace.wechat.helper.work.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * 群机器人-文件上传接口 响应对象
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/15
 */
@Setter
@Getter
public class WebHookUploadMediaResponse extends MediaUploadResponse {
    @Override
    public String toString() {
        return super.isError() ? super.toString() : (
                "WebHookMediaUploadResponse{" +
                        "type='" + this.getType() + '\'' +
                        ", mediaId='" + this.getMediaId() + '\'' +
                        ", createdAt=" + this.getCreatedAt() +
                        "}"
        );
    }
}
