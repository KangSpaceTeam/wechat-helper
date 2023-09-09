package org.kangspace.wechat.helper.work.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 通讯录回调通知-成员变更通知 <br>
 * 接口文档:
 * <a href="https://developer.work.weixin.qq.com/document/path/90970">https://developer.work.weixin.qq.com/document/path/90970</a> <br>
 * <a href="https://developer.work.weixin.qq.com/document/path/90971">https://developer.work.weixin.qq.com/document/path/90971</a> <br>
 * <a href="https://developer.work.weixin.qq.com/document/path/90972">https://developer.work.weixin.qq.com/document/path/90972</a> <br>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ChangeContactEvent extends WeComXmlEvent implements WeComChangeTypeEvent {
    public static final String EVENT = "change_contact";

    /**
     * 变更类型
     */
    @JacksonXmlCData
    @JacksonXmlProperty(localName = "ChangeType")
    private String changeType;

    /**
     * 成员UserID
     */
    @JacksonXmlCData
    @JacksonXmlProperty(localName = "UserID")
    private String userId;

    /**
     * 成员名称;代开发自建应用需要管理员授权才返回
     */
    @JacksonXmlCData
    @JacksonXmlProperty(localName = "Name")
    private String name;

    /**
     * 成员部门列表，仅返回该应用有查看权限的部门id
     */
    @JacksonXmlProperty(localName = "Department")
    @JacksonXmlCData
    private List<Long> department;

    /**
     * 主部门
     */
    @JacksonXmlProperty(localName = "MainDepartment")
    private Long mainDepartment;

    /**
     * 表示所在部门是否为部门负责人，0-否，1-是，顺序与Department字段的部门逐一对应。上游共享的应用不返回该字段
     */
    @JacksonXmlProperty(localName = "IsLeaderInDept")
    private Long isLeaderInDept;
    /**
     * 直属上级UserID，最多5个。代开发的自建应用和上游共享的应用不返回该字段
     */
    @JacksonXmlProperty(localName = "DirectLeader")
    @JacksonXmlCData
    private List<String> directLeader;
    /**
     * 手机号码，代开发自建应用需要管理员授权且成员oauth2授权获取；第三方仅通讯录应用可获取；对于非第三方创建的成员，第三方通讯录应用也不可获取；上游企业不可获取下游企业成员该字段
     */
    @JacksonXmlProperty(localName = "Mobile")
    @JacksonXmlCData
    private List<String> mobile;
    /**
     * 职位信息。长度为0~64个字节;代开发自建应用需要管理员授权才返回。上游共享的应用不返回该字段
     */
    @JacksonXmlProperty(localName = "Position")
    @JacksonXmlCData
    private String position;
    /**
     * 性别。0表示未定义，1表示男性，2表示女性。代开发自建应用需要管理员授权且成员oauth2授权获取；第三方仅通讯录应用可获取；对于非第三方创建的成员，第三方通讯录应用也不可获取；上游企业不可获取下游企业成员该字段。注：不可获取指返回值0
     */
    @JacksonXmlProperty(localName = "Gender")
    private Integer gender;
    /**
     * 邮箱，代开发自建应用需要管理员授权且成员oauth2授权获取；第三方仅通讯录应用可获取；对于非第三方创建的成员，第三方通讯录应用也不可获取；上游企业不可获取下游企业成员该字段
     */
    @JacksonXmlProperty(localName = "Email")
    @JacksonXmlCData
    private String email;
    /**
     * 企业邮箱，代开发自建应用需要管理员授权且成员oauth2授权获取；第三方仅通讯录应用可获取；对于非第三方创建的成员，第三方通讯录应用也不可获取；上游企业不可获取下游企业成员该字段
     */
    @JacksonXmlProperty(localName = "BizMail")
    @JacksonXmlCData
    private String bizMail;
    /**
     * 激活状态：1=已激活 2=已禁用 4=未激活 已激活代表已激活企业微信或已关注微信插件（原企业号）5=成员退出
     */
    @JacksonXmlProperty(localName = "Status")
    private Integer status;
    /**
     * 头像url。 注：如果要获取小图将url最后的”/0”改成”/100”即可。代开发自建应用需要管理员授权且成员oauth2授权获取；第三方仅通讯录应用可获取；对于非第三方创建的成员，第三方通讯录应用也不可获取；上游企业不可获取下游企业成员该字段
     */
    @JacksonXmlProperty(localName = "Avatar")
    @JacksonXmlCData
    private String avatar;
    /**
     * 成员别名。上游共享的应用不返回该字段
     */
    @JacksonXmlProperty(localName = "Alias")
    @JacksonXmlCData
    private String alias;
    /**
     * 座机;代开发自建应用需要管理员授权才返回。上游共享的应用不返回该字段
     */
    @JacksonXmlProperty(localName = "Telephone")
    @JacksonXmlCData
    private String telephone;
    /**
     * 地址。代开发自建应用需要管理员授权且成员oauth2授权获取；第三方仅通讯录应用可获取；对于非第三方创建的成员，第三方通讯录应用也不可获取；上游企业不可获取下游企业成员该字段
     */
    @JacksonXmlProperty(localName = "Address")
    @JacksonXmlCData
    private String address;

    /**
     * 扩展属性;代开发自建应用需要管理员授权才返回。上游共享的应用不返回该字段
     */
    @JacksonXmlElementWrapper(localName = "ExtAttr")
    @JacksonXmlProperty(localName = "Item")
    private List<ChangeContactExtAttrItem> extAttr;


    /**
     * 成员修改类型(name小写)
     */
    public enum ChangeType {
        /**
         * 新增成员事件
         */
        CREATE_USER,
        /**
         * 更新成员事件
         */
        UPDATE_USER,
        /**
         * 删除成员事件
         */
        DELETE_USER,
        /**
         * 创建部门事件
         */
        CREATE_PARTY,
        /**
         * 更新部门事件
         */
        UPDATE_PARTY,
        /**
         * 删除部门事件
         */
        DELETE_PARTY,
        /**
         * 标签成员变更事件
         */
        UPDATE_TAG,
        ;

        @Override
        public String toString() {
            return super.toString().toLowerCase();
        }

        @JsonValue
        public String getChangeType() {
            return toString();
        }

        @JsonCreator
        public ChangeType parse(String changeType) {
            return Arrays.stream(values()).filter(t -> Objects.equals(t.getChangeType(), changeType))
                    .findFirst().orElse(null);
        }
    }

}
