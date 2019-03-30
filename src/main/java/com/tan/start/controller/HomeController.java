package com.tan.start.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	public String test() {
		logger.debug("test  format arg {}", "100");
		return "sub/test";
	}
	
	
}
