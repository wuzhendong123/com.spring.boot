package com.spring.boot.config.fun.spring.method;



import com.spring.boot.config.fun.spring.method.param.MethodParameter;
import com.spring.boot.config.fun.spring.registrar.annotaion.RouteParam;
import com.spring.boot.service.common.RuleJudgeService;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.ReflectorFactory;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: com.spring.boot
 * @description:
 * @author: zhendong.wu
 * @create: 2019-05-01 15:46
 **/
public class FunRouteMethod {

    SpelParserConfiguration config = new SpelParserConfiguration(SpelCompilerMode.IMMEDIATE,null);
    ExpressionParser parser = new SpelExpressionParser(config);
    private FunRouteHandlerMethod funRouteHandlerMethod;
    private RuleJudgeService ruleJudgeService;
    private  Class<T> mapperInterface;
    private volatile int routeCodeIndex;
    private volatile RouteParam routeCodeAn;
    public FunRouteMethod( Class<T> mapperInterface,Method method,RuleJudgeService ruleJudgeService) {
        this.funRouteHandlerMethod = new FunRouteHandlerMethod(method);
        this.mapperInterface=mapperInterface;
        this.routeCodeIndex=getRouteCodeIndex(funRouteHandlerMethod);
        this.ruleJudgeService=ruleJudgeService;
    }


    public Object execute(Object[] args) {
        String key=routeCodeAn.value();
        MetaObject metaObject=newMetaObject(key,args[routeCodeIndex]);
        String routeCode=(String)metaObject.getValue(key);

        MethodParameter[] methodParameters= funRouteHandlerMethod.getParameters();
        EvaluationContext context = new StandardEvaluationContext();
        for(int i=0;i<args.length;i++){
            MethodParameter methodParameter=methodParameters[i];
            context.setVariable(methodParameter.getParameterName(), args[i]);
        }
        return ruleJudgeService.judgeResult(routeCode,context);

    }

    private int getRouteCodeIndex(FunRouteHandlerMethod funRouteHandlerMethod) {
        MethodParameter[] methodParameters= funRouteHandlerMethod.getParameters();
        for(int i=0;i<methodParameters.length;i++){
           boolean result= AnnotatedElementUtils.isAnnotated(methodParameters[i].getParameter(),RouteParam.class);
           if(result){
               routeCodeAn=AnnotatedElementUtils.getMergedAnnotation(methodParameters[i].getParameter(),RouteParam.class);
            return i;
           }
        }
        throw  new RuntimeException(String.format("routeCodeIndex is not found class %s methode %s ",funRouteHandlerMethod.getMethod().getDeclaringClass().getName(),funRouteHandlerMethod.getMethod().getName()));
    }
    public MetaObject newMetaObject(String key,Object obj){
            Map<String,Object> map=new HashMap<>();
            map.put(key,obj);
        return MetaObject.forObject(map, objectFactory, objectWrapperFactory, reflectorFactory);
    }
    static ReflectorFactory reflectorFactory = new DefaultReflectorFactory();
    static ObjectFactory objectFactory = new DefaultObjectFactory();
    static ObjectWrapperFactory objectWrapperFactory = new DefaultObjectWrapperFactory();
}
