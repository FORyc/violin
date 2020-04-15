package com.blogs.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.api.CommonResult;
import top.exception.BusinessException;

/**
 * @author liu
 *  全局全局异常处理类
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public <T> CommonResult<T> handle(Exception e){
        if(e instanceof BusinessException){
            BusinessException businessException = (BusinessException) e;
            return CommonResult.error(businessException.getErrorCode(), businessException.getErrorMessage());
        }
        return CommonResult.error(e.getMessage());
    }
}
