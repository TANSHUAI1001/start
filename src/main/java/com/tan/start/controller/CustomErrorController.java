package com.tan.start.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/error")
public class CustomErrorController {

    @RequestMapping("/401")
    public ModelAndView error401(ModelAndView modelAndView){
        modelAndView.setViewName("/error/401");
        return modelAndView;
    }

    @RequestMapping("/403")
    public ModelAndView error403(ModelAndView modelAndView){
        modelAndView.setViewName("/error/403");
        return modelAndView;
    }

    @RequestMapping("/404")
    public ModelAndView error404(ModelAndView modelAndView){
        modelAndView.setViewName("/error/404");
        return modelAndView;
    }

    @RequestMapping("/500")
    public ModelAndView error500(ModelAndView modelAndView){
        modelAndView.setViewName("/error/500");
        return modelAndView;
    }
}
