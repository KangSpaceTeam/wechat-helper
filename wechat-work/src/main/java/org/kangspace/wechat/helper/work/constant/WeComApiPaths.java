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
    String QYAPI_BASE_PATH = "https://qyapi.weixin.qq.com/cgi-bin";

    /**
     * 开放平台-接口基础路径
     */
    String OPEN_BASE_PATH = "https://open.weixin.qq.com";

    /**
     * 获取Access token
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/91039">https://developer.work.weixin.qq.com/document/path/91039</a>
     * <pre>
     * https请求方式: GET https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=ID&corpsecret=SECRET
     * corpid	是	企业ID，获取方式参考：<a href="https://developer.work.weixin.qq.com/document/path/90665#corpid">术语说明-corpid</a>
     * corpsecret	是	应用的凭证密钥，注意应用需要是启用状态，获取方式参考：<a href="https://developer.work.weixin.qq.com/document/path/90665#secret">术语说明-secret</a>
     * </pre>
     */
    String GET_TOKEN = QYAPI_BASE_PATH + "/gettoken?corpid={0}&corpsecret={1}";


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
    String GET_API_DOMAIN_IP = QYAPI_BASE_PATH + "/get_api_domain_ip";

    /**
     * <p>
     * 获取企业微信callback IP地址
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/92521">https://developer.work.weixin.qq.com/document/path/92521</a> <br>
     * http请求方式: GET https://qyapi.weixin.qq.com/cgi-bin/getcallbackip?access_token=ACCESS_TOKEN
     * </p>
     */
    String GET_CALLBACK_IP = QYAPI_BASE_PATH + "/getcallbackip";

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
    String BATCH_OPEN_USERID_TO_USERID = QYAPI_BASE_PATH + "/batch/openuserid_to_userid";

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
    String EXTERNAL_CONTACT_FROM_SERVICE_EXTERNAL_USERID = QYAPI_BASE_PATH + "/externalcontact/from_service_external_userid";

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
    String ID_CONVERT_CONVERT_TMP_EXTERNAL_USERID = QYAPI_BASE_PATH + "/idconvert/convert_tmp_external_userid";

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
    String USER_GET = QYAPI_BASE_PATH + "/user/get?userid={0}";

    /**
     * <p>
     * 创建成员 <br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/90195">https://developer.work.weixin.qq.com/document/path/90195</a> <br>
     * http请求方式: POST https://qyapi.weixin.qq.com/cgi-bin/user/create?access_token=ACCESS_TOKEN
     * </p>
     */
    String USER_CREATE = QYAPI_BASE_PATH + "/user/create";

    /**
     * <p>
     * 更新成员 <br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/90197">https://developer.work.weixin.qq.com/document/path/90197</a> <br>
     * http请求方式: POST https://qyapi.weixin.qq.com/cgi-bin/user/update?access_token=ACCESS_TOKEN
     * </p>
     */
    String USER_UPDATE = QYAPI_BASE_PATH + "/user/update";

    /**
     * <p>
     * 删除成员 <br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/90198">https://developer.work.weixin.qq.com/document/path/90198</a> <br>
     * http请求方式: GET https://qyapi.weixin.qq.com/cgi-bin/user/update?access_token=ACCESS_TOKEN
     * </p>
     */
    String USER_DELETE = QYAPI_BASE_PATH + "/user/delete?&userid={0}";

    /**
     * <p>
     * 批量删除成员 <br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/90199">https://developer.work.weixin.qq.com/document/path/90199</a> <br>
     * http请求方式: GET https://qyapi.weixin.qq.com/cgi-bin/user/batchdelete?access_token=ACCESS_TOKEN
     * </p>
     */
    String USER_BATCH_DELETE = QYAPI_BASE_PATH + "/user/batchdelete";

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
    String USER_SIMPLE_LIST = QYAPI_BASE_PATH + "/user/simplelist?department_id={0}";

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
    String USER_LIST = QYAPI_BASE_PATH + "/user/list?department_id={0}";

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
    String USER_CONVERT_TO_OPEN_ID = QYAPI_BASE_PATH + "/user/convert_to_openid";

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
    String USER_CONVERT_TO_USER_ID = QYAPI_BASE_PATH + "/user/convert_to_userid";

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
    String USER_AUTH_SUCC = QYAPI_BASE_PATH + "/user/authsucc?userid={0}";

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
    String BATCH_INVITE = QYAPI_BASE_PATH + "/batch/invite";

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
    String CORP_GET_JOIN_QRCODE = QYAPI_BASE_PATH + "/corp/get_join_qrcode?size_type={0}";

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
    String USER_GET_USER_ID = QYAPI_BASE_PATH + "/user/getuserid";

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
    String USER_GET_USER_ID_BY_EMAIL = QYAPI_BASE_PATH + "/user/get_userid_by_email";

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
    String USER_LIST_ID = QYAPI_BASE_PATH + "/user/list_id";


    // ----------------通讯录管理-部门管理 接口-------------------
    /**
     * <p>
     * 创建部门<br>
     * <p>
     * 权限说明：<br>
     * 第三方仅通讯录应用可以调用。<br>
     * 注意，部门的最大层级为15层；部门总数不能超过3万个；每个部门下的节点不能超过3万个。建议保证创建的部门和对应部门成员是串行化处理。<br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/90205">https://developer.work.weixin.qq.com/document/path/90205</a> <br>
     * http请求方式: POST https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token=ACCESS_TOKEN
     * </p>
     */
    String DEPARTMENT_CREATE = QYAPI_BASE_PATH + "/department/create";

    /**
     * <p>
     * 更新部门<br>
     * <p>
     * 权限说明：<br>
     * 第三方仅通讯录应用可以调用。<br>
     * 应用须拥有指定部门的管理权限。如若要移动部门，需要有新父部门的管理权限。<br>
     * 注意，部门的最大层级为15层；部门总数不能超过3万个；每个部门下的节点不能超过3万个。建议保证创建的部门和对应部门成员是串行化处理。<br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/90206">https://developer.work.weixin.qq.com/document/path/90206</a> <br>
     * http请求方式: POST https://qyapi.weixin.qq.com/cgi-bin/department/update?access_token=ACCESS_TOKEN
     * </p>
     */
    String DEPARTMENT_UPDATE = QYAPI_BASE_PATH + "/department/update";

    /**
     * <p>
     * 删除部门<br>
     * <p>
     * 权限说明：<br>
     * 第三方仅通讯录应用可以调用。<br>
     * 应用须拥有指定部门的管理权限。<br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/90207">https://developer.work.weixin.qq.com/document/path/90207</a> <br>
     * http请求方式: GET https://qyapi.weixin.qq.com/cgi-bin/department/delete?access_token=ACCESS_TOKEN
     * </p>
     */
    String DEPARTMENT_DELETE = QYAPI_BASE_PATH + "/department/delete?id={0}";

    /**
     * <p>
     * 获取部门列表<br>
     * 【重要】从2022年8月15日10点开始，“企业管理后台 - 管理工具 - 通讯录同步”的新增IP将不能再调用此接口，企业可通过「获取部门ID列表」接口获取部门ID列表。查看调整详情。<br>
     * 权限说明：<br>
     * 只能拉取token对应的应用的权限范围内的部门列表<br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/90208">https://developer.work.weixin.qq.com/document/path/90208</a> <br>
     * http请求方式: GET https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token=ACCESS_TOKEN
     * </p>
     */
    String DEPARTMENT_LIST = QYAPI_BASE_PATH + "/department/list?id={0}";

    /**
     * <p>
     * 获取子部门ID列表<br>
     * 权限说明：<br>
     * 第三方普通应用	若企业授权了“组织架构信息”权限，可获取企业所有部门id; 若未授权“组织架构信息”权限，只能拉取token对应的应用的权限范围内的部门列表<br>
     * 第三方通讯录应用	可获取企业所有部门id<br>
     * 代开发自建应用	只能拉取token对应的应用的权限范围内的部门列表<br>
     * 普通自建应用	只能拉取token对应的应用的权限范围内的部门列表<br>
     * 通讯录同步助手	可获取企业所有部门id<br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/95350">https://developer.work.weixin.qq.com/document/path/95350</a> <br>
     * http请求方式: GET https://qyapi.weixin.qq.com/cgi-bin/department/simplelist?access_token=ACCESS_TOKEN
     * </p>
     */
    String DEPARTMENT_SIMPLE_LIST = QYAPI_BASE_PATH + "/department/simplelist?id={0}";

    /**
     * <p>
     * 获取单个部门详情<br>
     * 【重要】从2022年8月15日10点开始，“企业管理后台 - 管理工具 - 通讯录同步”的新增IP将不能再调用此接口，企业可通过「获取部门ID列表」接口获取部门ID列表。查看调整详情。<br>
     * 权限说明：<br>
     * 第三方普通应用	若企业授权了“组织架构信息”权限，可获取企业所有部门id; 若未授权“组织架构信息”权限，只能拉取token对应的应用的权限范围内的部门列表<br>
     * 第三方通讯录应用	可获取企业所有部门id<br>
     * 代开发自建应用	只能拉取token对应的应用的权限范围内的部门列表<br>
     * 普通自建应用	只能拉取token对应的应用的权限范围内的部门列表<br>
     * 通讯录同步助手	可获取企业所有部门id<br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/95350">https://developer.work.weixin.qq.com/document/path/95350</a> <br>
     * http请求方式: GET https://qyapi.weixin.qq.com/cgi-bin/department/simplelist?access_token=ACCESS_TOKEN
     * </p>
     */
    String DEPARTMENT_GET = QYAPI_BASE_PATH + "/department/get?id={0}";

    // ----------------通讯录管理-标签管理 接口-------------------
    /**
     * <p>
     * 创建标签<br>
     * 权限说明：<br>
     * 创建的标签属于该应用，只有该应用的secret才可以增删成员。<br>
     * 注意，标签总数不能超过3000个。<br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/90210">https://developer.work.weixin.qq.com/document/path/90210</a> <br>
     * http请求方式: POST https://qyapi.weixin.qq.com/cgi-bin/tag/create?access_token=ACCESS_TOKEN
     * </p>
     */
    String TAG_CREATE = QYAPI_BASE_PATH + "/tag/create";

    /**
     * <p>
     * 更新标签名字<br>
     * 权限说明：<br>
     * 调用的应用必须是指定标签的创建者。<br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/90211">https://developer.work.weixin.qq.com/document/path/90211</a> <br>
     * http请求方式: POST https://qyapi.weixin.qq.com/cgi-bin/tag/update?access_token=ACCESS_TOKEN
     * </p>
     */
    String TAG_UPDATE = QYAPI_BASE_PATH + "/tag/update";

    /**
     * <p>
     * 删除标签<br>
     * 权限说明：<br>
     * 调用的应用必须是指定标签的创建者。<br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/90212">https://developer.work.weixin.qq.com/document/path/90212</a> <br>
     * http请求方式: GET https://qyapi.weixin.qq.com/cgi-bin/tag/delete?access_token=ACCESS_TOKEN&tagid=TAGID
     * </p>
     */
    String TAG_DELETE = QYAPI_BASE_PATH + "/tag/delete?tagid={0}";

    /**
     * <p>
     * 获取标签成员<br>
     * 权限说明：<br>
     * 无限制，但返回列表仅包含应用可见范围的成员；第三方可获取自己创建的标签及应用可见范围内的标签详情。<br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/90213">https://developer.work.weixin.qq.com/document/path/90213</a> <br>
     * http请求方式: GET https://qyapi.weixin.qq.com/cgi-bin/tag/get?access_token=ACCESS_TOKEN&tagid=TAGID
     * </p>
     */
    String TAG_GET = QYAPI_BASE_PATH + "/tag/get?tagid={0}";

    /**
     * <p>
     * 增加标签成员<br>
     * 权限说明：<br>
     * 调用的应用必须是指定标签的创建者；成员属于应用的可见范围。<br>
     * 注意，每个标签下部门数和人员数总和不能超过3万个。<br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/90214">https://developer.work.weixin.qq.com/document/path/90214</a> <br>
     * http请求方式: POST https://qyapi.weixin.qq.com/cgi-bin/tag/addtagusers?access_token=ACCESS_TOKEN
     * </p>
     */
    String TAG_ADD_TAG_USERS = QYAPI_BASE_PATH + "/tag/addtagusers";

    /**
     * <p>
     * 删除标签成员<br>
     * 权限说明：<br>
     * 调用的应用必须是指定标签的创建者；成员属于应用的可见范围。<br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/90215">https://developer.work.weixin.qq.com/document/path/90215</a> <br>
     * http请求方式: POST https://qyapi.weixin.qq.com/cgi-bin/tag/deltagusers?access_token=ACCESS_TOKEN
     * </p>
     */
    String TAG_DEL_TAG_USERS = QYAPI_BASE_PATH + "/tag/deltagusers";

    /**
     * <p>
     * 获取标签成员<br>
     * 权限说明：<br>
     * 无限制，但返回列表仅包含应用可见范围的成员；第三方可获取自己创建的标签及应用可见范围内的标签详情。<br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/90216">https://developer.work.weixin.qq.com/document/path/90216</a> <br>
     * http请求方式: GET https://qyapi.weixin.qq.com/cgi-bin/tag/list?access_token=ACCESS_TOKEN
     * </p>
     */
    String TAG_LIST = QYAPI_BASE_PATH + "/tag/list";

    // ----------------通讯录管理-互联企业 接口-------------------

    /**
     * <p>
     * 通讯录管理-互联企业-获取应用的可见范围<br>
     * 本接口只返回互联企业中非本企业内的成员和部门的信息，如果要获取本企业的可见范围，请调用“获取应用”接口<br>
     * 权限说明：<br>
     * 仅自建应用可调用。<br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/93172">https://developer.work.weixin.qq.com/document/path/93172</a> <br>
     * http请求方式: POST https://qyapi.weixin.qq.com/cgi-bin/linkedcorp/agent/get_perm_list?access_token=ACCESS_TOKEN
     * </p>
     */
    String LINKED_CORP_AGENT_GET_PERM_LIST = QYAPI_BASE_PATH + "/linkedcorp/agent/get_perm_list";

    /**
     * <p>
     * 通讯录管理-互联企业-获取互联企业成员详细信息<br>
     * 权限说明：<br>
     * 仅自建应用可调用，应用须拥有指定成员的查看权限。<br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/93171">https://developer.work.weixin.qq.com/document/path/93171</a> <br>
     * http请求方式: POST  https://qyapi.weixin.qq.com/cgi-bin/linkedcorp/user/get?access_token=ACCESS_TOKEN
     * </p>
     */
    String LINKED_CORP_USER_GET = QYAPI_BASE_PATH + "/linkedcorp/user/get";

    /**
     * <p>
     * 通讯录管理-互联企业-获取互联企业部门成员<br>
     * 权限说明：<br>
     * 仅自建应用可调用，应用须拥有指定部门的查看权限。<br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/93168">https://developer.work.weixin.qq.com/document/path/93168</a> <br>
     * http请求方式: POST   https://qyapi.weixin.qq.com/cgi-bin/linkedcorp/user/simplelist?access_token=ACCESS_TOKEN
     * </p>
     */
    String LINKED_CORP_USER_SIMPLE_LIST = QYAPI_BASE_PATH + "/linkedcorp/user/simplelist";

    /**
     * <p>
     * 通讯录管理-互联企业-获取互联企业部门成员详情<br>
     * 权限说明：<br>
     * 仅自建应用可调用，应用须拥有指定部门的查看权限。<br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/93168">https://developer.work.weixin.qq.com/document/path/93168</a> <br>
     * http请求方式: POST   https://qyapi.weixin.qq.com/cgi-bin/linkedcorp/user/list?access_token=ACCESS_TOKEN
     * </p>
     */
    String LINKED_CORP_USER_LIST = QYAPI_BASE_PATH + "/linkedcorp/user/list";

    /**
     * <p>
     * 通讯录管理-互联企业-获取互联企业部门列表<br>
     * 权限说明：<br>
     * 仅自建应用可调用，应用须拥有指定部门的查看权限。<br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/93168">https://developer.work.weixin.qq.com/document/path/93168</a> <br>
     * http请求方式: POST   https://qyapi.weixin.qq.com/cgi-bin/linkedcorp/department/list?access_token=ACCESS_TOKEN
     * </p>
     */
    String LINKED_CORP_DEPARTMENT_LIST = QYAPI_BASE_PATH + "/linkedcorp/department/list";


    // ----------------身份验证 接口-------------------

    /**
     * <p>
     * 身份验证-网页授权登录<br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/91022">https://developer.work.weixin.qq.com/document/path/91022</a> <br>
     * http请求方式: GET https://open.weixin.qq.com/connect/oauth2/authorize?appid=CORPID&redirect_uri=REDIRECT_URI&response_type=code&scope=snsapi_base&state=STATE&agentid=AGENTID#wechat_redirect<br>
     * 参数: <br>
     * 0: CORPID, 企业的CorpID <br>
     * 1: REDIRECT_URI, 授权后重定向的回调链接地址，请使用urlencode对链接进行处理<br>
     * 2: scope, 应用授权作用域。<br>
     * snsapi_base：静默授权，可获取成员的基础信息（UserId与DeviceId）；<br>
     * snsapi_privateinfo：手动授权，可获取成员的详细信息，包含头像、二维码等敏感信息。<br>
     * 3: STATE, 重定向后会带上state参数，企业可以填写a-zA-Z0-9的参数值，长度不可超过128个字节<br>
     * 4: AGENTID, 应用agentid，建议填上该参数（对于第三方应用和代开发自建应用，在填写该参数的情况下或者在工作台、聊天工具栏、应用会话内发起oauth2请求的场景中，会触发接口许可的自动激活）。snsapi_privateinfo时必填否则报错；<br>
     * </p>
     */
    String CONNECT_OAUTH2_AUTHORIZE = OPEN_BASE_PATH + "/connect/oauth2/authorize?appid={0}&redirect_uri={1}&response_type=code&scope={2}&state={3}&agentid={4}#wechat_redirect";

    /**
     * <p>
     * 身份验证-获取访问用户身份<br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/91023">https://developer.work.weixin.qq.com/document/path/91023</a> <br>
     * http请求方式: GET https://qyapi.weixin.qq.com/cgi-bin/auth/getuserinfo?access_token=ACCESS_TOKEN&code=CODE <br>
     * 参数: <br>
     * 0: CODE, 通过成员授权获取到的code，最大为512字节。每次成员授权带上的code将不一样，code只能使用一次，5分钟未被使用自动过期。 <br>
     * </p>
     */
    String AUTH_GET_USER_INFO = QYAPI_BASE_PATH + "/auth/getuserinfo?code={0}";

    /**
     * <p>
     * 身份验证-获取访问用户敏感信息<br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/91033">https://developer.work.weixin.qq.com/document/path/91033</a> <br>
     * http请求方式: POST https://qyapi.weixin.qq.com/cgi-bin/auth/getuserdetail?access_token=ACCESS_TOKEN <br>
     * </p>
     */
    String AUTH_GET_USER_DETAIL = QYAPI_BASE_PATH + "/auth/getuserdetail";

    // ----------------企业互联 接口-------------------

    /**
     * <p>
     * 企业互联-获取应用共享信息<br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/93403">https://developer.work.weixin.qq.com/document/path/93403</a> <br>
     * http请求方式: POST https://qyapi.weixin.qq.com/cgi-bin/corpgroup/corp/list_app_share_info?access_token=ACCESS_TOKEN <br>
     * </p>
     */
    String CORP_GROUP_CORP_LIST_APP_SHARE_INFO = QYAPI_BASE_PATH + "/corpgroup/corp/list_app_share_info";

    /**
     * <p>
     * 企业互联-获取下级/下游企业的access_token <br>
     * 获取应用可见范围内下级/下游企业的access_token，该access_token可用于调用下级/下游企业通讯录的只读接口。<br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/93359">https://developer.work.weixin.qq.com/document/path/93359</a> <br>
     * http请求方式: POST https://qyapi.weixin.qq.com/cgi-bin/corpgroup/corp/gettoken?access_token=ACCESS_TOKEN <br>
     * </p>
     */
    String CORP_GROUP_CORP_GET_TOKEN = QYAPI_BASE_PATH + "/corpgroup/corp/gettoken";

    /**
     * <p>
     * 企业互联-获取下级/下游企业小程序session <br>
     * 上级/上游企业通过该接口转换为下级/下游企业的小程序session<br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/93355">https://developer.work.weixin.qq.com/document/path/93355</a> <br>
     * http请求方式: POST https://qyapi.weixin.qq.com/cgi-bin/miniprogram/transfer_session?access_token=ACCESS_TOKEN <br>
     * </p>
     */
    String MINI_PROGRAM_TRANSFER_SESSION = QYAPI_BASE_PATH + "/miniprogram/transfer_session";

    // ---------------- 接口-------------------
}
