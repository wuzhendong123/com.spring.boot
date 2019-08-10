package com.spring.boot.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.common.domain.Col;
import com.spring.boot.entity.QueryFunction;

import javax.servlet.http.HttpServletRequest;

public interface GeneralQueryService {
    Page generalFind(String code, Object map, Page pagePg);

    Col[] findColByFunCtion(String code);

    void bulid(QueryFunction queryFunction);

    Object generalQueryObj(HttpServletRequest request, String code, Object map);
}
