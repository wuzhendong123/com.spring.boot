package com.spring.boot.web.base;

import com.baomidou.mybatisplus.plugins.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.core.MethodParameter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @program: com.spring.boot
 * @description: 基本查询controller
 * @author: zhendong.wu
 * @create: 2018-09-09 18:15
 **/
public class BaseController<T,E> {
    public Logger log = LoggerFactory.getLogger(getClass());
    private ObjectSBF<E> defaultFieldValueSBF=new DefaultFieldValueSBF();

    public Page<E> transfer(Page<T> t, Class<E> cla){

        return transfer(t,cla,defaultFieldValueSBF);
    }
    public Page<E> transfer(Page<T> t, Class<E> cla,ObjectSBF fieldValueSBF){
        try {
            List<T> li=t.getRecords();
            List<E> lie=new ArrayList<>(t.getSize());
            Page<E> page=new Page<>();
            page.setSize(t.getSize());
            page.setCurrent(t.getCurrent());
            page.setTotal(t.getTotal());
            for(T t1:li){
                E ob=cla.newInstance();
                BeanUtils.copyProperties(t1,ob);
                fieldValueSBF.objectSbf(ob);
                lie.add(ob);
            }
            page.setRecords(lie);
            return page;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Object resolveArgument( HttpServletRequest webRequest) throws Exception {
        Map<String, String[]> parameterMap = webRequest.getParameterMap();
        Iterator var8;
        Map.Entry entry;
            Map<String, String> result = new HashMap<>(parameterMap.size());
            var8 = parameterMap.entrySet().iterator();

            while(var8.hasNext()) {
                entry = (Map.Entry)var8.next();
                String[] var10 = (String[])entry.getValue();
                if(var10!=null&&var10[0]!=null){
                    result.put((String) entry.getKey(), var10[0]);
                }

            }

            return result;
    }

}
