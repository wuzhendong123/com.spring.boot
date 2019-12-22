package com.spring.boot.service.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: parentDemo
 * @description:
 * @author: zhendong.wu
 * @create: 2019-11-16 16:23
 **/
public abstract class DefaultSupperCompositeService<T,E> extends DefaultCompositeService{


    private Map<String,List<T>> customizeServiceCache=new ConcurrentHashMap<>();

    public List<T> find(String key,E e){

        List<T> compositeServices   =  customizeServiceCache.get(key);
        if(compositeServices==null){
            List<T> compositeServicesTmp=new ArrayList<>();
            List<T> compositeServicesList =  getCompositeServices();
            if(compositeServicesList!=null){
                Iterator<T> var2 = compositeServicesList.iterator();
                while(var2.hasNext()){
                  T tmp=   var2.next();
                    if(supportAction(tmp,e)){
                        compositeServicesTmp.add(tmp);
                    }
                }
            }
            customizeServiceCache.put(key,compositeServicesTmp);
            compositeServices= compositeServicesTmp;
        }
        return compositeServices;
    }
    public abstract  Boolean supportAction(T t, E e);
}
