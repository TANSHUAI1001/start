package com.tan.start.config;

import com.jagregory.shiro.freemarker.ShiroTags;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.io.IOException;


@Component
public class ShiroTagFreeMarkerConfigurer implements InitializingBean {
    @Autowired
    private Configuration configuration;
    @Autowired
    private FreeMarkerViewResolver resolver;

    public void afterPropertiesSet() {
        configuration.setSharedVariable("shiro", new ShiroTags());
        resolver.setRequestContextAttribute("context");
    }

}
