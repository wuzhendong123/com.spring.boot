package com.spring.boot.service.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: parentDemo
 * @description:
 * @author: zhendong.wu
 * @create: 2019-11-16 16:23
 **/
public abstract class DefaultOnlySupperCompositeService<T,E> extends DefaultSupperCompositeService<T,E>{
    public List<T> find(String key,E e){
       List<T> list= super.find(key,e);
       if(list!=null&&list.size()>1){
            List<T> temps=  new ArrayList<>();
           temps.add(list.get(0));
            return temps;
       }else{
           return list;
       }
    }
}
