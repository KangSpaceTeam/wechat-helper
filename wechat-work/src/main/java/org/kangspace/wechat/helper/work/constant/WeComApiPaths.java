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

    // ----------------通讯录管理-成员管理 接口-------------------
    /**
     * <p>
     * 读取成员 <br>
     * 应用只能获取可见范围内的成员信息，且每种应用获取的字段有所不同，在返回结果说明中会逐个说明。企业通讯录安全特别重要，企业微信将持续升级加固通讯录接口的安全机制， 以下是关键的变更点:<br>
     * - 从2022年6月20号20点开始，除通讯录同步以外的基础应用（如客户联系、微信客服、会话存档、日程等），以及新创建的自建应用与代开发应用，调用该接口时，不再返回以下字段：头像、性别、手机、邮箱、企业邮箱、员工个人二维码、地址，应用需要通过oauth2手工授权的方式获取管理员与员工本人授权的字段。<br>
     * - 【重要】从2022年8月15日10点开始，“企业管理后台 - 管理工具 - 通讯录同步”的新增IP将不能再调用此接口，企业可通过「获取成员ID列表」和「获取部门ID列表」接口获取userid和部门ID列表。查看调整详情。<br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/90196">https://developer.work.weixin.qq.com/document/path/90196</a> <br>
     * http请求方式: GET https://qyapi.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&userid=USERID
     * </p>
     */
    String USER_GET = BASE_PATH + "/user/get?userid={0}";

    /**
     * <p>
     * 创建成员 <br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/90195">https://developer.work.weixin.qq.com/document/path/90195</a> <br>
     * http请求方式: POST https://qyapi.weixin.qq.com/cgi-bin/user/create?access_token=ACCESS_TOKEN
     * </p>
     */
    String USER_CREATE = BASE_PATH + "/user/create";

    /**
     * <p>
     * 更新成员 <br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/90197">https://developer.work.weixin.qq.com/document/path/90197</a> <br>
     * http请求方式: POST https://qyapi.weixin.qq.com/cgi-bin/user/update?access_token=ACCESS_TOKEN
     * </p>
     */
    String USER_UPDATE = BASE_PATH + "/user/update";

    /**
     * <p>
     * 删除成员 <br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/90198">https://developer.work.weixin.qq.com/document/path/90198</a> <br>
     * http请求方式: GET https://qyapi.weixin.qq.com/cgi-bin/user/update?access_token=ACCESS_TOKEN
     * </p>
     */
    String USER_DELETE = BASE_PATH + "/user/delete?&userid={0}";

    /**
     * <p>
     * 批量删除成员 <br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/90199">https://developer.work.weixin.qq.com/document/path/90199</a> <br>
     * http请求方式: GET https://qyapi.weixin.qq.com/cgi-bin/user/batchdelete?access_token=ACCESS_TOKEN
     * </p>
     */
    String USER_BATCH_DELETE = BASE_PATH + "/user/batchdelete";


}
