package com.spring.boot.config;

import org.apache.ibatis.binding.MapperProxy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.boot.entity.Student;

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
