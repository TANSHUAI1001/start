package com.tan.start.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * extends WebMvcConfigurationSupport会覆盖默认配置，应使用implements WebMvcConfigurer
 * https://www.oschina.net/question/1457994_2289286
 */
@Configuration
public class CORSConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000","http://127.0.0.1:3000","file://")
                .allowedMethods("POST", "GET")
                .exposedHeaders("Set-Cookie")
                .maxAge(1800)
                .allowCredentials(true);
    }
}
