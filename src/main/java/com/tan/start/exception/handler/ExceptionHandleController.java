package com.tan.start.exception.handler;

import com.tan.start.controller.HomeController;
import com.tan.start.controller.MenuController;
import com.tan.start.exception.CommonException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(assignableTypes = {HomeController.class, MenuController.class})
public class ExceptionHandleController {
    @ExceptionHandler(UnauthorizedException.class)
    public String handleShiroException(Exception ex) {
        return "redirect:/error/403";
    }

    @ExceptionHandler(AuthorizationException.class)
    public String AuthorizationException(Exception ex) {
        return "redirect:/error/401";
    }

    @ExceptionHandler(CommonException.class)
    public String CommonException(Exception ex) {
        return "redirect:/error/500";
    }
}
