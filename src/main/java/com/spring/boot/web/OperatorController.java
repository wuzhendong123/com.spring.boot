package com.spring.boot.web;

import com.spring.boot.web.respone.R;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/sys/")
public class OperatorController {

	private String prefix = "operator";
	@RequestMapping("/operator")
	public String login() {
		return "operator";
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
