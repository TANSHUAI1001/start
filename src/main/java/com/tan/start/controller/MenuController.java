package com.tan.start.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping(value="/")
public class MenuController {

    @Resource(name = "redisTemplate")
    private RedisTemplate<Object, Object> template;

    @RequestMapping(value="/")
    public ModelAndView defaults(ModelAndView modelAndView) {
        modelAndView.setViewName("redirect:index");
        return modelAndView;
    }

    @RequestMapping(value="/dashboard")
    public ModelAndView dashboard(ModelAndView modelAndView) {
        template.opsForValue().set("shiro:start","dashboard",60, TimeUnit.SECONDS);
        modelAndView.setViewName("dashboard");
        modelAndView.addObject("active","/dashboard");
        return modelAndView;
    }

    @RequestMapping(value="/profile")
    public ModelAndView profile(ModelAndView modelAndView) {
        System.out.println(template.opsForValue().get("shiro:start"));
        modelAndView.setViewName("profile");
        modelAndView.addObject("active","/profile");
        return modelAndView;
    }

    @RequestMapping(value="/management/user")
    public ModelAndView index1(ModelAndView modelAndView) {
        modelAndView.setViewName("index1");
        modelAndView.addObject("active","/management/user");
        return modelAndView;
    }

    @RequestMapping(value="/management/resource")
    @RequiresRoles("admin")
    public ModelAndView index2(ModelAndView modelAndView) {
        modelAndView.setViewName("index2");
        modelAndView.addObject("active","/management/resource");
        return modelAndView;
    }
}
