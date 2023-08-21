package com.liuqiang.ssyx.common.exception;

import com.liuqiang.ssyx.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: 全局异常处理类
 * @date 2023/8/21 1:12
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 全局异常处理方法
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();
        return Result.fail(null);
    }

    /**
     * 自定义异常处理方法
     * @param e
     * @return
     */
    @ExceptionHandler(SSyxException.class)
    @ResponseBody
    public Result error(SSyxException e){
        e.printStackTrace();
        return Result.fail(null);
    }
}
