package com.spring.boot.config.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
//RedisAutoConfiguration
@Configuration
public class RedisTemplateConfig {
	/*@Bean
	@ConfigurationProperties(prefix = "spring.redis")
	public RedisConnectionFactory jedisConnectionFactory() {
		JedisConnectionFactory jcf = new JedisConnectionFactory();
//		jcf.setHostName("162.219.124.33");
//		jcf.setPort(6379);
//		jcf.setPassword("123qwe");
		return jcf;
	}*/
	
	@Bean
	public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(redisConnectionFactory);



		// 设置value的序列化规则和 key的序列化规则
		redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		//redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer(Object.class));


		redisTemplate.setKeySerializer(new StringRedisSerializer());
		return redisTemplate;


	}


}
