package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 成员对外信息<br>
 * 支持文本、链接、小程序类型<br>
 * <a href="https://developer.work.weixin.qq.com/document/path/92230#13450">https://developer.work.weixin.qq.com/document/path/92230#13450</a>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/17
 */
@Data
public class ExternalProfile {
    /**
     * 企业对外简称，需从已认证的企业简称中选填。可在“我的企业”页中查看企业简称认证状态。
     */
    @JsonProperty("external_corp_name")
    private String externalCorpName;

    /**
     * 视频号属性。须从企业绑定到企业微信的视频号中选择，可在“我的企业”页中查看绑定的视频号。第三方仅通讯录应用可获取；对于非第三方创建的成员，第三方通讯录应用也不可获取。注意：externalcontact/get不返回该字段
     */
    @JsonProperty("wechat_channels")
    private WechatChannels wechatChannels;

    /**
     * 属性列表，目前支持文本、网页、小程序三种类型
     */
    @JsonProperty("external_attr")
    private List<ExternalAttr> externalAttr;

    @Data
    public static class WechatChannels {
        /**
         * 视频号名字（设置后，成员将对外展示该视频号）
         */
        private String nickname;

        /**
         * 对外展示视频号状态。0表示企业视频号已被确认，可正常使用，1表示企业视频号待确认
         */
        private Integer status;
    }
}