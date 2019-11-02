package com.spring.boot.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.spring.boot.entity.Operator;
import com.spring.boot.util.ServletUtils;
import com.spring.boot.web.respone.R;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	@RequestMapping("/doLogin")
	@ResponseBody
	public R tologin(@RequestParam("username") String name,@RequestParam("password")String passWord,HttpServletRequest httpRequest) {

		UsernamePasswordToken token = new UsernamePasswordToken(name, passWord);
		Subject subject = SecurityUtils.getSubject();
		subject.login(token);
		return R.ok();
	}

	/*@RequestMapping("/login")
	public String login(HttpServletRequest httpRequest) {
		// 如果是Ajax请求，返回Json字符串。
		if (ServletUtils.isAjaxRequest(httpRequest))
		{
			return ServletUtils.renderString(ServletUtils.getResponse(), "{\"code\":\"1\",\"msg\":\"未登录或登录超时。请重新登录\"}");
		}

		return "login";
	}*/


}
