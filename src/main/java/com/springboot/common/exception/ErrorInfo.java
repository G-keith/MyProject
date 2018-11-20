package com.springboot.common.exception;

import lombok.Data;

/**
 * @author keith
 * @date 2018-08-21
 */
@Data
public class ErrorInfo<T> {

    /**
     * 错误码
     */
    private Integer code;
    /**
     * 错误信息
     */
    private String message;
    /**
     * 地址
     */
    private String url;

    private T data;

}
