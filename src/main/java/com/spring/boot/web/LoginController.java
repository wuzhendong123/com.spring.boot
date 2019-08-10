package com.spring.boot.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.spring.boot.entity.Operator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	@RequestMapping("/toLogin")	
	public String toLogin() {
		return "login/login";
	}
	@RequestMapping("/login")	
	public String login(@RequestParam("name") String name,@RequestParam("passWord")String passWord,HttpServletRequest httpRequest) {
		HttpSession session=httpRequest.getSession();
		Operator operator=new Operator();
		operator.setName(name);
		session.setAttribute("auth", operator);
		return "redirect:index";
	}
}
