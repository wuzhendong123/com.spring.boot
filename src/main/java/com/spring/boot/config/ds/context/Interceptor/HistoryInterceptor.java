package com.spring.boot.config.ds.context.Interceptor;

import com.baomidou.mybatisplus.plugins.OptimisticLockerInterceptor;
import com.spring.boot.config.ds.context.anno.History;
import com.spring.boot.entity.base.BaseEntity;
import com.spring.boot.util.BeanUtil;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.springframework.beans.BeanUtils;

import java.util.HashMap;
import java.util.Properties;

@Intercepts({@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})})
public class HistoryInterceptor implements Interceptor  {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        MappedStatement ms = (MappedStatement) args[0];

        Object param = args[1];

        String methodId = ms.getId();
        String updateMethodName = methodId.substring(ms.getId().lastIndexOf(".") + 1);

        Object bean=null;
        if(param instanceof BaseEntity){
            bean=param;
            }else if(param instanceof HashMap){
              if(((HashMap)param).containsKey("et")){
                bean= ((HashMap) ((HashMap)param).get("et")).get(OptimisticLockerInterceptor.MP_OPTLOCK_ET_ORIGINAL);
               }
            }
            if(bean!=null){
                History history=   bean.getClass().getAnnotation(History.class);
                if(history!=null){
                    String[] updateMethodNames=   history.updateMethodNames();
             /*   if (updateMethodNames!=null&&updateMethodNames.c) {//update(entityClass, null) -->> update all. ignore version

                }*/
                    Class<? extends BaseEntity>  cla= history.entity();
                    BaseEntity baseEntity= cla.newInstance();
                    BeanUtils.copyProperties(bean,baseEntity,history.ignoreProperties());
                    baseEntity.insert();
                }
            }



        return  invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        if (target instanceof Executor) {
            return Plugin.wrap(target, this);
        }
        return target;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
