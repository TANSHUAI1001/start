package com.tan.start.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/")
public class MenuController {

    @RequestMapping(value="/")
    public ModelAndView defaults(ModelAndView modelAndView) {
        modelAndView.setViewName("redirect:index");
        return modelAndView;
    }

    @RequestMapping(value="/dashboard")
    public ModelAndView dashboard(ModelAndView modelAndView) {
        modelAndView.setViewName("dashboard");
        modelAndView.addObject("active","/dashboard");
        return modelAndView;
    }

    @RequestMapping(value="/fund")
    public ModelAndView fund(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        modelAndView.addObject("active","/fund");
        return modelAndView;
    }

    @RequestMapping(value="/profile")
    public ModelAndView profile(ModelAndView modelAndView) {
        modelAndView.setViewName("profile");
        modelAndView.addObject("active","/profile");
        return modelAndView;
    }

    @RequestMapping(value="/management/user")
    public ModelAndView index1(ModelAndView modelAndView) {
        modelAndView.setViewName("/management/user");
        modelAndView.addObject("active","/management/user");
        return modelAndView;
    }

    @RequestMapping(value="/management/resource")
    @RequiresRoles("admin")
    public ModelAndView index2(ModelAndView modelAndView) {
        modelAndView.setViewName("/management/resource");
        modelAndView.addObject("active","/management/resource");
        return modelAndView;
    }
}
