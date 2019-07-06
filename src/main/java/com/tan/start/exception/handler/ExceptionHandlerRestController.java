package com.tan.start.exception.handler;


import com.tan.start.exception.CommonException;
import com.tan.start.utils.ResponseResult;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// https://docs.spring.io/spring-framework/docs/4.2.4.RELEASE/spring-framework-reference/html/mvc.html#mvc-ann-controller-advice
@ControllerAdvice(annotations = RestController.class)
@ResponseBody
public class ExceptionHandlerRestController {
    // The @ExceptionHandler value can be set to an array of Exception types.
    @ExceptionHandler(value = {
            UnauthorizedException.class,
            AuthorizationException.class,
            CommonException.class,
            NullPointerException.class})
    public ResponseResult handleRestException(Exception ex) {
        return ResponseResult.error(ex.getMessage());
    }
}
