package org.kangspace.wechat.helper.work.message.push;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.annotation.Nonnull;

/**
 * 企业微信推送消息 <br>
 * 接口文档: <a href="https://developer.work.weixin.qq.com/document/path/90236">https://developer.work.weixin.qq.com/document/path/90236</a><br>
 * id转译说明 <br>
 * 1.支持的消息类型和对应的字段 <br>
 * <p>
 * 消息类型	支持字段 <br>
 * 文本（text）	content <br>
 * 文本卡片（textcard）	title、description <br>
 * 图文（news）	title、description <br>
 * 图文（mpnews）	title、digest、content <br>
 * 小程序通知（miniprogram_notice）	title、description、content_item.value <br>
 * 模版消息（template_msg）	value <br>
 * 模板卡片消息（template_card）	source.desc、main_title.title、main_title.desc、sub_title_text、horizontal_content_list.value <br>
 * <p>
 * 2. id转译模版语法 <br>
 * $departmentName=DEPARTMENT_ID$  <br>
 * $userName=USERID$ <br>
 * $userAlias=USERID$ <br>
 * $userAliasOrName=USERID$ <br>
 * 其中 DEPARTMENT_ID 是数字类型的部门id，USERID 是成员帐号。 <br>
 * 譬如， <br>
 * 将$departmentName=1$替换成部门id为1对应的部门名，如“企业微信部”； <br>
 * 将$userName=lisi007$替换成userid为lisi007对应的用户姓名，如“李四”； <br>
 * 将$userAlias=lisi007$替换成userid为lisi007对应的用户别名，如“lisi”； <br>
 * 将$userAliasOrName=lisi007$替换成userid为lisi007对应的用户别名或姓名，别名优先级高于姓名，如"lisi"； <br>
 * <p>
 * 若输入的模板不符合语法、不在权限范围内或无效的userid或者部门ID，则不替换该项内容，保留原样 <br>
 * 转译userAlias时，如果用户没有别名，则不替换该项内容，保留原样 <br>
 * 转译userAliasOrName时，如果用户有别名，则替换为别名；否则，将替换为姓名 <br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/2
 */
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
public abstract class WeComPushMessage {
    /**
     * 指定接收消息的成员，成员ID列表（多个接收者用‘|’分隔，最多支持1000个）。<br>
     * 特殊情况：指定为"@all"，则向该企业应用的全部成员发送<br>
     */
    @JsonProperty("touser")
    private String toUser;

    /**
     * 指定接收消息的部门，部门ID列表，多个接收者用‘|’分隔，最多支持100个。<br>
     * 当touser为"@all"时忽略本参数<br>
     */
    @JsonProperty("toparty")
    private String toParty;

    /**
     * 指定接收消息的标签，标签ID列表，多个接收者用‘|’分隔，最多支持100个。<br>
     * 当touser为"@all"时忽略本参数<br>
     */
    @JsonProperty("totag")
    private String toTag;

    /**
     * 企业应用的id，整型。企业内部开发，可在应用的设置页面查看；第三方服务商，可通过接口 获取企业授权信息 获取该参数值
     */
    @Nonnull
    @JsonProperty("agentid")
    private String agentId;

    /**
     * 表示是否是保密消息，0表示可对外分享，1表示不能分享且内容显示水印，默认为0
     */
    @JsonProperty("safe")
    private Integer safe;

    /**
     * 表示是否开启id转译，0表示否，1表示是，默认0。仅第三方应用需要用到，企业自建应用可以忽略。
     */
    @JsonProperty("enable_id_trans")
    private String enableIdTrans;

    /**
     * 表示是否开启重复消息检查，0表示否，1表示是，默认0
     */
    @JsonProperty("enable_duplicate_check")
    private String enableDuplicateCheck;

    /**
     * 表示是否重复消息检查的时间间隔，默认1800s，最大不超过4小时
     */
    @JsonProperty("duplicate_check_interval")
    private String duplicateCheckInterval;
}
