package com.spring.boot.service.composite;

import com.spring.boot.util.SpringUtil;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;


/**
 * @program: parentDemo
 * @description:
 * @author: zhendong.wu
 * @create: 2019-11-15 14:19
 **/
public  abstract  class DefaultCompositeService<T> implements CompositeService ,InitializingBean {
    protected Class _type;
    @Override
    public void afterPropertiesSet() throws Exception {
        Type superClass = this.getClass().getGenericSuperclass();
        if (superClass instanceof Class) {
            System.out.println("Internal error: TypeReference constructed without actual type information");
        } else {
            Type type=((ParameterizedType)superClass).getActualTypeArguments()[0];
            if(type instanceof Class){
                _type=(Class)type;
            }else{
                throw new RuntimeException(String.format("type !instanceof Class ,type=%s",type.toString()) );
            }


        }

        Map<String,T> mccChannelServices=  springUtil.getApplicationContext().getBeansOfType(_type);
        if(mccChannelServices!=null&&!mccChannelServices.isEmpty()){
            Iterator<String> iteratorSet=mccChannelServices.keySet().iterator();
            while(iteratorSet.hasNext()){
                String key= iteratorSet.next();
                T iMccChannelService= mccChannelServices.get(key);
                if(!(iMccChannelService instanceof CompositeService)){
                    compositeServices.add(iMccChannelService);
                }
            }
        }
        Collections.sort(compositeServices, AnnotationAwareOrderComparator.INSTANCE);

    }


    private List<T> compositeServices =new LinkedList<>();
    public  List<T> getCompositeServices(){
        return compositeServices;
    }
    @Resource
    SpringUtil springUtil;
}
