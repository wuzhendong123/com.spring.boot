package com.spring.boot.config.fun.spring.registrar;

import com.spring.boot.config.fun.spring.registrar.annotaion.FunRouteScan;
import com.spring.boot.config.fun.spring.scanner.ClassPathFunRouteScanner;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: com.spring.boot
 * @description:
 * @author: zhendong.wu
 * @create: 2019-05-01 15:36
 **/
public class FunRouteScannerRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        AnnotationAttributes annoAttrs = AnnotationAttributes.fromMap(annotationMetadata.getAnnotationAttributes(FunRouteScan.class.getName()));

        ClassPathFunRouteScanner classPathFunRouteScanner=new ClassPathFunRouteScanner(beanDefinitionRegistry);
        List<String> basePackages = new ArrayList();
        String[] var10  = annoAttrs.getStringArray("basePackages");
        int var11 = var10.length;

        for(int var12 = 0; var12 < var11; ++var12) {
            String  pkg = var10[var12];
            if (StringUtils.hasText(pkg)) {
                basePackages.add(pkg);
            }
        }
        classPathFunRouteScanner.resetFilters();
        classPathFunRouteScanner.scan(basePackages.toArray(new String[basePackages.size()]));

    }
}
