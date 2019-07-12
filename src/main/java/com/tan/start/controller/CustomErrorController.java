package com.tan.start.controller;

import com.tan.start.constants.CommonConstant;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(CommonConstant.ERROR)
public class CustomErrorController {

    @RequestMapping(CommonConstant.UNAUTHORIZED)
    public ModelAndView error401(ModelAndView modelAndView){
        modelAndView.setViewName(CommonConstant.ERROR.concat(CommonConstant.UNAUTHORIZED));
        return modelAndView;
    }

    @RequestMapping(CommonConstant.FORBIDDEN)
    public ModelAndView error403(ModelAndView modelAndView){
        modelAndView.setViewName(CommonConstant.ERROR.concat(CommonConstant.FORBIDDEN));
        return modelAndView;
    }

    @RequestMapping(CommonConstant.NOT_FOUND)
    public ModelAndView error404(ModelAndView modelAndView){
        modelAndView.setViewName(CommonConstant.ERROR.concat(CommonConstant.NOT_FOUND));
        return modelAndView;
    }

    @RequestMapping(CommonConstant.INTERNAL_SEVER_ERROR)
    public ModelAndView error500(ModelAndView modelAndView){
        modelAndView.setViewName(CommonConstant.ERROR.concat(CommonConstant.INTERNAL_SEVER_ERROR));
        return modelAndView;
    }
}
