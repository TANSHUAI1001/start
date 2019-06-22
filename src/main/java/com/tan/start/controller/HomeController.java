package com.tan.start.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tan.start.config.shiro.SimpleUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.servlet.ShiroHttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

//import com.tan.start.annotation.Thinking;
import com.tan.start.utils.ResponseResult;

import java.security.Principal;
import java.util.Date;

@Controller
@RequestMapping(value="/")
public class HomeController {
	
	private Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value="/index")
	public ModelAndView index(ModelAndView modelAndView,HttpServletRequest request) {
		ShiroHttpSession session = (ShiroHttpSession) request.getSession();
		Long last = session.getLastAccessedTime();
		logger.info("last access time: {}",new Date(last));
		SimpleUser  user = (SimpleUser) SecurityUtils.getSubject().getPrincipal();
		logger.info("principal={}",user);
		modelAndView.setViewName("index");
		modelAndView.addObject("user",user);
		modelAndView.addObject("name","shuai");
		return modelAndView;
	}
	
	@RequestMapping(value="/test")
	@RequiresPermissions("queryall")
	public String test(HttpServletRequest request,HttpServletResponse response) {
		logger.debug("test  format arg {}", "100");
		return "sub/test";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(String username,String password,HttpServletRequest request) {
		UsernamePasswordToken token = new UsernamePasswordToken(username.trim(), password.trim());
        Subject subject = SecurityUtils.getSubject();
        if (subject != null){
			subject.logout();
			subject.login(token);
		}
        return "redirect:index";
       
	}

	@RequestMapping(value = "/logout",method = {RequestMethod.GET,RequestMethod.POST})
	public String logout(){
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:login";
	}
}
