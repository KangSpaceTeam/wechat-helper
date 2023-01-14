package org.kangspace.wechat.helper.core.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


/**
 * 微信响应实体超类
 * <pre>
 * 1. 各模块(wechat-mp,wechat-work等)需继承该超类
 * 2. 子类需自行重写errCode和errMsg, 指定各自需要的错误码和错误信息
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/24
 */
@Getter
@Setter
public class WeChatResponseEntity {
    /**
     * 错误码
     */
    @JsonProperty("errcode")
    private Integer errCode;

    /**
     * 错误消息
     */
    @JsonProperty("errmsg")
    private String errMsg;

    @Override
    public String toString() {
        return "(WeChatResponseEntity)" + "errCode=" + errCode +", errMsg='" + errMsg + '\'';
    }

    /**
     * 是否错误响应
     * @return boolean
     */
    public boolean isError() {
        return errCode != null || errMsg != null;
    }

    /**
     * 是否成功响应
     * @return boolean
     */
    public boolean isSuccess() {
        return !isError();
    }
}
