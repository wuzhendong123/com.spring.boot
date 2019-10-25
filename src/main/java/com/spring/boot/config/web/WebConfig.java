package com.spring.boot.config.web;

import com.spring.boot.config.web.formatter.DateFormatter;
import com.spring.boot.config.web.interceptor.ThreadTraceIdInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.Ordered;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

@Configuration
//@EnableWebMvc 添加此注解,原有WebMvcConfigurerAdapter取消自动配置，需要手动配置
public class WebConfig extends WebMvcConfigurerAdapter {
//DispatcherServlet dispatcherservlet;
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//添加查询资源文件 css js 
		 registry.addResourceHandler("/my/**").addResourceLocations("classpath:/my/");
	        super.addResourceHandlers(registry);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//添加拦截器
	//	registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/**").excludePathPatterns("/toLogin","/login");
		registry.addInterceptor(new ThreadTraceIdInterceptor()).addPathPatterns("/**");
		super.addInterceptors(registry);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/error").setViewName("error.html");
		registry.addViewController("/").setViewName("index.html");
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	}

	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
		super.configureHandlerExceptionResolvers(exceptionResolvers);
	}
	@Override
	public void addFormatters(final FormatterRegistry registry) {
		super.addFormatters(registry);
		registry.addFormatter(dateFormatter());
	}
	/**
	 * 1、 extends WebMvcConfigurationSupport
	 * 2、重写下面方法;
	 * setUseSuffixPatternMatch : 设置是否是后缀模式匹配，如“/user”是否匹配/user.*，默认真即匹配；
	 * setUseTrailingSlashMatch : 设置是否自动后缀路径模式匹配，如“/user”是否匹配“/user/”，默认真即匹配；
	 */
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		super.configurePathMatch(configurer);
		configurer.setUseSuffixPatternMatch(false);
	}
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("Messages");
		return messageSource;
	}
	@Bean
	public DateFormatter dateFormatter() {
		return new DateFormatter();
	}
}
