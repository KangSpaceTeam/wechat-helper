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


    // ----------------获取企业微信服务器 IP 地址接口-------------------
    /**
     * <p>
     * 获取企业微信 API 接口 IP地址
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/92520">https://developer.work.weixin.qq.com/document/path/92520</a> <br>
     * http请求方式: GET https://qyapi.weixin.qq.com/cgi-bin/get_api_domain_ip?access_token=ACCESS_TOKEN
     * </p>
     */
    String GET_API_DOMAIN_IP = BASE_PATH + "/get_api_domain_ip";

    /**
     * <p>
     * 获取企业微信callback IP地址
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/92521">https://developer.work.weixin.qq.com/document/path/92521</a> <br>
     * http请求方式: GET https://qyapi.weixin.qq.com/cgi-bin/getcallbackip?access_token=ACCESS_TOKEN
     * </p>
     */
    String GET_CALLBACK_IP = BASE_PATH + "/getcallbackip";

    // ----------------帐号ID 接口-------------------

    /**
     * <p>
     * 自建应用与第三方应用的对接-userid转换<br>
     * 将代开发应用或第三方应用获取的密文open_userid转换为明文userid。
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/95884">https://developer.work.weixin.qq.com/document/path/95884</a> <br>
     * http请求方式: POST https://qyapi.weixin.qq.com/cgi-bin/batch/openuserid_to_userid?access_token=ACCESS_TOKEN
     * </p>
     */
    String BATCH_OPEN_USERID_TO_USERID = BASE_PATH + "/batch/openuserid_to_userid";

    /**
     * <p>
     * 自建应用与第三方应用的对接-external_userid转换 <br>
     * 将代开发应用或第三方应用获取的externaluserid转换成自建应用的externaluserid。
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/95884">https://developer.work.weixin.qq.com/document/path/95884</a> <br>
     * http请求方式: POST https://qyapi.weixin.qq.com/cgi-bin/externalcontact/from_service_external_userid?access_token=ACCESS_TOKEN
     * </p>
     */
    String EXTERNAL_CONTACT_FROM_SERVICE_EXTERNAL_USERID = BASE_PATH + "/externalcontact/from_service_external_userid";

    /**
     * <p>
     * tmp_external_userid的转换 <br>
     * 将应用获取的外部用户临时idtmp_external_userid，转换为external_userid。 <br>
     * 支持将以下业务类型（business_type）对应接口获取到的tmp_external_userid进行转换： <br>
     * 业务类型	描述	相关接口  <br>
     * 1	会议	获取会议详情   <br>
     * 2	收集表	收集表的统计信息查询  读取收集表答案<br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/98729">https://developer.work.weixin.qq.com/document/path/98729</a> <br>
     * http请求方式: POST https://qyapi.weixin.qq.com/cgi-bin/idconvert/convert_tmp_external_userid?access_token=ACCESS_TOKEN
     * </p>
     */
    String ID_CONVERT_CONVERT_TMP_EXTERNAL_USERID = BASE_PATH + "/idconvert/convert_tmp_external_userid";


}
