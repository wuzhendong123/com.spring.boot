package com.spring.boot.entity;

import java.io.Serializable;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.KeySequence;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.Version;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.spring.boot.entity.base.BaseEntity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhendong.wu
 * @since 2018-09-01
 */
public class Student extends BaseEntity<Student> {

    private static final long serialVersionUID = 1L;

	@TableField(fill =  FieldFill.INSERT_UPDATE)
	private String addr;
	private String name;
	private Integer age;

	private String real;

	public Student(String name, int age) {
		this.name=name;
		this.age=age;
	}

	public Student() {
	}


	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getReal() {
		return real;
	}

	public void setReal(String real) {
		this.real = real;
	}

	@Override
	public String toString() {
		return "Student{" +
			", addr=" + addr +
			", name=" + name +
			", age=" + age +
			"}";
	}
}
