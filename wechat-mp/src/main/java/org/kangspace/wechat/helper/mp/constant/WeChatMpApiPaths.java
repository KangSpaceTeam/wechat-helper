package org.kangspace.wechat.helper.mp.constant;

import org.kangspace.wechat.helper.core.util.UrlUtil;

import java.text.MessageFormat;

/**
 * <p>
 * 微信公众号API路径常量类
 * </p>
 * <b>微信公众号API响应格式: JSON</b>
 *
 * @author kango2gler@gmail.com
 * @since 2022/11/24
 */
public interface WeChatMpApiPaths {
    /**
     * 接口基础路径
     */
    String BASE_PATH = "https://api.weixin.qq.com/cgi-bin";

    /**
     * 公众号MP C端路径
     */
    String MP_BASE_PATH = "https://mp.weixin.qq.com/mp";

    /**
     * "wxapi" 接口路径
     */
    String WX_API_BASE_PATH = "https://api.weixin.qq.com/wxaapi";

    /**
     * 获取Access token
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Basic_Information/Get_access_token.html">https://developers.weixin.qq.com/doc/offiaccount/Basic_Information/Get_access_token.html</a>
     * <pre>
     * https请求方式: GET https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
     * </pre>
     */
    String TOKEN = BASE_PATH + "/token";

    // ----------------获取微信服务器 IP 地址接口-------------------
    /**
     * <p>
     * 获取微信 API 接口 IP地址
     * </p>
     * <p>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Basic_Information/Get_the_WeChat_server_IP_address.html">https://developers.weixin.qq.com/doc/offiaccount/Basic_Information/Get_the_WeChat_server_IP_address.html</a> <br>
     * http请求方式: GET https://api.weixin.qq.com/cgi-bin/get_api_domain_ip?access_token=ACCESS_TOKEN
     * </p>
     */
    String GET_API_DOMAIN_IP = BASE_PATH + "/get_api_domain_ip";

    /**
     * <p>
     * 获取微信callback IP地址
     * </p>
     * <p>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Basic_Information/Get_the_WeChat_server_IP_address.html">https://developers.weixin.qq.com/doc/offiaccount/Basic_Information/Get_the_WeChat_server_IP_address.html</a> <br>
     * http请求方式: GET https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=ACCESS_TOKEN
     * </p>
     */
    String GET_CALLBACK_IP = BASE_PATH + "/getcallbackip";

    /**
     * <p>
     * 网络检测
     * </p>
     * <p>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Basic_Information/Network_Detection.html">https://developers.weixin.qq.com/doc/offiaccount/Basic_Information/Network_Detection.html</a> <br>
     * HTTP Post请求： https://api.weixin.qq.com/cgi-bin/callback/check?access_token=ACCESS_TOKEN
     * </p>
     */
    String CALLBACK_CHECK = BASE_PATH + "/callback/check";

    /**
     * <p>
     * 清空 api 的调用quota<br>
     * 1. 本接口用于清空公众号/小程序/第三方平台等接口的每日调用接口次数。<br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/openApi/clear_quota.html">https://developers.weixin.qq.com/doc/offiaccount/openApi/clear_quota.html</a> <br>
     * HTTP POST请求： https://api.weixin.qq.com/cgi-bin/clear_quota?access_token=ACCESS_TOKEN
     * </p>
     */
    String CLEAR_QUOTA = BASE_PATH + "/clear_quota";

    /**
     * <p>
     * 清空 api 的调用quota<br>
     * 1. 本接口用于查询公众号/小程序/第三方平台等接口的每日调用接口的额度以及调用次数。<br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/openApi/get_api_quota.html">https://developers.weixin.qq.com/doc/offiaccount/openApi/get_api_quota.html</a> <br>
     * HTTP POST请求： https://api.weixin.qq.com/cgi-bin/openapi/quota/get?access_token=ACCESS_TOKEN
     * </p>
     */
    String OPENAPI_QUOTA_GET = BASE_PATH + "/openapi/quota/get";

