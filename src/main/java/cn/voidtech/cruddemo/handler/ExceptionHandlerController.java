package cn.voidtech.cruddemo.handler;

import cn.voidtech.cruddemo.domain.REnum;
import cn.voidtech.cruddemo.utils.RUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author RowLingKaslana
 * @project CRUDDemo
 * @date 2024/10/15 18:08
 * This is the honor of the Kaslana!!!!
 * 願 人 類 榮 耀 長 存
 * 人 类 に 栄 光 あ れ
 * Glory to mankind！
 */
@Slf4j
@RestControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(BindException.class)
    public RUtil<?> bindExceptionHandler(BindException e) {
        String msg = e.getBindingResult().getFieldErrors()
                .stream()
                .map(n -> String.format("%s: %s", n.getField(), n.getDefaultMessage()))
                .reduce((x, y) -> String.format("%s; %s", x, y))
                .orElse("参数输入有误");
        log.error("BindException异常，参数校验异常：{}", msg);
        return RUtil.builder().code(REnum.PARAM_ERROR.getCode()).msg(msg).build();
    }

    @ExceptionHandler(RuntimeException.class)
    public RUtil<?> runtimeExceptionHandler(RuntimeException e) {
        log.error("业务异常");
        return RUtil.fail(e.getMessage());
    }
}
