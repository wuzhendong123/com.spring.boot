package com.spring.boot.config.fun.spring;

import com.spring.boot.config.fun.spring.method.FunRouteMethod;
import com.spring.boot.service.common.RuleJudgeService;
import org.apache.ibatis.reflection.ExceptionUtil;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: com.spring.boot
 * @description:
 * @author: zhendong.wu
 * @create: 2019-05-01 15:09
 **/
public class FunRouteProxy<T> implements InvocationHandler, Serializable {
    private  Map<Method, FunRouteMethod> methodCache=new ConcurrentHashMap<>();
    private  Class mapperInterface;
    private RuleJudgeService ruleJudgeService;


    public FunRouteProxy(Class<T> mapperInterface, RuleJudgeService ruleJudgeService) {
        this.mapperInterface=mapperInterface;
        this.ruleJudgeService=ruleJudgeService;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            if (Object.class.equals(method.getDeclaringClass())) {
                return method.invoke(this, args);
            }
        } catch (Throwable t) {
            throw ExceptionUtil.unwrapThrowable(t);
        }
        final FunRouteMethod mapperMethod = cachedMapperMethod(method);
        return mapperMethod.execute(args);
    }
    private FunRouteMethod cachedMapperMethod(Method method) {
        FunRouteMethod mapperMethod = methodCache.get(method);
        if (mapperMethod == null) {
           mapperMethod = new FunRouteMethod(mapperInterface, method,ruleJudgeService);
            methodCache.put(method, mapperMethod);
        }
        return mapperMethod;
    }
}
