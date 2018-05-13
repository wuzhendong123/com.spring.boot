package com.spring.boot;

import com.spring.boot.entity.Student;

public class TestStudent extends Test<Student>{

	public static void main(String[] args) {
		TestStudent testStudent=new TestStudent();
		Student student=new Student("D",19);
		student =testStudent.test(student);
		Test<Student> st=new Test<Student>();
	}
}
