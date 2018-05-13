package com.spring.boot.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import com.spring.boot.config.mq.MqProperties;

@Component
@EnableConfigurationProperties(value={MqProperties.class})
public class EnableConfigurationPropertiesBean {

}
