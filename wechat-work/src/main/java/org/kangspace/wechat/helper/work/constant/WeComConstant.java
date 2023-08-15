package org.kangspace.wechat.helper.work.constant;

/**
 * 企业微信相关常量
 *
 * @author kango2gler@gmail.com
 * @since 2022/10/2
 */
public interface WeComConstant {

    /**
     * 群机器人-文件上传接口: 文件类型，分别有语音(voice)和普通文件(file)
     */
    enum WebHookUploadMediaType {
        VOICE, FILE;

        public String getType() {
            return this.name().toLowerCase();
        }

    }
}
