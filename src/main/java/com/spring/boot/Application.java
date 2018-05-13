package com.spring.boot;


import java.sql.Driver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RestController;
import sun.reflect.Reflection; 


@RestController
@SpringBootApplication
//依赖spring-boot-starter-cache
//@EnableCaching
public class Application {
	static Logger logger = LoggerFactory.getLogger(Application.class);
//	 @RequestMapping("/")
	 String home() {
	 return "Hello World!";
	 }
	 public static void main(String[] args) throws Exception {
		 
		// 加载Class到AppClassLoader（系统类加载器），然后注册驱动类
//		 com.mysql.jdbc.Driver
//		 Class<?> d=  ContextLoader.class.getClassLoader().loadClass("com.mysql.jdbc.Driver").newInstance();
//		 Class.forName("com.mysql.jdbc.Driver").newInstance(); 
		 System.out.println(com.mysql.jdbc.Driver.class.getClassLoader());
		 System.out.println(Driver.class.getClassLoader());
		 Driver d=new com.mysql.jdbc.Driver();
		 System.out.println(d.getClass().getClassLoader());
//		 test();
//		 String url = "jdbc:mysql://localhost:3306/testdb";    
		 // 通过java库获取数据库连接
//		 Connection conn = java.sql.DriverManager.getConnection(url, "name", "password"); 
		 
//		 DESKeySpec dks = new DESKeySpec(ISO);
		 Class.forName("com.mysql.jdbc.Driver");
		 System.out.println(Class.class.getClassLoader());
//		 DriverManager.getConnection("");
		
//		 javax.xml.parsers.DocumentBuilderFactory
//		 System.out.println(FactoryFinder.c);
		 
		 logger.info("Application start ");
		 ConfigurableApplicationContext ss= SpringApplication.run(Application.class, args);
		 logger.info("Application end ");
		 
		
	 }
	 public static void test() {
		 System.out.println(Reflection.getCallerClass().getClassLoader());
	 }
	
}
