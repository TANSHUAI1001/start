package com.tan.start.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping(value="/")
public class MenuController {

    @Resource(name = "redisTemplate")
    private RedisTemplate<String, String> template;

    @RequestMapping(value="/")
    public String defaults() {
        return "redirect:index";
    }

    @RequestMapping(value="/dashboard")
    public String dashboard() {
        template.opsForValue().set("start","dashboard");
        return "dashboard";
    }

    @RequestMapping(value="/profile")
    public String profile() {
        System.out.println(template.opsForValue().get("start"));
        return "profile";
    }

    @RequestMapping(value="/user")
    public String index1() {
        return "index1";
    }

    @RequestMapping(value="/resource")
    public String index2() {
        return "index2";
    }
}
