package com.nineclock.common.exception;

import com.nineclock.common.entity.Result;
import com.nineclock.common.enums.ResponseEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 定义统一异常处理类
 */
@ControllerAdvice  //定义为统一异常处理类，mvc所有异常都会由这个类处理
@ResponseBody
@Slf4j
public class BasicExceptionHandler {

    /**
     * 捕获自定义异常
     * @return
     */
    @ExceptionHandler(NcException.class) // 指定捕获的异常类型
    public Result resolveException(NcException ncException){
        log.error("业务异常：", ncException);
        return Result.errorCodeMessage(ncException.getCode(), ncException.getMessage());
    }

    @ExceptionHandler(Exception.class) // 指定捕获的异常类型
    public Result resolveException(Exception e){
        log.error("系统发送异常：", e);
        return Result.errorCodeMessage(ResponseEnum.SERVER_ERROR.getCode(),
                ResponseEnum.SERVER_ERROR.getMessage());
    }
}
