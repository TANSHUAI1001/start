package com.tan.start;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
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
