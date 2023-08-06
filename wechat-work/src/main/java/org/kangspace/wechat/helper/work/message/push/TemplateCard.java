package org.kangspace.wechat.helper.work.message.push;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.kangspace.wechat.helper.work.message.MessageConstant;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * 模版卡片消息
 *
 * @author kango2gler@gmail.com
 * @since 2023/8/2
 */

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
public class TemplateCard {
    /**
     * 卡片来源样式信息，不需要来源样式可不填写
     */
    @JsonProperty("source")
    private Source source;

    /**
     * 一级标题
     */
    @JsonProperty("main_title")
    private MainTitle mainTitle;

    /**
     * 任务id，同一个应用任务id不能重复，只能由数字、字母和“_-@”组成，最长128字节，填了action_menu字段的话本字段必填
     */
    @JsonProperty("task_id")
    private String taskId;


    @NoArgsConstructor
    @SuperBuilder
    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class TextNotice extends TemplateCard {
        /**
         * 模板卡片类型，文本通知型卡片填写 "text_notice"
         */
        @Nonnull
        @JsonProperty("card_type")
        private final String cardType = MessageConstant.MessageCardType.TEXT_NOTICE.getType();

        /**
         * 二级普通文本，建议不超过160个字，（支持id转译）
         */
        @JsonProperty("sub_title_text")
        private String subTitleText;

        /**
         * 关键数据样式
         */
        @JsonProperty("emphasis_content")
        private EmphasisContent emphasisContent;

        /**
         * 卡片右上角更多操作按钮
         */
        @JsonProperty("action_menu")
        private ActionMenu actionMenu;

        /**
         * 引用文献样式
         */
        @JsonProperty("quote_area")
        private QuoteArea quoteArea;

        /**
         * 二级标题+文本列表，该字段可为空数组，但有数据的话需确认对应字段是否必填，列表长度不超过6
         */
        @JsonProperty("horizontal_content_list")
        private List<HorizontalContentList> horizontalContentList;
        /**
         * 跳转指引样式的列表，该字段可为空数组，但有数据的话需确认对应字段是否必填，列表长度不超过3
         */
        @JsonProperty("jump_list")
        private List<JumpList> jumpList;

        /**
         * 整体卡片的点击跳转事件，text_notice必填本字段
         */
        @Nonnull
        @JsonProperty("card_action")
        private CardAction cardAction;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @SuperBuilder
    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class NewsNotice extends TemplateCard {
        /**
         * 模板卡片类型，图文展示型卡片此处填写 "news_notice"
         */
        @Nonnull
        @JsonProperty("card_type")
        private final String cardType = MessageConstant.MessageCardType.NEWS_NOTICE.getType();

        /**
         * 卡片右上角更多操作按钮
         */
        @JsonProperty("action_menu")
        private ActionMenu actionMenu;

        /**
         * 引用文献样式
         */
        @JsonProperty("quote_area")
        private QuoteArea quoteArea;

        /**
         * 左图右文样式，news_notice类型的卡片，card_image和image_text_area两者必填一个字段，不可都不填
         */
        @JsonProperty("image_text_area")
        private ImageTextArea imageTextArea;

        /**
         * 图片样式，news_notice类型的卡片，card_image和image_text_area两者必填一个字段，不可都不填
         */
        @JsonProperty("card_image")
        private CardImage cardImage;

        /**
         * 卡片二级垂直内容，该字段可为空数组，但有数据的话需确认对应字段是否必填，列表长度不超过4
         */
        @JsonProperty("vertical_content_list")
        private List<VerticalContentList> verticalContentList;

        /**
         * 二级标题+文本列表，该字段可为空数组，但有数据的话需确认对应字段是否必填，列表长度不超过6
         */
        @JsonProperty("horizontal_content_list")
        private List<HorizontalContentList> horizontalContentList;
        /**
         * 跳转指引样式的列表，该字段可为空数组，但有数据的话需确认对应字段是否必填，列表长度不超过3
         */
        @JsonProperty("jump_list")
        private List<JumpList> jumpList;

        /**
         * 整体卡片的点击跳转事件，text_notice必填本字段
         */
        @Nonnull
        @JsonProperty("card_action")
        private CardAction cardAction;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @SuperBuilder
    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class ButtonInteraction extends TemplateCard {
        /**
         * 模板卡片类型，按钮交互型卡片此处填写 "button_interaction"
         */
        @Nonnull
        @JsonProperty("card_type")
        private final String cardType = MessageConstant.MessageCardType.BUTTON_INTERACTION.getType();

        /**
         * 二级普通文本，建议不超过160个字，（支持id转译）
         */
        @JsonProperty("sub_title_text")
        private String subTitleText;

        /**
         * 卡片右上角更多操作按钮
         */
        @JsonProperty("action_menu")
        private ActionMenu actionMenu;

        /**
         * 引用文献样式
         */
        @JsonProperty("quote_area")
        private QuoteArea quoteArea;

        /**
         * 下拉式的选择器
         */
        @JsonProperty("button_selection")
        private ButtonSelection buttonSelection;

        /**
         * 按钮列表，列表长度不超过6
         */
        @Nonnull
        @JsonProperty("button_list")
        private List<ButtonList> buttonList;

        /**
         * 二级标题+文本列表，该字段可为空数组，但有数据的话需确认对应字段是否必填，列表长度不超过6
         */
        @JsonProperty("horizontal_content_list")
        private List<HorizontalContentList> horizontalContentList;

        /**
         * 整体卡片的点击跳转事件，text_notice必填本字段
         */
        @Nonnull
        @JsonProperty("card_action")
        private CardAction cardAction;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @SuperBuilder
    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class VoteInteraction extends TemplateCard {
        /**
         * 模板卡片类型，投票选择型卡片此处填写 "vote_interaction"
         */
        @Nonnull
        @JsonProperty("card_type")
        private final String cardType = MessageConstant.MessageCardType.VOTE_INTERACTION.getType();

        /**
         * 选择题样式
         */
        @JsonProperty("checkbox")
        private CheckBox checkbox;

        /**
         * 提交按钮样式
         */
        @JsonProperty("submit_button")
        private SubmitButton submitButton;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @SuperBuilder
    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class MultipleInteraction extends TemplateCard {
        /**
         * 模板卡片类型，多项选择型卡片此处填写 "multiple_interaction"
         */
        @Nonnull
        @JsonProperty("card_type")
        private final String cardType = MessageConstant.MessageCardType.MULTIPLE_INTERACTION.getType();

        /**
         * 下拉式的选择器列表，multiple_interaction类型的卡片该字段不可为空，一个消息最多支持 3 个选择器
         */
        @Nonnull
        @JsonProperty("select_list")
        private List<SelectList> selectList;

        /**
         * 提交按钮样式
         */
        @JsonProperty("submit_button")
        private SubmitButton submitButton;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Data
    public static class CardAction {
        /**
         * 跳转事件类型，1 代表跳转url，2 代表打开小程序。text_notice卡片模版中该字段取值范围为[1,2]
         */
        @JsonProperty("type")
        private Integer type;
        /**
         * 跳转事件的url，card_action.type是1时必填
         */
        @JsonProperty("url")
        private String url;
        /**
         * 跳转事件的小程序的appid，必须是与当前应用关联的小程序，card_action.type是2时必填
         */
        @JsonProperty("appid")
        private String appId;
        /**
         * 跳转事件的小程序的pagepath，card_action.type是2时选填
         */
        @JsonProperty("pagepath")
        private String pagePath;

        public CardAction(Integer type, String url) {
            this.type = type;
            this.url = url;
        }

        public CardAction(Integer type, String appId, String pagePath) {
            this.type = type;
            this.appId = appId;
            this.pagePath = pagePath;
        }
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Data
    public static class JumpList {
        /**
         * 跳转链接类型，0或不填代表不是链接，1 代表跳转url，2 代表跳转小程序
         */
        @JsonProperty("type")
        private Integer type;
        /**
         * 跳转链接样式的文案内容，建议不超过18个字
         */
        @Nonnull
        @JsonProperty("title")
        private String title;
        /**
         * 跳转链接的url，jump_list.type是1时必填
         */
        @JsonProperty("url")
        private String url;
        /**
         * 跳转链接的小程序的appid，必须是与当前应用关联的小程序，jump_list.type是2时必填
         */
        @JsonProperty("appid")
        private String appId;
        /**
         * 跳转链接的小程序的pagepath，jump_list.type是2时选填
         */
        @JsonProperty("pagepath")
        private String pagePath;

        public JumpList(Integer type, @Nonnull String title, String url) {
            this.type = type;
            this.title = title;
            this.url = url;
        }

        public JumpList(Integer type, @Nonnull String title, String appId, String pagePath) {
            this.type = type;
            this.title = title;
            this.appId = appId;
            this.pagePath = pagePath;
        }
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Data
    public static class HorizontalContentList {
        /**
         * 链接类型，0或不填代表不是链接，1 代表跳转url，2 代表下载附件，3 代表点击跳转成员详情
         */
        @JsonProperty("type")
        private Integer type;
        /**
         * 二级标题，建议不超过5个字
         */
        @Nonnull
        @JsonProperty("keyname")
        private String keyName;
        /**
         * 二级文本，如果horizontal_content_list.type是2，该字段代表文件名称（要包含文件类型），建议不超过30个字，（支持id转译）
         */
        @JsonProperty("value")
        private String value;
        /**
         * 链接跳转的url，horizontal_content_list.type是1时必填
         */
        @JsonProperty("url")
        private String url;
        /**
         * 附件的media_id，horizontal_content_list.type是2时必填
         */
        @JsonProperty("media_id")
        private String mediaId;
        /**
         * 成员详情的userid，horizontal_content_list.type是3时必填
         */
        @JsonProperty("userid")
        private String userId;

        public HorizontalContentList(@Nonnull String keyName, String value) {
            this.keyName = keyName;
            this.value = value;
        }

        public HorizontalContentList(Integer type, @Nonnull String keyName, String value, String url) {
            this.type = type;
            this.keyName = keyName;
            this.value = value;
            this.url = url;
        }
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Data
    public static class QuoteArea {
        /**
         * 引用文献样式区域点击事件，0或不填代表没有点击事件，1 代表跳转url，2 代表跳转小程序
         */
        @JsonProperty("type")
        private Integer type;
        /**
         * 点击跳转的url，quote_area.type是1时必填
         */
        @JsonProperty("url")
        private String url;
        /**
         * 点击跳转的小程序的appid，必须是与当前应用关联的小程序，quote_area.type是2时必填
         */
        @JsonProperty("appid")
        private String appId;
        /**
         * 点击跳转的小程序的pagepath，quote_area.type是2时选填
         */
        @JsonProperty("pagepath")
        private String pagePath;
        /**
         * 引用文献样式的标题
         */
        @JsonProperty("title")
        private String title;
        /**
         * 引用文献样式的引用文案
         */
        @JsonProperty("quote_text")
        private String quoteText;

        public QuoteArea(Integer type, String url, String title, String quoteText) {
            this.type = type;
            this.url = url;
            this.title = title;
            this.quoteText = quoteText;
        }

        public QuoteArea(Integer type, String appId, String pagePath, String title, String quoteText) {
            this.type = type;
            this.appId = appId;
            this.pagePath = pagePath;
            this.title = title;
            this.quoteText = quoteText;
        }
    }

    @NoArgsConstructor
    @Builder
    @Data
    public static class EmphasisContent {
        /**
         * 关键数据样式的数据内容，建议不超过14个字
         */
        @JsonProperty("title")
        private String title;
        /**
         * 关键数据样式的数据描述内容，建议不超过22个字
         */
        @JsonProperty("desc")
        private String desc;

        public EmphasisContent(String title, String desc) {
            this.title = title;
            this.desc = desc;
        }
    }

    @NoArgsConstructor
    @Builder
    @Data
    public static class MainTitle {
        /**
         * 一级标题，建议不超过36个字，文本通知型卡片本字段非必填，但不可本字段和sub_title_text都不填，（支持id转译）
         */
        @JsonProperty("title")
        private String title;
        /**
         * 标题辅助信息，建议不超过44个字，（支持id转译）
         */
        @JsonProperty("desc")
        private String desc;

        public MainTitle(String title, String desc) {
            this.title = title;
            this.desc = desc;
        }
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Data
    public static class ActionMenu {
        /**
         * 更多操作界面的描述
         */
        @JsonProperty("desc")
        private String desc;
        /**
         * 操作列表，列表长度取值范围为 [1, 3]
         */
        @Nonnull
        @JsonProperty("action_list")
        private List<ActionList> actionList;
    }

    @NoArgsConstructor
    @Builder
    @Data
    public static class ActionList {
        /**
         * 操作的描述文案
         */
        @JsonProperty("text")
        private String text;
        /**
         * 操作key值，用户点击后，会产生回调事件将本参数作为EventKey返回，回调事件会带上该key值，最长支持1024字节，不可重复
         */
        @JsonProperty("key")
        private String key;

        public ActionList(String text, String key) {
            this.text = text;
            this.key = key;
        }
    }

    @NoArgsConstructor
    @Builder
    @Data
    public static class Source {

        /**
         * 来源图片的url，来源图片的尺寸建议为72*72
         */
        @JsonProperty("icon_url")
        private String iconUrl;
        /**
         * 来源图片的描述，建议不超过20个字，（支持id转译）
         */
        @JsonProperty("desc")
        private String desc;
        /**
         * 来源文字的颜色，目前支持：0(默认) 灰色，1 黑色，2 红色，3 绿色
         */
        @JsonProperty("desc_color")
        private Integer descColor;

        public Source(String iconUrl, String desc, Integer descColor) {
            this.iconUrl = iconUrl;
            this.desc = desc;
            this.descColor = descColor;
        }
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Data
    public static class SelectList {
        /**
         * 下拉式的选择器题目的key，用户提交选项后，会产生回调事件，回调事件会带上该key值表示该题，最长支持1024字节，不可重复
         */
        @JsonProperty("question_key")
        private String questionKey;
        /**
         * 下拉式的选择器上面的title
         */
        @JsonProperty("title")
        private String title;

        /**
         * 选项列表，下拉选项不超过 10 个，最少1个
         */
        @Nonnull
        @JsonProperty("option_list")
        private List<OptionList> optionList;
        /**
         * 默认选定的id，不填或错填默认第一个
         */
        @JsonProperty("selected_id")
        private String selectedId;
    }

    @NoArgsConstructor
    @Builder
    @Data
    public static class SubmitButton {
        /**
         * 按钮文案，建议不超过10个字，不填默认为提交
         */
        @Nonnull
        @JsonProperty("text")
        private String text;
        /**
         * 提交按钮的key，会产生回调事件将本参数作为EventKey返回，最长支持1024字节
         */
        @Nonnull
        @JsonProperty("key")
        private String key;

        public SubmitButton(@Nonnull String text, @Nonnull String key) {
            this.text = text;
            this.key = key;
        }
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Data
    public static class CheckBox {
        /**
         * 选择题key值，用户提交选项后，会产生回调事件，回调事件会带上该key值表示该题，最长支持1024字节
         */
        @JsonProperty("question_key")
        private String questionKey;

        /**
         * 选择题模式，单选：0，多选：1，不填默认0
         */
        @JsonProperty("mode")
        private Integer mode;

        /**
         * 选项list，选项个数不超过 20 个，最少1个
         */
        @Nonnull
        @JsonProperty("option_list")
        private List<CheckBoxOptionList> optionList;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Data
    public static class CheckBoxOptionList {
        /**
         * 选项id，用户提交选项后，会产生回调事件，回调事件会带上该id值表示该选项，最长支持128字节，不可重复
         */
        @Nonnull
        @JsonProperty("id")
        private String id;
        /**
         * 选项文案描述，建议不超过17个字
         */
        @Nonnull
        @JsonProperty("text")
        private String text;
        /**
         * 该选项是否要默认选中
         */
        @Nonnull
        @JsonProperty("is_checked")
        private Boolean isChecked;
    }

    @NoArgsConstructor
    @Builder
    @Data
    public static class ButtonList {
        /**
         * 按钮点击事件类型，0 或不填代表回调点击事件，1 代表跳转url
         */
        @JsonProperty("type")
        private Integer type;
        /**
         * 按钮文案，建议不超过10个字
         */
        @Nonnull
        @JsonProperty("text")
        private String text;
        /**
         * 按钮样式，目前可填1~4，不填或错填默认1
         */
        @JsonProperty("style")
        private Integer style;
        /**
         * 按钮key值，用户点击后，会产生回调事件将本参数作为EventKey返回，回调事件会带上该key值，最长支持1024字节，不可重复，button_list.type是0时必填
         */
        @JsonProperty("key")
        private String key;
        /**
         * 跳转事件的url，button_list.type是1时必填
         */
        @JsonProperty("url")
        private String url;

        public ButtonList(@Nonnull String text, String key) {
            this.text = text;
            this.key = key;
        }

        public ButtonList(@Nonnull String text, Integer style, String key) {
            this.text = text;
            this.style = style;
            this.key = key;
        }

        public ButtonList(Integer type, @Nonnull String text, Integer style, String key, String url) {
            this.type = type;
            this.text = text;
            this.style = style;
            this.key = key;
            this.url = url;
        }
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Data
    public static class ButtonSelection {
        /**
         * 下拉式的选择器的key，用户提交选项后，会产生回调事件，回调事件会带上该key值表示该题，最长支持1024字节
         */
        @Nonnull
        @JsonProperty("question_key")
        private String questionKey;

        /**
         * 下拉式的选择器左边的标题
         */
        @JsonProperty("title")
        private String title;

        /**
         * 选项列表，下拉选项不超过 10 个，最少1个
         */
        @Nonnull
        @JsonProperty("option_list")
        private List<OptionList> optionList;
        /**
         * 默认选定的id，不填或错填默认第一个
         */
        @JsonProperty("selected_id")
        private String selectedId;
    }

    @NoArgsConstructor
    @Builder
    @Data
    public static class OptionList {
        /**
         * 下拉式的选择器选项的id，用户提交后，会产生回调事件，回调事件会带上该id值表示该选项，最长支持128字节，不可重复
         */
        @Nonnull
        @JsonProperty("id")
        private String id;
        /**
         * 下拉式的选择器选项的文案，建议不超过16个字
         */
        @Nonnull
        @JsonProperty("text")
        private String text;

        public OptionList(@Nonnull String id, @Nonnull String text) {
            this.id = id;
            this.text = text;
        }
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Data
    public static class VerticalContentList {
        /**
         * 卡片二级标题，建议不超过38个字
         */
        @Nonnull
        @JsonProperty("title")
        private String title;
        /**
         * 二级普通文本，建议不超过160个字
         */
        @JsonProperty("desc")
        private String desc;
    }

    @NoArgsConstructor
    @Builder
    @Data
    public static class CardImage {
        /**
         * 图片的url
         */
        @Nonnull
        @JsonProperty("url")
        private String url;
        /**
         * 图片的宽高比，宽高比要小于2.25，大于1.3，不填该参数默认1.3
         */
        @JsonProperty("aspect_ratio")
        private Float aspectRatio;

        public CardImage(@Nonnull String url, Float aspectRatio) {
            this.url = url;
            this.aspectRatio = aspectRatio;
        }
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Data
    public static class ImageTextArea {
        /**
         * 左图右文样式区域点击事件，0或不填代表没有点击事件，1 代表跳转url，2 代表跳转小程序
         */
        @JsonProperty("type")
        private Integer type;
        /**
         * 点击跳转的url，image_text_area.type是1时必填
         */
        @JsonProperty("url")
        private String url;
        /**
         * 点击跳转的小程序的appid，必须是与当前应用关联的小程序，image_text_area.type是2时必填
         */
        @JsonProperty("appid")
        private String appId;
        /**
         * 点击跳转的小程序的pagepath，image_text_area.type是2时选填
         */
        @JsonProperty("pagepath")
        private String pagePath;
        /**
         * 左图右文样式的标题
         */
        @JsonProperty("title")
        private String title;
        /**
         * 左图右文样式的描述
         */
        @JsonProperty("desc")
        private String desc;
        /**
         * 左图右文样式的图片url
         */
        @JsonProperty("image_url")
        private String imageUrl;

        public ImageTextArea(Integer type, String url, String title, String desc, String imageUrl) {
            this.type = type;
            this.url = url;
            this.title = title;
            this.desc = desc;
            this.imageUrl = imageUrl;
        }

        public ImageTextArea(Integer type, String appId, String pagePath, String title, String desc, String imageUrl) {
            this.type = type;
            this.appId = appId;
            this.pagePath = pagePath;
            this.title = title;
            this.desc = desc;
            this.imageUrl = imageUrl;
        }
    }
}
