package com.mrc.exception;

/**
 * Created by Administrator on 2017-06-25.
 */
public class MissMiddlewareDataSourceJarException extends  RuntimeException{
    private  int code;
    private String message;
    public MissMiddlewareDataSourceJarException(int code, String message){
        super(message);
        this.code = code;
    }
}