    /**
     * <p>
     * 查询 rid 信息<br>
     * 本接口用于查询调用公众号/小程序/第三方平台等接口报错返回的 rid 详情信息，辅助开发者高效定位问题。<br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/openApi/get_rid_info.html">https://developers.weixin.qq.com/doc/offiaccount/openApi/get_rid_info.html</a> <br>
     * HTTP POST请求： https://api.weixin.qq.com/cgi-bin/openapi/rid/get?access_token=ACCESS_TOKEN
     * </p>
     */
    String OPENAPI_RID_GET = BASE_PATH + "/openapi/rid/get";

    /**
     * <p>
     * 创建接口<br>
     * 自定义菜单能够帮助公众号丰富界面，让用户更好更快地理解公众号的功能。<br>
     * 请注意：<br>
     * 1. 自定义菜单最多包括3个一级菜单，每个一级菜单最多包含5个二级菜单。<br>
     * 2. 一级菜单最多4个汉字，二级菜单最多8个汉字，多出来的部分将会以“...”代替。<br>
     * 3. 创建自定义菜单后，菜单的刷新策略是，在用户进入公众号会话页或公众号 profile 页时，如果发现上一次拉取菜单的请求在5分钟以前，就会拉取一下菜单，如果菜单有更新，就会刷新客户端的菜单。测试时可以尝试取消关注公众账号后再次关注，则可以看到创建后的效果。<br>
     * </p>
     *
     * <p>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Custom_Menus/Creating_Custom-Defined_Menu.html">https://developers.weixin.qq.com/doc/offiaccount/Custom_Menus/Creating_Custom-Defined_Menu.html</a> <br>
     * HTTP POST请求: https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN
     * </p>
     */
    String MENU_CREATE = BASE_PATH + "/menu/create";

    /**
     * <p>
     * 查询接口<br>
     * 使用接口创建自定义菜单后，开发者还可使用接口查询自定义菜单的结构。另外请注意，在设置了个性化菜单后，使用本自定义菜单查询接口可以获取默认菜单和全部个性化菜单信息。
     * </p>
     * <p>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Custom_Menus/Getting_Custom_Menu_Configurations.html">https://developers.weixin.qq.com/doc/offiaccount/Custom_Menus/Getting_Custom_Menu_Configurations.html</a><br>
     * HTTP GET请求: https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN
     * </p>
     */
    String MENU_GET = BASE_PATH + "/menu/get";

    /**
     * <p>
     * 查询自定义菜单的配置接口<br>
     * 本接口将会提供公众号当前使用的自定义菜单的配置，如果公众号是通过 API 调用设置的菜单，则返回菜单的开发配置，而如果公众号是在公众平台官网通过网站功能发布菜单，则本接口返回运营者设置的菜单配置。
     * </p>
     * <p>
     * 请注意：
     * 1. 第三方平台开发者可以通过本接口，在旗下公众号将业务授权给你后，立即通过本接口检测公众号的自定义菜单配置，并通过接口再次给公众号设置好自动回复规则，以提升公众号运营者的业务体验。
     * 2. 本接口与自定义菜单查询接口的不同之处在于，本接口无论公众号的接口是如何设置的，都能查询到接口，而自定义菜单查询接口则仅能查询到使用 API 设置的菜单配置。
     * 3. 认证/未认证的服务号/订阅号，以及接口测试号，均拥有该接口权限。
     * 4. 从第三方平台的公众号登录授权机制上来说，该接口从属于消息与菜单权限集。
     * 5. 本接口中返回的图片/语音/视频为临时素材（临时素材每次获取都不同，3天内有效，通过素材管理 - 获取临时素材接口来获取这些素材），本接口返回的图文消息为永久素材素材（通过素材管理 - 获取永久素材接口来获取这些素材）。
     * </p>
     * <p>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Custom_Menus/Querying_Custom_Menus.html">https://developers.weixin.qq.com/doc/offiaccount/Custom_Menus/Querying_Custom_Menus.html</a><br>
     * HTTP GET请求: https://api.weixin.qq.com/cgi-bin/get_current_selfmenu_info?access_token=ACCESS_TOKEN
     * </p>
     */
    String GET_CURRENT_SELFMENU_INFO = BASE_PATH + "/get_current_selfmenu_info";

