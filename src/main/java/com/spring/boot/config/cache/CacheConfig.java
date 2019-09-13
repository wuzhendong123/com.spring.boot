package com.spring.boot.config.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

import java.lang.reflect.Method;

//依赖spring-boot-starter-cache
/**启动缓存注解*/
@EnableCaching
@Configuration
//spring.cache.type
public class CacheConfig extends  CachingConfigurerSupport{
    Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 配置CacheManager 管理cache
     * @param redisTemplate
     * @return
     */
    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        /*CachingConfigurerSupport*/
//        RedisCacheManager cacheManager=RedisCacheManager.create(redisConnectionFactory);
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate,null,true);
        cacheManager.setDefaultExpiration(60*60); // 设置key-value超时时间
        cacheManager.setUsePrefix(true);
       // cacheManager.
        return cacheManager;
    }

    @Bean
    public KeyGenerator wiselyKeyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder sb = new StringBuilder();
                sb.append(method.getName());
                for (Object obj : params) {
                    sb.append(obj.toString());
                }
                return sb.toString();
            }
        };
    }


    @Override
    public CacheErrorHandler errorHandler(){
        return new CacheErrorHandler(){

            @Override
            public void handleCacheGetError(RuntimeException e, Cache cache, Object o) {
                logger.error("handleCacheGetError o ",o,e);
            }

            @Override
            public void handleCachePutError(RuntimeException e, Cache cache, Object o, Object o1) {
                logger.error("handleCachePutError o ",o,e);
            }

            @Override
            public void handleCacheEvictError(RuntimeException e, Cache cache, Object o) {
                logger.error("handleCacheEvictError o ",o,e);
            }

            @Override
            public void handleCacheClearError(RuntimeException e, Cache cache) {
                logger.error("handleCacheClearError o ",e);
            }
        };
    }

    public static String key(Object...obj){
        StringBuilder stringBuilder=new StringBuilder();
        for(Object ob:obj){
            stringBuilder.append(ob).append("_");
        }
        return  stringBuilder.toString();
    }
}
