package com.tan.start.config;

import org.springframework.context.annotation.Bean;
import com.github.pagehelper.PageInterceptor;

//@Configuration
//暂时没用
public class MybatisConfig {

	@Bean
	public PageInterceptor pageInterceptor() {
		return new PageInterceptor();
	}
}
