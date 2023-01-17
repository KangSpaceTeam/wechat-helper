package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import org.kangspace.wechat.helper.core.util.JsonParser;

/**
 * 微信公众号素材管理:新增其他类型永久素材 参数
 *
 * @author kango2gler@gmail.com
 * @since 2023/01/17
 */
@Data
@ToString(callSuper = true)
public class MaterialAddRequest extends MediaUploadRequest {

    /**
     * 视频素材描述<br>
     * 新增永久视频素材需特别注意, 在上传视频素材时需要 POST 另一个表单，id为description，包含素材的描述信息，内容格式为JSON。
     */
    @JsonProperty(value = "description")
    private Description description;


    /**
     * 转换为Json字符串
     *
     * @return Json字符串
     */
    public String getDescriptionString() {
        return this.getDescription() != null ? JsonParser.toJsonString(this.getDescription()) : "";
    }

    /**
     * 视频描述 <br>
     * 在上传视频素材时需要 POST 另一个表单，id为description，包含素材的描述信息，内容格式为JSON
     */
    @Data
    public static class Description {
        private String title;
        private String introduction;
    }
}
