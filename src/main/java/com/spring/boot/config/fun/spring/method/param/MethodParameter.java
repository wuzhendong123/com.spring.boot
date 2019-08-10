package com.spring.boot.config.fun.spring.method.param;

import com.spring.boot.config.fun.spring.registrar.annotaion.FunRouteParam;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.util.Assert;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: com.spring.boot
 * @description:
 * @author: zhendong.wu
 * @create: 2019-05-01 16:51
 **/
public class MethodParameter {
    private final Method method;
    private final int parameterIndex;
    private int nestingLevel;
    Map<Integer, Integer> typeIndexesPerLevel;
    private volatile Class<?> containingClass;
    private volatile Class<?> parameterType;
    private volatile Type genericParameterType;
    private volatile Annotation[] parameterAnnotations;
    private volatile String parameterName;
    private volatile Parameter parameter;

    public MethodParameter(Method method, int parameterIndex) {
        this((Method)method, parameterIndex, 1);
    }

    public MethodParameter(Method method, int parameterIndex, int nestingLevel) {
        this.nestingLevel = 1;
        Assert.notNull(method, "Method must not be null");
        this.method = method;
        this.parameterIndex = parameterIndex;
        this.nestingLevel = nestingLevel;
        this.parameterAnnotations=getParameterAnnotations();
        this.parameter=method.getParameters()[parameterIndex];
        this.parameterName=paramNameResolver(parameter);
    }

    private String paramNameResolver(Parameter parameter) {
        String name=null;
         name=parameter.getName();
          boolean result=  AnnotatedElementUtils.isAnnotated(parameter,FunRouteParam.class);
          if(result){
              FunRouteParam funRouteParam=AnnotatedElementUtils.getMergedAnnotation(parameter,FunRouteParam.class);
              name= funRouteParam.value();
          }
          return name;

    }


    public Method getMethod() {
        return this.method;
    }


    public Class<?> getDeclaringClass() {
        return this.method.getDeclaringClass();
    }


    public AnnotatedElement getAnnotatedElement() {
        return (AnnotatedElement)(this.method);
    }

    public int getParameterIndex() {
        return this.parameterIndex;
    }

    public void increaseNestingLevel() {
        ++this.nestingLevel;
    }

    public void decreaseNestingLevel() {
        this.getTypeIndexesPerLevel().remove(this.nestingLevel);
        --this.nestingLevel;
    }

    public int getNestingLevel() {
        return this.nestingLevel;
    }

    public void setTypeIndexForCurrentLevel(int typeIndex) {
        this.getTypeIndexesPerLevel().put(this.nestingLevel, typeIndex);
    }

    public Integer getTypeIndexForCurrentLevel() {
        return this.getTypeIndexForLevel(this.nestingLevel);
    }

    public Integer getTypeIndexForLevel(int nestingLevel) {
        return (Integer)this.getTypeIndexesPerLevel().get(nestingLevel);
    }

    private Map<Integer, Integer> getTypeIndexesPerLevel() {
        if (this.typeIndexesPerLevel == null) {
            this.typeIndexesPerLevel = new HashMap(4);
        }

        return this.typeIndexesPerLevel;
    }


    void setContainingClass(Class<?> containingClass) {
        this.containingClass = containingClass;
    }

    public Class<?> getContainingClass() {
        return this.containingClass != null ? this.containingClass : this.getDeclaringClass();
    }

    void setParameterType(Class<?> parameterType) {
        this.parameterType = parameterType;
    }

    public Class<?> getParameterType() {
        Class<?> paramType = this.parameterType;
        if (paramType == null) {
            if (this.parameterIndex < 0) {
                Method method = this.getMethod();
                paramType = method != null ? method.getReturnType() : Void.TYPE;
            } else {
                paramType = this.method.getParameterTypes()[this.parameterIndex] ;
            }

            this.parameterType = paramType;
        }

        return paramType;
    }

    public Type getGenericParameterType() {
        Type paramType = this.genericParameterType;
        if (paramType == null) {
            if (this.parameterIndex < 0) {
                Method method = this.getMethod();
                paramType = method != null ? method.getGenericReturnType() : Void.TYPE;
            } else {
                paramType =  this.method.getGenericParameterTypes()[this.parameterIndex] ;
            }

            this.genericParameterType = (Type)paramType;
        }

        return (Type)paramType;
    }


    public Annotation[] getMethodAnnotations() {
        return this.adaptAnnotationArray(this.getAnnotatedElement().getAnnotations());
    }

    public <A extends Annotation> A getMethodAnnotation(Class<A> annotationType) {
        return this.adaptAnnotation(this.getAnnotatedElement().getAnnotation(annotationType));
    }

    public <A extends Annotation> boolean hasMethodAnnotation(Class<A> annotationType) {
        return this.getAnnotatedElement().isAnnotationPresent(annotationType);
    }

    public Annotation[] getParameterAnnotations() {
        if (this.parameterAnnotations == null) {
            Annotation[][] annotationArray =  this.method.getParameterAnnotations() ;
            if (this.parameterIndex >= 0 && this.parameterIndex < annotationArray.length) {
                this.parameterAnnotations = this.adaptAnnotationArray(annotationArray[this.parameterIndex]);
            } else {
                this.parameterAnnotations = new Annotation[0];
            }
        }

        return this.parameterAnnotations;
    }

    public boolean hasParameterAnnotations() {
        return this.getParameterAnnotations().length != 0;
    }

    public <A extends Annotation> A getParameterAnnotation(Class<A> annotationType) {
        Annotation[] anns = this.getParameterAnnotations();
        Annotation[] var3 = anns;
        int var4 = anns.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            Annotation ann = var3[var5];
            if (annotationType.isInstance(ann)) {
                return (A) ann;
            }
        }

        return null;
    }

    public <A extends Annotation> boolean hasParameterAnnotation(Class<A> annotationType) {
        return this.getParameterAnnotation(annotationType) != null;
    }



    public String getParameterName() {
        return this.parameterName;
    }

    protected <A extends Annotation> A adaptAnnotation(A annotation) {
        return annotation;
    }

    protected Annotation[] adaptAnnotationArray(Annotation[] annotations) {
        return annotations;
    }

    public Parameter getParameter() {
        return parameter;
    }

    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }

    public String toString() {
        return (this.method != null ? "method '" + this.method.getName() + "'" : "constructor") + " parameter " + this.parameterIndex;
    }


}
