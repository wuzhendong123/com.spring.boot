package com.spring.boot.auto;

import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import java.util.Map;

/**
 * @program: com.spring.boot
 * @description:
 * @author: zhendong.wu
 * @create: 2019-11-02 22:57
 **/
public class WuVelocityTemplateEngine extends VelocityTemplateEngine {
    @Override
    public Map<String, Object> getObjectMap(TableInfo tableInfo) {
        Map<String, Object> map= super.getObjectMap(tableInfo);

        return doObjectMap(tableInfo,map);
    }

    private Map<String, Object>  doObjectMap(TableInfo tableInfo,Map<String, Object> map){

        map.put("serviceLowName",serviceImplName(tableInfo.getServiceImplName()));
        map.put("entityLow",firstLowerName(tableInfo.getEntityName()));
        return map;
    }

    private String serviceImplName(String serviceImplName){

       int length= serviceImplName.length();
        serviceImplName=serviceImplName.substring(0,length-4);
        serviceImplName= firstLowerName(serviceImplName);
        return serviceImplName;

    }
    private String firstLowerName(String name){

        name= name.substring(0,1).toLowerCase()+name.substring(1);
        return name;

    }


    public static void main(String[] args) {
        WuVelocityTemplateEngine m=new  WuVelocityTemplateEngine();
        System.out.println(m.serviceImplName("Adasd1gImpl"));
    }
}
