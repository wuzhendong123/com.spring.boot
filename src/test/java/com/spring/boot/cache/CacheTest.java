package com.spring.boot.cache;

import com.spring.boot.BaseTest;
import com.spring.boot.service.common.RedisCacheInterfaceService;
import com.spring.boot.service.common.bean.RedisQueryBean;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CacheTest extends BaseTest {
    @Autowired
    private RedisCacheInterfaceService redisCacheService;

    @Test
    public void findTest(){

        System.out.println(redisCacheService.getClass());
        RedisQueryBean redisQueryBean=new RedisQueryBean();
        redisQueryBean.setUserNo("userNo2");
        redisQueryBean.setToken("token3");
        redisCacheService.findBy(redisQueryBean);

        redisCacheService.findBy(redisQueryBean);
        redisQueryBean.setToken("token5");
        redisCacheService.findBy(redisQueryBean);


    }
    @Test
    public void findByUserNoTest(){

        System.out.println(redisCacheService.getClass());
        RedisQueryBean redisQueryBean=new RedisQueryBean();
        redisQueryBean.setUserNo("userNo2");
        redisQueryBean.setToken("token3");
        redisCacheService.findByUserNo(redisQueryBean);

        redisCacheService.findByUserNo(redisQueryBean);
        redisQueryBean.setToken("token5");
        redisCacheService.findByUserNo(redisQueryBean);


    }
    @Test
    public void updateTest(){

        System.out.println(redisCacheService.getClass());
        RedisQueryBean redisQueryBean=new RedisQueryBean();
        redisQueryBean.setUserNo("userNo2");
        redisQueryBean.setToken("token3");
        redisCacheService.updateOrSave(redisQueryBean);



    }
}