    /**
     * <p>
     * 删除接口<br>
     * 使用接口创建自定义菜单后，开发者还可使用接口删除当前使用的自定义菜单。另请注意，在个性化菜单时，调用此接口会删除默认菜单及全部个性化菜单。
     * </p>
     * <p>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Custom_Menus/Deleting_Custom-Defined_Menu.html">https://developers.weixin.qq.com/doc/offiaccount/Custom_Menus/Deleting_Custom-Defined_Menu.html</a><br>
     * HTTP POST请求: https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN
     * </p>
     */
    String MENU_DELETE = BASE_PATH + "/menu/delete";

    /**
     * <p>
     * 创建个性化菜单<br>
     *
     * </p>
     * <p>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Custom_Menus/Personalized_menu_interface.html">https://developers.weixin.qq.com/doc/offiaccount/Custom_Menus/Personalized_menu_interface.html</a><br>
     * HTTP POST请求: https://api.weixin.qq.com/cgi-bin/menu/addconditional?access_token=ACCESS_TOKEN
     * </p>
     */
    String MENU_ADD_CONDITIONAL = BASE_PATH + "/menu/addconditional";

    /**
     * <p>
     * 删除个性化菜单<br>
     *
     * </p>
     * <p>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Custom_Menus/Personalized_menu_interface.html">https://developers.weixin.qq.com/doc/offiaccount/Custom_Menus/Personalized_menu_interface.html</a><br>
     * HTTP POST请求: https://api.weixin.qq.com/cgi-bin/menu/delconditional?access_token=ACCESS_TOKEN
     * </p>
     */
    String MENU_DEL_CONDITIONAL = BASE_PATH + "/menu/delconditional";

    /**
     * <p>
     * 测试个性化菜单匹配结果<br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Custom_Menus/Personalized_menu_interface.html">https://developers.weixin.qq.com/doc/offiaccount/Custom_Menus/Personalized_menu_interface.html</a><br>
     * HTTP POST请求: https://api.weixin.qq.com/cgi-bin/menu/trymatch?access_token=ACCESS_TOKEN
     * </p>
     */
    String MENU_TRY_MATCH = BASE_PATH + "/menu/trymatch";

    /**
     * <p>
     * 模板消息-设置所属行业<br>
     * 设置行业可在微信公众平台后台完成，每月可修改行业1次，帐号仅可使用所属行业中相关的模板，为方便第三方开发者，提供通过接口调用的方式来修改账号所属行业。
     * </p>
     * <p>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Template_Message_Interface.html">https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Template_Message_Interface.html</a><br>
     * HTTP POST请求: https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=ACCESS_TOKEN
     * </p>
     */
    String TEMPLATE_API_SET_INDUSTRY = BASE_PATH + "/template/api_set_industry";

    /**
     * <p>
     * 模板消息-获取设置的行业信息<br>
     * 获取帐号设置的行业信息。可登录微信公众平台，在公众号后台中查看行业信息。为方便第三方开发者，提供通过接口调用的方式来获取帐号所设置的行业信息。
     * </p>
     * <p>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Template_Message_Interface.html">https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Template_Message_Interface.html</a><br>
     * HTTP GET请求: https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token=ACCESS_TOKEN
     * </p>
     */
    String TEMPLATE_GET_INDUSTRY = BASE_PATH + "/template/get_industry";

    /**
     * <p>
     * 模板消息-获得模板ID<br>
     * 从行业模板库选择模板到帐号后台，获得模板 ID 的过程可在微信公众平台后台完成。为方便第三方开发者，提供通过接口调用的方式来获取模板ID。
     * </p>
     * <p>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Template_Message_Interface.html">https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Template_Message_Interface.html</a><br>
     * HTTP POST请求: https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=ACCESS_TOKEN
     * </p>
     */
    String TEMPLATE_API_ADD_TEMPLATE = BASE_PATH + "/template/api_add_template";

