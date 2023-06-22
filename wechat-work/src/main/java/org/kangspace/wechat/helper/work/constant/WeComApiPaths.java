package org.kangspace.wechat.helper.work.constant;

/**
 * <p>
 * 企业微信API路径常量类
 * </p>
 * <b>企业微信API响应格式: JSON</b>
 *
 * @author kango2gler@gmail.com
 * @since 2023/6/22
 */
public interface WeComApiPaths {
    /**
     * 接口基础路径
     */
    String BASE_PATH = "https://qyapi.weixin.qq.com/cgi-bin";

    /**
     * 获取Access token
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/91039">https://developer.work.weixin.qq.com/document/path/91039</a>
     * <pre>
     * https请求方式: GET https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=ID&corpsecret=SECRET
     * corpid	是	企业ID，获取方式参考：<a href="https://developer.work.weixin.qq.com/document/path/90665#corpid">术语说明-corpid</a>
     * corpsecret	是	应用的凭证密钥，注意应用需要是启用状态，获取方式参考：<a href="https://developer.work.weixin.qq.com/document/path/90665#secret">术语说明-secret</a>
     * </pre>
     */
    String GET_TOKEN = BASE_PATH + "/gettoken?corpid={0}&corpsecret={1}";
}
