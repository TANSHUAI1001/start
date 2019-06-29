package com.tan.start.controller;

import com.tan.start.config.shiro.ShiroRealm;
import com.tan.start.entity.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.session.StoppedSessionException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.servlet.ShiroHttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

//import com.tan.start.annotation.Thinking;

@Controller
@RequestMapping(value="/")
public class HomeController {

    private Logger logger = LoggerFactory.getLogger(HomeController.class);
    @Resource
    private ShiroRealm realm;

    @RequestMapping(value="/index")
    public ModelAndView index(ModelAndView modelAndView,HttpServletRequest request) {
        ShiroHttpSession session = (ShiroHttpSession) request.getSession();
        Long last = session.getLastAccessedTime();
        logger.info("{} last access time: {}",session.getId(),new Date(last));
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        logger.info("principal={}",user);
        modelAndView.setViewName("index");
        modelAndView.addObject("user",user.getUsername());
        return modelAndView;
    }

    @RequestMapping(value="/test")
    @RequiresPermissions("queryall")
    public String test(HttpServletRequest request,HttpServletResponse response) {
        logger.debug("test  format arg {}", "100");
        return "sub/test";
    }

    @RequestMapping(value="/login",method=RequestMethod.GET)
    public ModelAndView loginPage(ModelAndView modelAndView) {
        modelAndView.getModel().put("error",null);
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value="/register",method=RequestMethod.GET)
    public String registerPage() {
        return "register";
    }

    @RequestMapping(value="/login",method=RequestMethod.POST)
    public ModelAndView login(String username,String password,boolean remembered ,ModelAndView modelAndView,HttpServletRequest request) {
        UsernamePasswordToken token = new UsernamePasswordToken(username.trim(), password.trim(),remembered);
        Subject subject = SecurityUtils.getSubject();
        if (subject != null){
            try{
                subject.logout();
                subject.login(token);
            }catch (Exception e){
                modelAndView.getModel().put("error",e.getMessage());
                modelAndView.setViewName("login");
                return modelAndView;
            }

        }
        modelAndView.setViewName("redirect:index");
        return modelAndView;

    }

    @RequestMapping(value = "/logout",method = {RequestMethod.GET,RequestMethod.POST})
    public String logout(HttpServletRequest request){
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
            realm.clearCache();
        }catch (IllegalStateException ise){
            logger.debug(ise.getMessage());
        }
        return "redirect:login";
    }
}
