package com.spring.boot.service.impl;

import java.util.List;

import com.spring.boot.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.entity.Student;
import com.spring.boot.service.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;

	@Override
	public Student findByCode(String code) {
		return null;
	}

	@Override
	public List<Student> findByName(String name) {
		return studentDao.findByName(name);
	}
	
}
