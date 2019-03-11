package com.tan.start.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tan.start.entity.Activity;
import com.tan.start.service.ActivityService;

@Controller
@RequestMapping(value="/")
public class HomeController {
	
	@Resource
	private ActivityService activityService;
	
	private Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value="/index")
	public ModelAndView index(ModelAndView modelAndView) {
		modelAndView.setViewName("index");
		modelAndView.addObject("name","shuai");
		return modelAndView;
	}
	
	@RequestMapping(value="/test")
	public String test() {
		
		return "sub/test";
	}
	
	@RequestMapping(value="/data")
	@ResponseBody
	public List<Activity> data() {
		return activityService.queryActivities();
	}
	
	// ResponseEntity不仅可以返回json结果，还可以定义返回的HttpHeaders和HttpStatus
	@RequestMapping(value="/page")
	@ResponseBody
	public Object page() {
		PageHelper.startPage(2,3);
		List<Activity> list = activityService.queryActivities();
		PageInfo<Activity> info = new PageInfo<Activity>(list);
		logger.debug("size: "+info.getSize());
		return info;
		
	}
}
