package com.blogs.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public <T> CommonResult<T> handle(Exception e){
        if(e instanceof BusinessException){
            log.warn("程序出现异常", e);
            BusinessException businessException = (BusinessException) e;
            return CommonResult.error(businessException.getErrorCode(), businessException.getErrorMessage());
        }
        log.warn("程序出现异常", e);
        return CommonResult.error(e.getMessage());
    }
}