    /**
     * <p>
     * 模板消息-获取模板列表<br>
     * 获取已添加至帐号下所有模板列表，可在微信公众平台后台中查看模板列表信息。为方便第三方开发者，提供通过接口调用的方式来获取帐号下所有模板信息。
     * </p>
     * <p>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Template_Message_Interface.html">https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Template_Message_Interface.html</a><br>
     * HTTP GET请求: https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token=ACCESS_TOKEN
     * </p>
     */
    String TEMPLATE_GET_ALL_PRIVATE_TEMPLATE = BASE_PATH + "/template/get_all_private_template";

    /**
     * <p>
     * 模板消息-删除模板<br>
     * 删除模板可在微信公众平台后台完成，为方便第三方开发者，提供通过接口调用的方式来删除某帐号下的模板。
     * </p>
     * <p>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Template_Message_Interface.html">https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Template_Message_Interface.html</a><br>
     * HTTP POST请求: https://api.weixin.qq.com/cgi-bin/template/del_private_template?access_token=ACCESS_TOKEN
     * </p>
     */
    String TEMPLATE_DEL_PRIVATE_TEMPLATE = BASE_PATH + "/template/del_private_template";

    /**
     * <p>
     * 模板消息-发送模板消息<br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Template_Message_Interface.html">https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Template_Message_Interface.html</a><br>
     * HTTP POST请求: https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN
     * </p>
     */
    String MESSAGE_TEMPLATE_SEND = BASE_PATH + "/message/template/send";
    /**
     * <p>
     * 获取公众号的自动回复规则<br>
     * 开发者可以通过该接口，获取公众号当前使用的自动回复规则，包括关注后自动回复、消息自动回复（60分钟内触发一次）、关键词自动回复。<br>
     * <p>
     * 请注意：<br>
     * 1、第三方平台开发者可以通过本接口，在旗下公众号将业务授权给你后，立即通过本接口检测公众号的自动回复配置。<br>
     * 2、本接口仅能获取公众号在公众平台官网的自动回复功能中设置的自动回复规则，若公众号自行开发实现自动回复，或通过第三方平台开发者来实现，则无法获取。<br>
     * 3、认证/未认证的服务号/订阅号，以及接口测试号，均拥有该接口权限。<br>
     * 4、从第三方平台的公众号登录授权机制上来说，该接口从属于消息与菜单权限集。<br>
     * 5、本接口中返回的图片/语音/视频为临时素材（临时素材每次获取都不同，3天内有效，通过素材管理 - 获取临时素材接口来获取这些素材），本接口返回的图文消息为永久素材素材（通过素材管理 - 获取永久素材接口来获取这些素材）。<br>
     * </p>
     * <p>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Getting_Rules_for_Auto_Replies.html">https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Getting_Rules_for_Auto_Replies.html</a><br>
     * HTTP GET请求: https://api.weixin.qq.com/cgi-bin/get_current_autoreply_info?access_token=ACCESS_TOKEN
     * </p>
     */
    String GET_CURRENT_AUTOREPLY_INFO = BASE_PATH + "/get_current_autoreply_info";

