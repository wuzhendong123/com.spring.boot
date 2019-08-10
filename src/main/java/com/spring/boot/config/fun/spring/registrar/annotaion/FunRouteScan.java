package com.spring.boot.config.fun.spring.registrar.annotaion;

import com.spring.boot.config.fun.spring.registrar.FunRouteScannerRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @program: com.spring.boot
 * @description:
 * @author: zhendong.wu
 * @create: 2019-05-01 15:38
 **/

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({FunRouteScannerRegistrar.class})
public @interface FunRouteScan {
    String[] value() default {};

    String[] basePackages() default {};

}
