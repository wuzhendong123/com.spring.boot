package com.spring.boot.web;

import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@Controller
@RequestMapping(value="/student")
public class StudentController {

@Autowired
private IStudentService studentService;

@Autowired
private CacheManager cacheManager;
	@RequestMapping(value="/insert/{name}")
	@ResponseBody
	public Student test(@PathVariable("name")String name) {
		Student student=new Student();
		student.setName(name);
		studentService.insert1(student);
		return student;
//		return mqProperties.toString();
	}

	@RequestMapping(value="/student_page/{name}")
	@ResponseBody
	public Page<Student> student_page(@PathVariable("name") String name , int pageNum, int limit) {
		try{

			//student=studentDao.findByCode("111");
			System.out.println(pageNum+"|"+limit);
			Page<Student> page=new Page<>(pageNum,limit);

			return  studentService.findStudentByName(page,name);
//			return studentService.findByName("name1",pageNum,limit);
		}catch (Exception e){
			e.printStackTrace();
		}


		return null;
	}

	@RequestMapping(value="/student_code")
	@ResponseBody
	public Student student_code(String code) {

		//student=studentDao.findByCode("111");
		return studentService.selectById(code);
//		return mqProperties.toString();
	}

	@RequestMapping(value="/cache_test")
	@ResponseBody
	public Collection<String> cache_test() {

		return cacheManager.getCacheNames();
//		return mqProperties.toString();
	}


}
