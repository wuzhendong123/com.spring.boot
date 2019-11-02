package com.spring.boot.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

// @Configuration
public class StudentBeanConfig {
	//org.springframework.context.annotation.ConfigurationClassParser
	@Bean(name="aStudent")
	@Qualifier("aStudent")
	public Student aStudent(){
		Student student=new Student("A",16);
		return student;
	}
	@Bean(name="bStudent")
	public Student bStudent(){
		Student student=new Student("B",16);
		return student;
	}
	@Bean(name="cStudent")
	public Student cStudent(@Qualifier(value="aStudent") Student astudent){
		Student student=new Student("C",16);
		student.setName(astudent.getName());
		return student;
	}

}
