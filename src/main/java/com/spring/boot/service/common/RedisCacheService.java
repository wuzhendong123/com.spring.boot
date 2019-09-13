package com.spring.boot.service.common;

import com.spring.boot.service.common.bean.RedisQueryBean;
import com.spring.boot.service.common.bean.RedisResponseBean;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class RedisCacheService implements RedisCacheInterfaceService {

    @Cacheable(value = "redisQueryBean",key="@cacheConfig.key(#redisQueryBean.userNo)")
    public List<RedisResponseBean> findByUserNo(RedisQueryBean redisQueryBean){
        System.out.println("findByUserNo");
        List<RedisResponseBean> l=new ArrayList<>();
        RedisResponseBean redisResponseBean=new RedisResponseBean();
        redisResponseBean.setToken(redisQueryBean.getToken());
        redisResponseBean.setUserNo(redisQueryBean.getUserNo());
        redisResponseBean.setCreateTime(new Date());
        l.add(redisResponseBean);

        return l;
    }
    @Cacheable(value = "redisQueryBean",key="@cacheConfig.key(#redisQueryBean.token,#redisQueryBean.userNo)")
    public List<RedisResponseBean> findBy(RedisQueryBean redisQueryBean){
        System.out.println("findBy");
        List<RedisResponseBean> l=new ArrayList<>();
        RedisResponseBean redisResponseBean=new RedisResponseBean();
        redisResponseBean.setToken(redisQueryBean.getToken());
        redisResponseBean.setUserNo(redisQueryBean.getUserNo());
        redisResponseBean.setCreateTime(new Date());
        l.add(redisResponseBean);

        return l;
    }

    @Caching(
            evict ={
                    @CacheEvict(value = "redisQueryBean",key = "@cacheConfig.key(#redisQueryBean.token,#redisQueryBean.userNo)")
            , @CacheEvict(value = "redisQueryBean",key = "@cacheConfig.key(#redisQueryBean.userNo)")}
    )
    public void updateOrSave(RedisQueryBean redisQueryBean){
        System.out.println("updateOrSave");
    }

}
