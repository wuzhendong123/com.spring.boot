package com.spring.boot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.boot.config.mq.MqProperties;

@Controller

public class TestController {
@Autowired
private MqProperties mqProperties; 
	
	@RequestMapping(value="/test_properties")
	@ResponseBody
	public String test() {
		System.out.println(mqProperties);
		return mqProperties.toString();
	}
}
