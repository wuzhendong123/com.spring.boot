package com.spring.boot.function;

import com.spring.boot.config.fun.spring.registrar.annotaion.FunRouteParam;
import com.spring.boot.config.fun.spring.registrar.annotaion.RouteParam;
import com.spring.boot.entity.Student;

import java.util.List;

/**
 * @program: com.spring.boot
 * @description:
 * @author: zhendong.wu
 * @create: 2019-05-01 19:08
 **/
public interface FunctionRuleJudgeMapper {
    public List<String> test(@FunRouteParam("s")  String name, @FunRouteParam("code") @RouteParam("code")String code);

    List<String> testStudent(@FunRouteParam("s") Student student, @FunRouteParam("code") @RouteParam("code")String code);

    List<String> testStudent2(@FunRouteParam("s") Student student, @FunRouteParam("code") @RouteParam("code")String code);
}
