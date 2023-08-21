package com.liuqiang.ssyx.common.exception;

import com.liuqiang.ssyx.common.result.ResultCodeEnum;
import lombok.Data;

/**
 * @author liuqiang132
 * @version 1.0
 * @description: SSyx自定义异常处理类
 * @date 2023/8/21 1:12
 */

@Data
public class SSyxException extends RuntimeException {
    //异常状态码
    private Integer code;

    /**
     * 通过状态码和错误消息创建异常对象
     * @param message
     * @param code
     */
    public SSyxException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    /**
     * 接收枚举类型对象
     * @param resultCodeEnum
     */
    public SSyxException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "SSyxException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }
}
