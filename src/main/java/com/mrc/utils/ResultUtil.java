package com.mrc.utils;

import com.mrc.domain.Result;

/**
 * Created by Administrator on 2017-06-18.
 */
public class ResultUtil {
    public static Result success(Object  object){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }
    public static  Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return  result;
    }
}
