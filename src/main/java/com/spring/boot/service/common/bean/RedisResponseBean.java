package com.spring.boot.service.common.bean;

import lombok.Data;

import java.util.Date;

@Data
public class RedisResponseBean {
    private String userNo;
    private String token;
    private Date  createTime;
}