    /**
     * 公众号一次性订阅消息: 获取授权链接 模版(服务号权限) <br>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Message_Management/One-time_subscription_info.html">https://developers.weixin.qq.com/doc/offiaccount/Message_Management/One-time_subscription_info.html</a><br>
     * 变量:
     * <pre>
     * {0}: appId: 必填, 公众号的唯一标识
     * {1}: scene: 必填, 重定向后会带上 scene 参数，开发者可以填0-10000的整型值，用来标识订阅场景值
     * {2}: template_id: 必填, 订阅消息模板ID，登录公众平台后台，在接口权限列表处可查看订阅模板ID
     * {3}: redirect_url: 必填, 授权后重定向的回调地址，请使用 UrlEncode 对链接进行处理。 注：要求redirect_url的域名要跟登记的业务域名一致，且业务域名不能带路径。 业务域名需登录公众号，在设置 - 公众号设置 - 功能设置里面对业务域名设置
     * {4}: reserved: 否, 用于保持请求和回调的状态，授权请后原样带回给第三方。该参数可用于防止 csrf 攻击（跨站请求伪造攻击），建议第三方带上该参数，可设置为简单的随机数加 session 进行校验，开发者可以填写a-zA-Z0-9的参数值，最多128字节，要求做urlencode
     * </pre>
     */
    String MESSAGE_SUBSCRIBE_MSG_URL_PATTERN = MP_BASE_PATH + "/subscribemsg?action=get_confirm&appid={0}&scene={1}&template_id={2}&redirect_url={3}&reserved={4}#wechat_redirect";
    /**
     * 公众号一次性订阅消息: 发送订阅消息(服务号权限) <br>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Message_Management/One-time_subscription_info.html">https://developers.weixin.qq.com/doc/offiaccount/Message_Management/One-time_subscription_info.html</a> <br>
     * HTTP POST请求: https://api.weixin.qq.com/cgi-bin/message/template/subscribe?access_token=ACCESS_TOKEN
     */
    String MESSAGE_TEMPLATE_SUBSCRIBE = BASE_PATH + "/message/template/subscribe";
    /**
     * 素材管理: 新增临时素材<br>
     * <pre>
     * 公众号经常有需要用到一些临时性的多媒体素材的场景，例如在使用接口特别是发送消息时，对多媒体文件、多媒体消息的获取和调用等操作，是通过media_id来进行的。素材管理接口对所有认证的订阅号和服务号开放。通过本接口，公众号可以新增临时素材（即上传临时多媒体文件）。使用接口过程中有任何问题，可以前往微信开放社区 #公众号 专区发帖交流
     * 注意点：
     * 1、临时素材media_id是可复用的。
     * 2、媒体文件在微信后台保存时间为3天，即3天后media_id失效。
     * 3、上传临时素材的格式、大小限制与公众平台官网一致。
     * 图片（image）: 10M，支持PNG\JPEG\JPG\GIF格式
     * 语音（voice）：2M，播放长度不超过60s，支持AMR\MP3格式
     * 视频（video）：10MB，支持MP4格式
     * 缩略图（thumb）：64KB，支持 JPG 格式
     * 4、需使用 https 调用本接口。
     * </pre>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Asset_Management/New_temporary_materials.html">https://developers.weixin.qq.com/doc/offiaccount/Asset_Management/New_temporary_materials.html</a> <br>
     * HTTP POST/FORM请求: https https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE
     */
    String MEDIA_UPLOAD = BASE_PATH + "/media/upload";
    /**
     * 素材管理: 获取临时素材<br>
     * <pre>
     * 公众号可以使用本接口获取临时素材（即下载临时的多媒体文件）。
     * 本接口即为原“下载多媒体文件”接口。
     *
     *  正确情况下的返回 HTTP 头如下：
     * HTTP/1.1 200 OK
     * Connection: close
     * Content-Type: image/jpeg
     * Content-disposition: attachment; filename="MEDIA_ID.jpg"
     * Date: Sun, 06 Jan 2013 10:20:18 GMT
     * Cache-Control: no-cache, must-revalidate
     * Content-Length: 339721
     * curl -G "https://api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID"
     * 如果返回的是视频消息素材，则内容如下：
     * {
     *  "video_url":DOWN_URL
     * }
     * </pre>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Asset_Management/Get_temporary_materials.html">https://developers.weixin.qq.com/doc/offiaccount/Asset_Management/Get_temporary_materials.html</a><br>
     * HTTP GET请求: https://api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID
     */
    String MEDIA_GET = BASE_PATH + "/media/get";
    /**
     * 素材管理: 高清语音素材获取接口<br>
     * <pre>
     * 公众号可以使用本接口获取从 JSSDK 的uploadVoice接口上传的临时语音素材，格式为speex，16K采样率。该音频比上文的临时素材获取接口（格式为amr，8K采样率）更加清晰，适合用作语音识别等对音质要求较高的业务。
     * 返回说明:
     * 正确情况下的返回 HTTP 头如下：
     * HTTP/1.1 200 OK
     * Connection: close
     * Content-Type: voice/speex
     * Content-disposition: attachment; filename="MEDIA_ID.speex"
     * Date: Sun, 06 Jan 2016 10:20:18 GMT
     * Cache-Control: no-cache, must-revalidate
     * Content-Length: 339721
     * curl -G "https://api.weixin.qq.com/cgi-bin/media/get/jssdk?access_token=ACCESS_TOKEN&media_id=MEDIA_ID"
     *
     * 如果 speex 音频格式不符合业务需求，开发者可在获取后，再自行于本地对该语音素材进行转码。
     *
     * 转码请使用 speex 的官方解码库http://speex.org/downloads/ ，并结合微信的解码库（含示例代码：<a href="http://wximg.gtimg.com/shake_tv/mpwiki/declib.zip "speex解码库"" target="_blank">下载地址）
     * </pre>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Asset_Management/Get_temporary_materials.html">https://developers.weixin.qq.com/doc/offiaccount/Asset_Management/Get_temporary_materials.html</a><br>
     * HTTP GET请求: https://api.weixin.qq.com/cgi-bin/media/get/jssdk?access_token=ACCESS_TOKEN&media_id=MEDIA_ID
     */
    String MEDIA_GET_JS_SDK = BASE_PATH + "/media/get/jssdk";
    /**
     * 新增永久素材: 上传图文消息内的图片获取URL<br>
     * <pre>
     * 对于常用的素材，开发者可通过本接口上传到微信服务器，永久使用。新增的永久素材也可以在公众平台官网素材管理模块中查询管理。
     * 请注意：
     * 1、最近更新：永久图片素材新增后，将带有 URL 返回给开发者，开发者可以在腾讯系域名内使用（腾讯系域名外使用，图片将被屏蔽）。
     * 2、公众号的素材库保存总数量有上限：图文消息素材、图片素材上限为100000，其他类型为1000。
     * 3、素材的格式大小等要求与公众平台官网一致：
     * 图片（image）: 10M，支持bmp/png/jpeg/jpg/gif格式
     * 语音（voice）：2M，播放长度不超过60s，mp3/wma/wav/amr格式
     * 视频（video）：10MB，支持MP4格式
     * 缩略图（thumb）：64KB，支持 JPG 格式
     * 4、图文消息的具体内容中，微信后台将过滤外部的图片链接，图片 url 需通过"上传图文消息内的图片获取URL"接口上传图片获取。
     * 5、"上传图文消息内的图片获取URL"接口所上传的图片，不占用公众号的素材库中图片数量的100000个的限制，图片仅支持jpg/png格式，大小必须在1MB以下。
     * 6、图文消息支持正文中插入自己帐号和其他公众号已群发文章链接的能力。
     * </pre>
     * <pre>
     * 上传图文消息内的图片获取URL
     * 本接口所上传的图片不占用公众号的素材库中图片数量的100000个的限制。图片仅支持jpg/png格式，大小必须在1MB以下。
     * </pre>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Asset_Management/Adding_Permanent_Assets.html">https://developers.weixin.qq.com/doc/offiaccount/Asset_Management/Adding_Permanent_Assets.html</a><br>
     * HTTP POST/FORM请求: https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN
     */
    String MEDIA_UPLOAD_IMG = BASE_PATH + "/media/uploadimg";
    /**
     * 新增永久素材: 新增其他类型永久素材 <br>
     * <pre>
     * 通过 POST 表单来调用接口，表单 id 为media，包含需要上传的素材内容，有filename、filelength、content-type等信息。请注意：图片素材将进入公众平台官网素材管理模块中的默认分组。
     * 新增永久视频素材需特别注意:
     * 在上传视频素材时需要 POST 另一个表单，id为description，包含素材的描述信息，内容格式为JSON，格式如下：
     * {
     *     "title":VIDEO_TITLE,
     *     "introduction":INTRODUCTION
     * }
     * </pre>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Asset_Management/Adding_Permanent_Assets.html">https://developers.weixin.qq.com/doc/offiaccount/Asset_Management/Adding_Permanent_Assets.html</a><br>
     * HTTP POST/FORM请求: https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN&type=TYPE
     */
    String MATERIAL_ADD_MATERIAL = BASE_PATH + "/material/add_material";
    /**
     * 获取永久素材 <br>
     * <pre>
     * 在新增了永久素材后，开发者可以根据media_id通过本接口下载永久素材。公众号在公众平台官网素材管理模块中新建的永久素材，可通过"获取素材列表"获知素材的media_id。
     * 请注意：临时素材无法通过本接口获取
     * </pre>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Asset_Management/Getting_Permanent_Assets.html">https://developers.weixin.qq.com/doc/offiaccount/Asset_Management/Getting_Permanent_Assets.html</a><br>
     * HTTP POST请求: https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN
     */
    String MATERIAL_GET_MATERIAL = BASE_PATH + "/material/get_material";
    /**
     * 删除永久素材 <br>
     * <pre>
     * 在新增了永久素材后，开发者可以根据本接口来删除不再需要的永久素材，节省空间。
     * 请注意：
     * 1、请谨慎操作本接口，因为它可以删除公众号在公众平台官网素材管理模块中新建的图文消息、语音、视频等素材（但需要先通过获取素材列表来获知素材的media_id）
     * 2、临时素材无法通过本接口删除
     * 3、调用该接口需 https 协议
     * </pre>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Asset_Management/Deleting_Permanent_Assets.html">https://developers.weixin.qq.com/doc/offiaccount/Asset_Management/Deleting_Permanent_Assets.html</a><br>
     * HTTP POST请求: https://api.weixin.qq.com/cgi-bin/material/del_material?access_token=ACCESS_TOKEN
     */
    String MATERIAL_DEL_MATERIAL = BASE_PATH + "/material/del_material";
    /**
     * 获取素材总数 <br>
     * <pre>
     * 开发者可以根据本接口来获取永久素材的列表，需要时也可保存到本地。
     *
     * 请注意：
     * 1.永久素材的总数，也会计算公众平台官网素材管理中的素材
     * 2.图片和图文消息素材（包括单图文和多图文）的总数上限为100000，其他素材的总数上限为1000
     * 3.调用该接口需 https 协议
     * </pre>
     * <p>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Asset_Management/Get_the_total_of_all_materials.html">https://developers.weixin.qq.com/doc/offiaccount/Asset_Management/Get_the_total_of_all_materials.html</a><br>
     * HTTP GET请求: https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token=ACCESS_TOKEN
     */
    String MATERIAL_GET_MATERIAL_COUNT = BASE_PATH + "/material/get_materialcount";
    /**
     * 获取素材列表 <br>
     * <pre>
     * 在新增了永久素材后，开发者可以分类型获取永久素材的列表。
     * 请注意：
     * 1、获取永久素材的列表，也包含公众号在公众平台官网素材管理模块中新建的图文消息、语音、视频等素材
     * 2、临时素材无法通过本接口获取
     * 3、调用该接口需 https 协议
     * </pre>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Asset_Management/Get_materials_list.html">https://developers.weixin.qq.com/doc/offiaccount/Asset_Management/Get_materials_list.html</a><br>
     * HTTP POST请求: https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN
     */
    String MATERIAL_BATCH_GET_MATERIAL = BASE_PATH + "/material/batchget_material";

