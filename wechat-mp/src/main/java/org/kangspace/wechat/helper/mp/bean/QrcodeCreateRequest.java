package org.kangspace.wechat.helper.mp.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.kangspace.wechat.helper.mp.constant.QrcodeActionName;

/**
 * 账号管理-生成带参数的二维码 请求参数
 *
 * @author kango2gler@gmail.com
 * @since 2023/5/25
 */
@NoArgsConstructor
@Data
public class QrcodeCreateRequest {
    /**
     * 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果不填，则默认有效期为60秒。
     */
    @JsonProperty("expire_seconds")
    private Long expireSeconds;
    /**
     * 二维码类型，QR_SCENE为临时的整型参数值，QR_STR_SCENE为临时的字符串参数值，QR_LIMIT_SCENE为永久的整型参数值，QR_LIMIT_STR_SCENE为永久的字符串参数值
     */
    @JsonProperty("action_name")
    private QrcodeActionName actionName;
    /**
     * 二维码详细信息
     */
    @JsonProperty("action_info")
    private ActionInfo actionInfo;


    /**
     * 二维码详细信息
     */
    @Data
    public static class ActionInfo {
        public Scene scene;

        public ActionInfo(Scene scene) {
            this.scene = scene;
        }
    }

    /**
     * 场景值
     */
    @Data
    public static class Scene {
        /**
         * 场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
         */
        @JsonProperty("scene_id")
        private Integer sceneId;
        /**
         * 场景值ID（字符串形式的ID），字符串类型，长度限制为1到64
         */
        @JsonProperty("scene_str")
        private String sceneStr;

        public Scene(Integer sceneId) {
            this.sceneId = sceneId;
        }

        public Scene(String sceneStr) {
            this.sceneStr = sceneStr;
        }
    }

    public QrcodeCreateRequest(Long expireSeconds, QrcodeActionName actionName, ActionInfo actionInfo) {
        this.expireSeconds = expireSeconds;
        this.actionName = actionName;
        this.actionInfo = actionInfo;
    }
}
