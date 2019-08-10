package com.spring.boot.config.fun;

import com.spring.boot.config.fun.spring.registrar.annotaion.FunRouteScan;
import org.springframework.stereotype.Component;

/**
 * @program: com.spring.boot
 * @description:
 * @author: zhendong.wu
 * @create: 2019-05-01 19:09
 **/
@Component
@FunRouteScan(basePackages = "com.spring.boot.function")
public class FunctionConfig {
}
