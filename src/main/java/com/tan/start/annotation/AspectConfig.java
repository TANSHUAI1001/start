package com.tan.start.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectConfig {

	@Pointcut("@annotation(Thinking)")
    public void method(){
    }
	
	@Before("method()")
    public void before(JoinPoint joinPoint){
		Object []arr = joinPoint.getArgs();
        System.out.println("before thinking"+arr);
    }
	
}