    /**
     * 订阅通知接口-addTemplate选用模板 <br>
     * 从公共模板库中选用模板，到私有模板库中  <br>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Subscription_Messages/api.html">https://developers.weixin.qq.com/doc/offiaccount/Subscription_Messages/api.html</a> <br>
     * HTTP POST 请求: https://api.weixin.qq.com/wxaapi/newtmpl/addtemplate?access_token=ACCESS_TOKEN
     */
    String NEW_TMPL_ADD_TEMPLATE = WX_API_BASE_PATH + "/newtmpl/addtemplate";

    /**
     * 订阅通知接口-deleteTemplate删除模板 <br>
     * 删除私有模板库中的模板 <br>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Subscription_Messages/api.html">https://developers.weixin.qq.com/doc/offiaccount/Subscription_Messages/api.html</a> <br>
     * HTTP POST 请求: https://api.weixin.qq.com/wxaapi/newtmpl/addtemplate?access_token=ACCESS_TOKEN
     */
    String NEW_TMPL_DEL_TEMPLATE = WX_API_BASE_PATH + "/newtmpl/deltemplate";

    /**
     * 订阅通知接口-getCategory获取公众号类目 <br>
     * 获取公众号所属类目，可用于查询类目下的公共模板 <br>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Subscription_Messages/api.html">https://developers.weixin.qq.com/doc/offiaccount/Subscription_Messages/api.html</a> <br>
     * HTTP POST 请求: https://api.weixin.qq.com/wxaapi/newtmpl/addtemplate?access_token=ACCESS_TOKEN
     */
    String NEW_TMPL_GET_CATEGORY = WX_API_BASE_PATH + "/newtmpl/getcategory";

