package com.spring.boot.dao;

import com.spring.boot.entity.Student;

import java.util.List;

public interface StudentDao extends EntityDao<Student,String>{

    public List<Student> findByName(String name);
}
