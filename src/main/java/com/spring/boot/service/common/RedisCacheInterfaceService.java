package com.spring.boot.service.common;

import com.spring.boot.service.common.bean.RedisQueryBean;
import com.spring.boot.service.common.bean.RedisResponseBean;

import java.util.List;

public interface RedisCacheInterfaceService {
    public List<RedisResponseBean> findByUserNo(RedisQueryBean redisQueryBean);

    List<RedisResponseBean> findBy(RedisQueryBean redisQueryBean);

    void updateOrSave(RedisQueryBean redisQueryBean);
}
