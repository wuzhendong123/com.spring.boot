package com.spring.boot.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@RequestMapping(value = "/redis/string", method = RequestMethod.GET)
	@ResponseBody
	public String insertString() {
		try {
			stringRedisTemplate.opsForValue().set("stringKey", "stringValue");
		} catch (Exception e) {
			logger.error("stringRedisTemplate {}",stringRedisTemplate,e);
		}
		
		return "stringKey";
		
	}	
}
