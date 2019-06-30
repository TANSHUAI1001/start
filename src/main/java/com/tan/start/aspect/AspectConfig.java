package com.tan.start.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class AspectConfig {
    Logger logger = LoggerFactory.getLogger(AspectConfig.class);

//	@Pointcut("@annotation(com.tan.start.annotation.Thinking)")
    @Pointcut("execution(public * com.tan.start.controller.*.*(..))")
    public void method(){
    }
	
	@Before("method()")
    public void doBefore(JoinPoint joinPoint){

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        logger.debug("url={}",request.getRequestURL());
        //method
        logger.debug("method={}",request.getMethod());
        //ip
        logger.debug("ip={}",request.getRemoteAddr());
        //类方法
        logger.debug("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        logger.debug("args={} ",joinPoint.getArgs());
    }

	@After("method()")
    public void doAfter(){

    }

    /**
     * Around MUST has a return value
     * @param proceedingJoinPoint subclass of JoinPoint
     * @return
     * @throws Throwable
     */
    @Around("method()")
    public Object  doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result = proceedingJoinPoint.proceed();
        logger.debug("result: {}",result);
        return result;
    }

    @AfterThrowing(pointcut = "method()",throwing = "ex")
    public void doAfterThrowing(JoinPoint joinPoint,Exception ex){

    }

    @AfterReturning(pointcut = "method()",returning = "returnVal")
    public void doAfterReturning(Object returnVal){
        logger.debug("returnVal={}",returnVal);
    }
}
