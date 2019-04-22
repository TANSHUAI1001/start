package com.tan.start.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

//import com.tan.start.annotation.Thinking;
import com.tan.start.utils.ResponseBo;

@Controller
@RequestMapping(value="/")
public class HomeController {
	
	private Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value="/index")
	public ModelAndView index(ModelAndView modelAndView) {
		modelAndView.setViewName("index");
		modelAndView.addObject("name","shuai");
		return modelAndView;
	}
	
	@RequestMapping(value="/test")
//	@Thinking
	public String test(HttpServletRequest request,HttpServletResponse response) {
		logger.debug("test  format arg {}", "100");
		return "sub/test";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(String username,String password) {
		UsernamePasswordToken token = new UsernamePasswordToken(username.trim(), password.trim());
        Subject subject = SecurityUtils.getSubject();
        if (subject != null)
            subject.logout();
        subject.login(token);
        return "redirect:index";
       
	}
	
//	@RequestMapping(value="/login",method=RequestMethod.POST)
//	@ResponseBody
//	public ResponseBo login(String username,String password) {
//		UsernamePasswordToken token = new UsernamePasswordToken(username.trim(), password.trim());
//		try {
//            Subject subject = SecurityUtils.getSubject();
//            if (subject != null)
//                subject.logout();
//            subject.login(token);
//            return ResponseBo.ok();
//        } catch (UnknownAccountException | IncorrectCredentialsException e) {
//            return ResponseBo.error(e.getMessage());
//        } catch (AuthenticationException e) {
//            return ResponseBo.error("认证失败！");
//        }
//	}
}
