package cn.voidtech.cruddemo.utils;

import cn.voidtech.cruddemo.domain.REnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author RowLingKaslana
 * @project CRUDDemo
 * @date 2024/10/15 17:26
 * This is the honor of the Kaslana!!!!
 * 願 人 類 榮 耀 長 存
 * 人 类 に 栄 光 あ れ
 * Glory to mankind！
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RUtil<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;

    public RUtil(REnum rEnum) {
        this.code = rEnum.getCode();
        this.msg = rEnum.getMsg();
    }

    public RUtil(REnum rEnum, T data) {
        this.code = rEnum.getCode();
        this.msg = rEnum.getMsg();
        this.data = data;
    }

    public static RUtil<Object> ok() {
        return RUtil.builder().code(REnum.SUCCESS.getCode()).msg(REnum.SUCCESS.getMsg()).build();
    }

    public static <T> RUtil<Object> ok(T data) {
        return RUtil.builder().code(REnum.SUCCESS.getCode()).msg(REnum.SUCCESS.getMsg()).data(data).build();
    }

    public static RUtil<Object> fail() {
        return RUtil.builder().code(REnum.FAIL.getCode()).msg(REnum.FAIL.getMsg()).build();
    }

    public static RUtil<Object> fail(String msg) {
        return RUtil.builder().code(REnum.FAIL.getCode()).msg(msg).build();
    }
}
