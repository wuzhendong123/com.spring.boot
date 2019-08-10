package com.spring.boot.config.ds.context;

import org.apache.ibatis.builder.MapperBuilderAssistant;
import org.apache.ibatis.session.Configuration;

/**
 * @program: com.spring.boot
 * @description:
 * @author: zhendong.wu
 * @create: 2019-05-29 17:24
 **/
public class GenMapperBuilderAssistant extends MapperBuilderAssistant {
    public GenMapperBuilderAssistant(Configuration configuration, String resource) {
        super(configuration, resource);
    }

    public String applyCurrentNamespace(String base, boolean isReference) {
        return base;
    }
}