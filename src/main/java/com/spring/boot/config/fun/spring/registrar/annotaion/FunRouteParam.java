package com.spring.boot.config.fun.spring.registrar.annotaion;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
@Documented
public @interface FunRouteParam {
    String value() default "";
}
