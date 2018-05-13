package com.spring.boot.service;

import java.util.List;

import com.spring.boot.entity.Student;

public interface StudentService {
	public Student findByCode(String code);
	public List<Student> findByName(String name);
}
