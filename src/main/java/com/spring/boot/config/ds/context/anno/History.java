package com.spring.boot.config.ds.context.anno;

import com.spring.boot.entity.base.BaseEntity;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface History {
    Class<? extends BaseEntity> entity();
    String[] updateMethodNames()default {"updateById","insert"};
    String [] ignoreProperties()default {"code", "create_time","optimistic","update_time"};
}
