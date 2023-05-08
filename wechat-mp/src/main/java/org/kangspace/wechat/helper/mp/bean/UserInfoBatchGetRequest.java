package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.kangspace.wechat.helper.core.constant.WeChatLang;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;

/**
 * 用户管理-批量获取用户基本信息 请求参数
 *
 * @author kango2gler@gmail.com
 * @since 2023/5/8
 */
@NoArgsConstructor
@Data
public class UserInfoBatchGetRequest {
    @JsonProperty("user_list")
    private List<User> userList;

    @Data
    public static class User{
        /**
         * 用户OpenId
         */
        @Nonnull
        @JsonProperty("openid")
        private String openId;

        /**
         * 国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语，默认为zh-CN
         */
        @JsonProperty("lang")
        private WeChatLang lang;

        public User(@Nonnull String openId) {
            this.openId = openId;
            this.lang = WeChatLang.ZH_CN;
        }

        public User(@Nonnull String openId, WeChatLang lang) {
            this.openId = openId;
            this.lang = lang;
        }
    }

    public UserInfoBatchGetRequest(User... userList) {
        this.userList = Arrays.asList(userList);
    }

    public UserInfoBatchGetRequest(List<User> userList) {
        this.userList = userList;
    }
}
