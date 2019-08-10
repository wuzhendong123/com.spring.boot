package com.spring.boot.config.ds.context.meta;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MetaObjectHandlerConfig extends MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
//        System.out.println("插入方法实体填充");
        Object createTime = getFieldValByName("createTime",metaObject);
        if(createTime==null){
            setFieldValByName("createTime", new Date(), metaObject);
        }
        Object optimistic = getFieldValByName("optimistic",metaObject);
        if(optimistic==null){
            setFieldValByName("optimistic", 0, metaObject);
        }

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        System.out.println("更新方法实体填充");
    }
}
