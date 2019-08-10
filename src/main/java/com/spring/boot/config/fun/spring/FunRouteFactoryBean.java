package com.spring.boot.config.fun.spring;

import com.spring.boot.service.common.RuleJudgeService;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

/**
 * @program: com.spring.boot
 * @description:
 * @author: zhendong.wu
 * @create: 2019-05-01 14:50
 **/
public class FunRouteFactoryBean<T>  implements FactoryBean<T> {
    private Class<T> mapperInterface;

    private RuleJudgeService ruleJudgeService;
    public FunRouteFactoryBean(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public FunRouteFactoryBean() {
    }

    @Override
    public T getObject() throws Exception {
        FunRouteProxy<T> rouleFunProxy=new FunRouteProxy<T>(mapperInterface,ruleJudgeService);
         return  (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[] { mapperInterface }, rouleFunProxy);

    }

    @Override
    public Class<?> getObjectType() {
        return mapperInterface;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public RuleJudgeService getRuleJudgeService() {
        return ruleJudgeService;
    }

    public void setRuleJudgeService(RuleJudgeService ruleJudgeService) {
        this.ruleJudgeService = ruleJudgeService;
    }
}
