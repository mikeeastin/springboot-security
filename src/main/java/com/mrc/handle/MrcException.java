package com.mrc.handle;

import com.mrc.enums.ResultEnums;

/**
 * Created by Administrator on 2017-06-18.
 */
public class MrcException extends  RuntimeException {
    private  Integer code;
    public MrcException(ResultEnums resultEnums){
        super(resultEnums.getMsg());
        this.code = resultEnums.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
