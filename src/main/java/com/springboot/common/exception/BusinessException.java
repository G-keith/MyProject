package com.springboot.common.exception;

/**
 * @author keith
 * @date 2018-08-21
 */
public class BusinessException extends RuntimeException{

    public BusinessException(){}

    public BusinessException(String message){
        super(message);
    }
}
