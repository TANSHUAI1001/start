package com.tan.start.config.shiro;

import com.alibaba.fastjson.JSON;
import com.tan.start.utils.HttpUtils;
import com.tan.start.utils.ResponseContent;
import com.tan.start.utils.ResponseResult;
import org.apache.shiro.web.filter.authc.UserFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomUserFilter extends UserFilter {

    /**
     * fetch 在发请求前会先OPTIONS预请求，直接放行
     * 注意规避《Optionsbleed – HTTP OPTIONS method can leak Apache’s server memory》
     * https://blog.fuzzing-project.org/60-Optionsbleed-HTTP-OPTIONS-method-can-leak-Apaches-server-memory.html
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
//    @Override
//    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
//        HttpServletRequest httpRequest = WebUtils.toHttp(request);
//        HttpServletResponse httpResponse = WebUtils.toHttp(response);
//        if (httpRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
//            return false;
//        }
//        return super.preHandle(request, response);
//    }

    /**
     * 判断是否是 ajax 请求
     * 返回JSONs数据
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if (HttpUtils.isAjaxRequest((HttpServletRequest) request)) {
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
            httpServletResponse.setCharacterEncoding("utf-8");
            httpServletResponse.setContentType("application/json; charset=utf-8");
            httpServletResponse.getWriter().print(JSON.toJSON(ResponseContent.error().putCode(HttpStatus.UNAUTHORIZED.value())));
            return false;
        } else {
            saveRequestAndRedirectToLogin(request, response);
            return false;
        }
    }
}