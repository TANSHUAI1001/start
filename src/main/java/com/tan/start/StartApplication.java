package com.tan.start;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import com.tan.start.config.shiro.FebsProperties;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.tan.start.**.**"})
@MapperScan(basePackages = {"com.tan.start.dao"})
@EnableConfigurationProperties({FebsProperties.class})
public class StartApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

}

//// war包部署
//@SpringBootApplication
////@ComponentScan(basePackages = {"com.tan.start.**.**"})
//@MapperScan(basePackages = {"com.tan.start.dao"})
//@EnableConfigurationProperties({FebsProperties.class})
//public class StartApplication extends SpringBootServletInitializer {
//
//    public static void main(String[] args) {
//        SpringApplication.run(StartApplication.class, args);
//    }
//
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
//        return builder.sources(StartApplication.class);
//    }
//
//}
