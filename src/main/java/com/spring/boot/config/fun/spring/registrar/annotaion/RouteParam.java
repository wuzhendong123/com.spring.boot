package com.spring.boot.config.fun.spring.registrar.annotaion;

import java.lang.annotation.*;

/**
 * @program: com.spring.boot
 * @description:
 * @author: zhendong.wu
 * @create: 2019-05-01 17:21
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
@Documented
public @interface RouteParam {
    String value() default "";
}
