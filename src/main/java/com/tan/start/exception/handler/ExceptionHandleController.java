package com.tan.start.exception.handler;

import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandleController {
    @ExceptionHandler(UnauthorizedException.class)
    public String handleShiroException(Exception ex) {
        return "redirect:/error/403";
    }

    @ExceptionHandler(AuthorizationException.class)
    public String AuthorizationException(Exception ex) {
        return "redirect:/error/401";
    }
}