    /**
     * 订阅通知接口-getPubTemplateKeyWordsById获取模板中的关键词 <br>
     * 获取公共模板下的关键词列表 <br>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Subscription_Messages/api.html">https://developers.weixin.qq.com/doc/offiaccount/Subscription_Messages/api.html</a> <br>
     * HTTP POST 请求: https://api.weixin.qq.com/wxaapi/newtmpl/addtemplate?access_token=ACCESS_TOKEN
     */
    String NEW_TMPL_GET_PUB_TEMPLATE_KEYWORDS = WX_API_BASE_PATH + "/newtmpl/getpubtemplatekeywords";

    /**
     * 订阅通知接口-getPubTemplateTitleList获取类目下的公共模板 <br>
     * 获取类目下的公共模板，可从中选用模板使用 <br>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Subscription_Messages/api.html">https://developers.weixin.qq.com/doc/offiaccount/Subscription_Messages/api.html</a> <br>
     * HTTP POST 请求: https://api.weixin.qq.com/wxaapi/newtmpl/addtemplate?access_token=ACCESS_TOKEN
     */
    String NEW_TMPL_GET_PUB_TEMPLATE_TITLES = WX_API_BASE_PATH + "/newtmpl/getpubtemplatetitles";

    /**
     * 订阅通知接口-getTemplateList获取私有模板列表 <br>
     * 获取私有的模板列表 <br>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Subscription_Messages/api.html">https://developers.weixin.qq.com/doc/offiaccount/Subscription_Messages/api.html</a> <br>
     * HTTP POST 请求: https://api.weixin.qq.com/wxaapi/newtmpl/addtemplate?access_token=ACCESS_TOKEN
     */
    String NEW_TMPL_GET_TEMPLATE = WX_API_BASE_PATH + "/newtmpl/gettemplate";

