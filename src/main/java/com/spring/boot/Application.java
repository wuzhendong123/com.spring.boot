package com.spring.boot;


import io.shardingsphere.jdbc.spring.boot.SpringBootConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.aop.framework.AopProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.endpoint.mvc.EndpointHandlerMapping;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.ImportResource;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import sun.reflect.Reflection;

import javax.servlet.Filter;
import java.util.Date;


@RestController
@SpringBootApplication(exclude =SpringBootConfiguration.class )
//@EnableAdminServer
//@ImportResource({"classpath:urule-console-context.xml"})
public class Application  {
	static Logger logger = LoggerFactory.getLogger(Application.class);
//	 @RequestMapping("/")
	 String home() {
	 return "Hello World!";
	 }
	 public static void main(String[] args) throws Exception {
       //  PropertyPlaceholderConfigurer
		 //RequestMappingHandlerAdapter
		// org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration
		 //RequestMappingHandlerMapping
	//	 EndpointHandlerMappingAspectJ
	//	 ServletRegistrationBean
		 // ReflectionUtils 反射类操作
		// AopProxy
//	DispatcherServlet
//		 RequestMappingInfo
//		 StringManager
//		 org.springframework.web.context.ContextLoader;
//		 javax.servlet.ServletContextss
//         MDC.put();

		 logger.info("Application start ");
		 ConfigurableApplicationContext ss= SpringApplication.run(Application.class, args);
		 logger.info("Application end ");

//		 javax.servlet.Servlet
		// test();

	 }
	 public static void test() {

		System.out.println(System.currentTimeMillis());
		 System.out.println(new Date());
		 System.out.println(new Date());
	 }

}
