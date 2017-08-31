package com.mrc.aspect;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.aspectj.AbstractAspectJAdvice;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

import static java.lang.System.out;

/**
 * Created by Administrator on 2017-06-15.
 */
@Aspect
@Component
public class HttpAspect
{
    private  final  static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
    @Pointcut("execution(public * com.mrc.controller.FileUploadController.*(..))")
    public  void log(){

        //获取 url  方法  ip 
    }

    @Before("log()")
    public void logBefore(){
        ServletRequestAttributes  attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("url={}",request.getRequestURL());
        logger.info("method={}",request.getMethod());
        logger.info("ip={}",request.getRemoteAddr());
        logger.info("class_mathod={}", AbstractAspectJAdvice.currentJoinPoint().getSignature().getDeclaringTypeName());
        logger.info("args={}",AbstractAspectJAdvice.currentJoinPoint().getArgs());
    }

    @After("log()")
    public void logAfter(){
       // logger.info("2222222222after..");
    }


    @AfterReturning(returning = "object",pointcut = "log()")
    public void afterReturn(Object object){
      //  logger.info(object.toString());
    }

}
