package com.spring.boot.config.fun.spring.method.discoverer;

import org.springframework.core.ParameterNameDiscoverer;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @program: com.spring.boot
 * @description:
 * @author: zhendong.wu
 * @create: 2019-05-01 16:40
 **/
public class MethodParameNameDiscoverer  implements ParameterNameDiscoverer {
    private String[] paramName;
    @Override
    public String[] getParameterNames(Method method) {

        final Class<?>[] paramTypes = method.getParameterTypes();
        final Annotation[][] paramAnnotations = method.getParameterAnnotations();
        final SortedMap<Integer, String> map = new TreeMap<Integer, String>();
        int paramCount = paramAnnotations.length;
        method.getParameters();
        if(paramName==null){
            List<String> paramNames=new ArrayList<>(paramCount);


        }
        return new String[0];
    }

    @Override
    public String[] getParameterNames(Constructor<?> constructor) {
      return null;
    }
}
