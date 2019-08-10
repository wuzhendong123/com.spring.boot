package com.spring.boot.config.fun.spring.method;

import com.spring.boot.config.fun.spring.method.param.MethodParameter;
import org.springframework.core.BridgeMethodResolver;
import org.springframework.core.annotation.AnnotatedElementUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @program: com.spring.boot
 * @description:
 * @author: zhendong.wu
 * @create: 2019-05-01 15:51
 **/
public class FunRouteHandlerMethod {
    private final Method method;
    private final Method bridgedMethod;
    private final MethodParameter[] parameters;
    private final Class<?> tagType;
    public FunRouteHandlerMethod( Method method) {

        this.method = method;
        this.bridgedMethod = BridgeMethodResolver.findBridgedMethod(method);
        this.tagType =bridgedMethod.getDeclaringClass();
        this.parameters = this.initMethodParameters();
    }
    private MethodParameter[] initMethodParameters() {
        int count = this.bridgedMethod.getParameterTypes().length;
        MethodParameter[] result = new MethodParameter[count];
        for(int i = 0; i < count; ++i) {
            FunRouteHandlerMethod.HandlerMethodParameter parameter = new FunRouteHandlerMethod.HandlerMethodParameter(i);
            result[i] = parameter;
        }

        return result;
    }

    public <A extends Annotation> A getMethodAnnotation(Class<A> annotationType) {
        return AnnotatedElementUtils.findMergedAnnotation(this.method, annotationType);
    }

    public <A extends Annotation> boolean hasMethodAnnotation(Class<A> annotationType) {
        return AnnotatedElementUtils.hasAnnotation(this.method, annotationType);
    }
    protected class HandlerMethodParameter extends MethodParameter {
        public HandlerMethodParameter(int index) {
            super(FunRouteHandlerMethod.this.bridgedMethod, index);
        }

        public Class<?> getContainingClass() {
            return FunRouteHandlerMethod.this.getTagType();
        }

        public <T extends Annotation> T getMethodAnnotation(Class<T> annotationType) {
            return FunRouteHandlerMethod.this.getMethodAnnotation(annotationType);
        }

        public <T extends Annotation> boolean hasMethodAnnotation(Class<T> annotationType) {
            return FunRouteHandlerMethod.this.hasMethodAnnotation(annotationType);
        }


    }
    public Class<?> getTagType() {
        return tagType;
    }

    public Method getMethod() {
        return method;
    }

    public Method getBridgedMethod() {
        return bridgedMethod;
    }

    public MethodParameter[] getParameters() {
        return parameters;
    }
}
