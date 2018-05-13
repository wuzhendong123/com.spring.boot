package com.spring.boot.config.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.spring.boot.config.web.interceptor.AuthInterceptor;
@Configuration
//@EnableWebMvc 添加此注解,原有WebMvcConfigurerAdapter取消自动配置，需要手动配置
public class WebConfig extends WebMvcConfigurerAdapter {
//DispatcherServlet dispatcherservlet;
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//添加查询资源文件 css js 
		 registry.addResourceHandler("/my/**").addResourceLocations("classpath:/my/");
		 //添加拦截器
		 //		 registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/toLogin","/login");
	        super.addResourceHandlers(registry);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/**").excludePathPatterns("/toLogin","/login");
		super.addInterceptors(registry);
	}

}