    /**
     * 订阅通知接口-send发送订阅通知 <br>
     * 发送订阅通知 <br>
     * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Subscription_Messages/api.html">https://developers.weixin.qq.com/doc/offiaccount/Subscription_Messages/api.html</a> <br>
     * HTTP POST 请求: https://api.weixin.qq.com/wxaapi/newtmpl/addtemplate?access_token=ACCESS_TOKEN
     */
    String MESSAGE_SUBSCRIBE_BIZ_SEND = BASE_PATH + "/message/subscribe/bizsend";

    /**
     * 公众号一次性订阅消息: 获取授权链接
     *
     * @param appId       公众号的唯一标识
     * @param scene       重定向后会带上 scene 参数，开发者可以填0-10000的整型值，用来标识订阅场景值
     * @param templateId  订阅消息模板ID，登录公众平台后台，在接口权限列表处可查看订阅模板ID
     * @param redirectUrl 授权后重定向的回调地址，请使用 UrlEncode 对链接进行处理。 注：要求redirect_url的域名要跟登记的业务域名一致，且业务域名不能带路径。 业务域名需登录公众号，在设置 - 公众号设置 - 功能设置里面对业务域名设置
     * @param reserved    用于保持请求和回调的状态，授权请后原样带回给第三方。该参数可用于防止 csrf 攻击（跨站请求伪造攻击），建议第三方带上该参数，可设置为简单的随机数加 session 进行校验，开发者可以填写a-zA-Z0-9的参数值，最多128字节，要求做urlencode
     * @return 授权链接
     */
    static String messageSubscribeMsgUrl(String appId, String scene, String templateId, String redirectUrl, String reserved) {
        redirectUrl = UrlUtil.encode(redirectUrl);
        reserved = UrlUtil.encode(reserved);
        return MessageFormat.format(MESSAGE_SUBSCRIBE_MSG_URL_PATTERN, appId, scene, templateId, redirectUrl, reserved);
    }

}
