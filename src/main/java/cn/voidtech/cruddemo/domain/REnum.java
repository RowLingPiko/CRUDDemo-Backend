package cn.voidtech.cruddemo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author RowLingKaslana
 * @project CRUDDemo
 * @date 2024/10/15 17:29
 * This is the honor of the Kaslana!!!!
 * 願 人 類 榮 耀 長 存
 * 人 类 に 栄 光 あ れ
 * Glory to mankind！
 */
@Getter
@AllArgsConstructor
public enum REnum {
    SUCCESS(200, "操作成功"),
    FAIL(500, "操作失败"),
    NOT_FOUND(404, "未找到该资源"),
    PARAM_ERROR(400, "参数错误");

    private final Integer code;
    private final String msg;
}
