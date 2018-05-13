package com.spring.boot.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.boot.service.StudentService;


@Controller
public class Welcome {
	@Autowired
	private StudentService studentService;
	 @RequestMapping(value = "/index") 
	  public String index(Model model){  
		 	model.addAttribute("name","Ryan");
	        return "index";  
	  }  
	 @RequestMapping("/index2")	
	    public String index2(Model model){
	 
	        model.addAttribute("name","Ryan");
	 
	        return "index2";
	    }
	 	@RequestMapping("/index3")	
	    public String index3(Model model){
	 
	        model.addAttribute("name","Ryan");
	 
	        return "index3";
	    }
	 @RequestMapping("/json")
	 @ResponseBody
	    public Map<String,Object> json(){ 
		 com.mysql.jdbc.Driver d ;
	        Map<String,Object> map = new HashMap<String,Object>();
	        map.put("name","Ryan");
	        map.put("age","18");
	        map.put("sex","man");
	        return map;
	    }
	 @RequestMapping("/student")
	 @ResponseBody
	    public Map<String,Object> student(@RequestParam String a){
	        Map<String,Object> map = new HashMap<String,Object>();
	        map.put("param",a);
	       
	      /*  Student student=SpringUtil.getBean(a, Student.class);
	        map.put("age",student.getAge());
	        map.put("name",student.getName());*/
	        map.put("db", studentService.findByName(a));
	        return map;
	    }
}
