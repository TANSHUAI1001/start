package com.tan.start.aspect;

import com.tan.start.entity.SysResource;
import com.tan.start.entity.SysUser;
import com.tan.start.service.SysResourceService;
import com.tan.start.utils.GenerateTreeFromList;
import com.tan.start.utils.Menu;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Aspect
@Component
public class AspectConfig {
    Logger logger = LoggerFactory.getLogger(AspectConfig.class);
    @Resource
    private SysResourceService sysResourcesService;
    @Resource(name = "redisTemplate")
    private RedisTemplate<Object, Object> template;

//	@Pointcut("@annotation(com.tan.start.annotation.Thinking)")
    @Pointcut("execution(public org.springframework.web.servlet.ModelAndView com.tan.start.controller.*.*(..))")
    public void method(){
    }
	
//	@Before("method()")
    public void doBefore(JoinPoint joinPoint){

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if(attributes != null) {
            HttpServletRequest request = attributes.getRequest();

            //url
            logger.debug("url={}", request.getRequestURL());
            //method
            logger.debug("method={}", request.getMethod());
            //ip
            logger.debug("ip={}", request.getRemoteAddr());
            //类方法
            logger.debug("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
            //参数
            logger.debug("args={} ", joinPoint.getArgs());
        }
    }

//	@After("method()")
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
        ModelAndView result = (ModelAndView) proceedingJoinPoint.proceed();
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        result.addObject("user",user.getUsername());
        //支持多级菜单生成
        List<Menu>menus = (List<Menu>) template.opsForValue().get("menu:all");
        if(menus == null) {
            List<SysResource> resources = sysResourcesService.getMenu();
            menus = GenerateTreeFromList.generateTree(resources);
            template.opsForValue().set("menu:all", menus);
        }
        result.addObject("menus", menus);
        logger.debug("result: {}",result);
        return result;
    }

    @AfterThrowing(pointcut = "method()",throwing = "ex")
    public void doAfterThrowing(JoinPoint joinPoint,Exception ex){
        logger.error(ex.getMessage());
    }

//    @AfterReturning(pointcut = "method()",returning = "returnVal")
    public void doAfterReturning(Object returnVal){
        logger.debug("returnVal={}",returnVal);
    }
}
