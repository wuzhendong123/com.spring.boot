package com.spring.boot.config.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class WebMVCViewConfig {

	private static final String Prefix="/WEB-INF";
	private static final String Suffix=".jsp";
	/*@Bean
	public InternalResourceViewResolver defaultViewResolver2(){
		InternalResourceViewResolver defaultViewResolver=new InternalResourceViewResolver();
		defaultViewResolver.setPrefix(Prefix);
		defaultViewResolver.setSuffix(Suffix);
//		defaultViewResolver.setv
//		defaultViewResolver.setOrder(2);
		return defaultViewResolver;
	}
	*/
	@Bean
	public InternalResourceViewResolver defaultViewResolver(){
		InternalResourceViewResolver defaultViewResolver=new InternalResourceViewResolver();
		defaultViewResolver.setPrefix("/WEB-INF/jsp/");
		defaultViewResolver.setSuffix(".jsp");
		defaultViewResolver.setViewNames("index3"); //对视图名称匹配不匹配进行下一个视图解析器
		defaultViewResolver.setViewClass(InternalResourceView.class);
//		defaultViewResolver.setv
		defaultViewResolver.setOrder(100);
		return defaultViewResolver;
	}
}
