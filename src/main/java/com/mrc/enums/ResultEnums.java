package com.mrc.enums;

/**
 * Created by Administrator on 2017-06-18.
 */
public enum ResultEnums {
    UNKNOW_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    PRIMARY(100,"上小学"),
    MIDDLE_SCHELLO(101,"上初中");
    private Integer code;
    private String msg;
    ResultEnums(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
