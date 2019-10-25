package com.spring.boot;


import com.spring.boot.config.ds.context.MybatisPlusConfig;
import com.wu.resource.App;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.StandardAnnotationMetadata;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;
import sun.reflect.Reflection;

import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.NoSuchProviderException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.sql.DriverManager;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Properties;


public class ApplicationTest {
	//static Logger logger = LoggerFactory.getLogger(ApplicationTest.class);
//	 @RequestMapping("/")
	 String home() {
	 return "Hello World!";
	 }
	 public static void main(String[] args) throws Exception {

		// Resource resource=  new ClassPathResource("classpath:/static/ruoyi.png".substring("classpath:".length()), Thread.currentThread().getContextClassLoader());
		 Resource resource=  new ClassPathResource("classpath:/file1/index3.jsp".substring("classpath:".length()), Thread.currentThread().getContextClassLoader());

		 //Resource resource=  new ClassPathResource("classpath:/templates/index.html".substring("classpath:".length()), Thread.currentThread().getContextClassLoader());
		 try {
			 System.out.println(resource.getInputStream());
		 } catch (IOException e) {
			 e.printStackTrace();
		 }
		// resources();

		 System.out.println( App.class.getTypeName());
	//	 DriverManager.getConnection()

		 System.out.println( App.cc);
		 System.out.println( "----------------");
		 System.out.println( App.class.getClassLoader().getResource("/file1/acp_test_root.cer"));
		 System.out.println( App.class.getClassLoader().getResource("file1/acp_test_root.cer"));
		 System.out.println( App.class.getClassLoader().getResourceAsStream("/file1/acp_test_root.cer"));
		 System.out.println( App.class.getClassLoader().getResourceAsStream("file1/acp_test_root.cer"));
		 System.out.println(App.class.getResource("file1/acp_test_root.cer"));
		 System.out.println(App.class.getResource("/file1/acp_test_root.cer"));
		// X509Certificate X509Certificate= initCert(App.class.getResource("/file1/acp_test_root.cer").getPath());
		// System.out.println(X509Certificate);


		 Properties props = new Properties();

		 props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties"));
		 System.out.println(props.getProperty("server.error.path"));

	 }
	private static X509Certificate initCert(String path) {
		X509Certificate encryptCertTemp = null;
		CertificateFactory cf = null;
		InputStream in = null;
		try {
			cf = CertificateFactory.getInstance("X.509");
			in = App.class.getClassLoader().getResourceAsStream("file1/acp_test_root.cer");
			encryptCertTemp = (X509Certificate) cf.generateCertificate(in);
			// 打印证书加载信息,供测试阶段调试
			System.out.println("[" + path + "][CertId="
					+ encryptCertTemp.getSerialNumber().toString() + "]");
		} catch (CertificateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return encryptCertTemp;
	}
	 public static void test() {
		 System.out.println(Reflection.getCallerClass().getClassLoader());
	 }
	 public static void annotation(){
		 Annotation[] a= MybatisPlusConfig.class.getAnnotations();
		 Annotation annotation=  a[1];
		 annotation.getClass().getDeclaredAnnotations();
		 Class aClass=annotation.annotationType();






		 aClass.getDeclaredAnnotations();
		 System.out.println("------------");
		 AnnotationMetadata annotationMetadata=new StandardAnnotationMetadata(MybatisPlusConfig.class);
		 AnnotatedElement annotatedElement=AnnotatedElementUtils.forAnnotations(a);
		 MultiValueMap<String, Object> m= AnnotatedElementUtils.getAllAnnotationAttributes(annotatedElement,MapperScan.class.getName());

		 AnnotationAttributes annoAttrs = AnnotationAttributes.fromMap(annotationMetadata.getAnnotationAttributes(MapperScan.class.getName()));
		 System.out.println(AnnotatedElementUtils.getMergedAnnotationAttributes(annotatedElement,Import.class.getName()));
		 System.out.println(annoAttrs);
		 // annoAttrs.getStringArray()
//		 AnnotationAttributes annotationAttributes=AnnotatedElementUtils.getan
//		 MybatisPlusConfig.class.get
	 }
	 public static void resources() throws IOException, URISyntaxException {
		 ClassLoader classLoader=null;
		 Enumeration<URL> urls = classLoader != null ? classLoader.getResources("META-INF/spring.factories") : ClassLoader.getSystemResources("META-INF/spring.factories");
		 while(urls.hasMoreElements()) {
			 URL url = (URL)urls.nextElement();
			 System.out.println(url);
			 System.out.println(url.toURI());
			// url.openStream();
			 File f=new File(url.toString());
		 }

	 }
	
}
