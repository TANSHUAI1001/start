package com.tan.start.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tan.start.entity.Activity;
import com.tan.start.service.ActivityService;

@Controller
@RequestMapping(value="/")
public class HomeController {
	
	@Resource
	private ActivityService activityService;
	
	@RequestMapping(value="/index")
	public ModelAndView index(ModelAndView modelAndView) {
		modelAndView.setViewName("index");
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
}
