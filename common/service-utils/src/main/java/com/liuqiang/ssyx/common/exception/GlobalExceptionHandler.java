package com.liuqiang.ssyx.common.exception;

import com.liuqiang.ssyx.common.result.Result;
import com.liuqiang.ssyx.common.result.ResultCodeEnum;
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
     * 自定义异常处理方法
     * @param e
     * @return
     */
    @ExceptionHandler(SsyxException.class)
    @ResponseBody
    public Result error(SsyxException e){
        return Result.build(null, ResultCodeEnum.FAIL);
    }
}
