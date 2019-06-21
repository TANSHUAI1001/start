package com.tan.start.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class AspectConfig {
    Logger logger = LoggerFactory.getLogger(AspectConfig.class);

	@Pointcut("@annotation(com.tan.start.annotation.Thinking)")
//    @Pointcut("execution(public * com.tan.start.controller.*.*(..))")
    public void method(){
    }
	
	@Before("method()")
    public void doBefore(JoinPoint joinPoint){

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        logger.info("url={}",request.getRequestURL());
        //method
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        logger.info("args={} ",joinPoint.getArgs());
    }

	@After("method()")
    public void doAfter(){

    }

    @Around("method()")
    public void doAround(){

    }

    @AfterThrowing(pointcut = "method()",throwing = "ex")
    public void doAfterThrowing(Exception ex){

    }

    @AfterReturning(pointcut = "method()",returning = "object")
    public void doAfterReturning(Object object){
        logger.info("response={}",object);
    }
}
