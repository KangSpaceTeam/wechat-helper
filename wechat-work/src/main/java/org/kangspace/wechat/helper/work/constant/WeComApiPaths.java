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

    /**
     * <p>
     * 获取部门成员 <br>
     * 【重要】从2022年8月15日10点开始，“企业管理后台 - 管理工具 - 通讯录同步”的新增IP将不能再调用此接口，企业可通过「获取成员ID列表」和「获取部门ID列表」接口获取userid和部门ID列表。查看调整详情。<br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/90200">https://developer.work.weixin.qq.com/document/path/90200</a> <br>
     * http请求方式: GET https://qyapi.weixin.qq.com/cgi-bin/user/simplelist?access_token=ACCESS_TOKEN&department_id=DEPARTMENT_ID
     * </p>
     */
    String USER_SIMPLE_LIST = BASE_PATH + "/user/simplelist?department_id={0}";

    /**
     * <p>
     * 获取部门成员详情 <br>
     * 应用只能获取可见范围内的成员信息，且每种应用获取的字段有所不同，在返回结果说明中会逐个说明。企业通讯录安全特别重要，企业微信持续升级加固通讯录接口的安全机制，以下是关键的变更点：<br>
     * - 从2022年6月20号20点开始，除通讯录同步以外的基础应用（如客户联系、微信客服、会话存档、日程等），以及新创建的自建应用与代开发应用，调用该接口时，不再返回以下字段：头像、性别、手机、邮箱、企业邮箱、员工个人二维码、地址，应用需要通过oauth2手工授权的方式获取管理员与员工本人授权的字段。<br>
     * - 【重要】从2022年8月15日10点开始，“企业管理后台 - 管理工具 - 通讯录同步”的新增IP将不能再调用此接口，企业可通过「获取成员ID列表」和「获取部门ID列表」接口获取userid和部门ID列表。查看调整详情。<br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/90201">https://developer.work.weixin.qq.com/document/path/90201</a> <br>
     * http请求方式: GET https://qyapi.weixin.qq.com/cgi-bin/user/list?access_token=ACCESS_TOKEN&department_id=DEPARTMENT_ID
     * </p>
     */
    String USER_LIST = BASE_PATH + "/user/list?department_id={0}";

    /**
     * <p>
     * userid与openid互换-userid转openid <br>
     * 该接口使用场景为企业支付，在使用企业红包和向员工付款时，需要自行将企业微信的userid转成openid。<br>
     * 注：需要成员使用微信登录企业微信或者关注微信插件（原企业号）才能转成openid;<br>
     * 如果是外部联系人，请使用外部联系人openid转换转换openid<br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/90202">https://developer.work.weixin.qq.com/document/path/90202</a> <br>
     * http请求方式: POST https://qyapi.weixin.qq.com/cgi-bin/user/convert_to_openid?access_token=ACCESS_TOKEN
     * </p>
     */
    String USER_CONVERT_TO_OPEN_ID = BASE_PATH + "/user/convert_to_openid";

    /**
     * <p>
     * userid与openid互换-openid转userid <br>
     * 该接口主要应用于使用企业支付之后的结果查询。 <br>
     * 开发者需要知道某个结果事件的openid对应企业微信内成员的信息时，可以通过调用该接口进行转换查询。 <br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/90202">https://developer.work.weixin.qq.com/document/path/90202</a> <br>
     * http请求方式: POST https://qyapi.weixin.qq.com/cgi-bin/user/convert_to_userid?access_token=ACCESS_TOKEN
     * </p>
     */
    String USER_CONVERT_TO_USER_ID = BASE_PATH + "/user/convert_to_userid";

    /**
     * <p>
     * 二次验证<br>
     * 此接口可以满足安全性要求高的企业进行成员验证。开启二次验证后，当且仅当成员登录时，需跳转至企业自定义的页面进行验证。验证频率可在设置页面选择。 <br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/90203">https://developer.work.weixin.qq.com/document/path/90203</a> <br>
     * http请求方式: GET https://qyapi.weixin.qq.com/cgi-bin/user/authsucc?access_token=ACCESS_TOKEN&userid=USERID
     * </p>
     */
    String USER_AUTH_SUCC = BASE_PATH + "/user/authsucc?userid={0}";

    /**
     * <p>
     * 邀请成员<br>
     * 企业可通过接口批量邀请成员使用企业微信，邀请后将通过短信或邮件下发通知。 <br>
     * 权限说明：<br>
     * 须拥有指定成员、部门或标签的查看权限。<br>
     * 第三方仅通讯录应用可调用。<br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/90975">https://developer.work.weixin.qq.com/document/path/90975</a> <br>
     * http请求方式: GET https://qyapi.weixin.qq.com/cgi-bin/batch/invite?access_token=ACCESS_TOKEN
     * </p>
     */
    String BATCH_INVITE = BASE_PATH + "/batch/invite";

    /**
     * <p>
     * 获取加入企业二维码<br>
     * 支持企业用户获取实时成员加入二维码。 <br>
     * size_type	否	qrcode尺寸类型，1: 171 x 171; 2: 399 x 399; 3: 741 x 741; 4: 2052 x 2052<br>
     * 权限说明：<br>
     * 须拥有通讯录的管理权限，使用通讯录同步的Secret。<br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/90975">https://developer.work.weixin.qq.com/document/path/90975</a> <br>
     * http请求方式: GET https://qyapi.weixin.qq.com/cgi-bin/corp/get_join_qrcode?access_token=ACCESS_TOKEN&size_type=SIZE_TYPE
     * </p>
     */
    String CORP_GET_JOIN_QRCODE = BASE_PATH + "/corp/get_join_qrcode?size_type={0}";

    /**
     * <p>
     * 手机号获取userid<br>
     * 通过手机号获取其所对应的userid。 <br>
     * 权限说明：<br>
     * 须拥有通讯录的管理权限，使用通讯录同步的Secret。<br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/95402">https://developer.work.weixin.qq.com/document/path/95402</a> <br>
     * http请求方式: POST https://qyapi.weixin.qq.com/cgi-bin/user/getuserid?access_token=ACCESS_TOKEN
     * </p>
     */
    String USER_GET_USER_ID = BASE_PATH + "/user/getuserid";

    /**
     * <p>
     * 邮箱获取userid<br>
     * 通过邮箱获取其所对应的userid。 <br>
     * 权限说明：<br>
     * 应用须拥有指定成员的查看权限。。<br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/95895">https://developer.work.weixin.qq.com/document/path/95895</a> <br>
     * http请求方式: POST https://qyapi.weixin.qq.com/cgi-bin/user/get_userid_by_email?access_token=ACCESS_TOKEN
     * </p>
     */
    String USER_GET_USER_ID_BY_EMAIL = BASE_PATH + "/user/get_userid_by_email";

    /**
     * <p>
     * 获取成员ID列表<br>
     * 获取企业成员的userid与对应的部门ID列表，预计于2022年8月8号发布。若需要获取其他字段，参见「适配建议」。<br>
     * 权限说明：<br>
     * 仅支持通过“通讯录同步secret”调用。<br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/95895">https://developer.work.weixin.qq.com/document/path/95895</a> <br>
     * http请求方式: POST https://qyapi.weixin.qq.com/cgi-bin/user/list_id?access_token=ACCESS_TOKEN
     * </p>
     */
    String USER_LIST_ID = BASE_PATH + "/user/list_id";


}
