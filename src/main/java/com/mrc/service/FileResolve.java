package com.mrc.service;

import com.mrc.exception.MissMiddlewareDataSourceJarException;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017-06-25.
 */
@Service
public class FileResolve {
    public void resolve(StringBuffer stringBuffer)  throws Exception {
        if(stringBuffer.indexOf("程序没有用定位到当前中间件数据源插件com.ygsoft.gap.middleware") > -1 ){
            System.out.println("middle......");
            throw new MissMiddlewareDataSourceJarException(101,"缺少服务包com.ygsoft.gap.middleware.weblogic.datasource.jar，请确认是否拷贝了三方包");
        }
    }
}
