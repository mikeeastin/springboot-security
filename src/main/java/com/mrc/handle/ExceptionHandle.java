package com.mrc.handle;

import com.mrc.domain.Result;
import com.mrc.utils.ResultUtil;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017-06-18.
 */
@ControllerAdvice
public class ExceptionHandle {
    private final  static org.slf4j.Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof  GirlException){
            GirlException girlException = (GirlException) e;
            return  ResultUtil.error(girlException.getCode(),girlException.getMessage());
        }else{
            logger.error("系统异常{}",e);
            return ResultUtil.error(-1,"未知错误");
        }
    }
}
