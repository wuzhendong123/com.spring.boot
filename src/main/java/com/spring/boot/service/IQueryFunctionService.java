package com.spring.boot.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.QueryFunction;
import com.baomidou.mybatisplus.service.IService;
import com.spring.boot.query.base.ParamQuery;

/**
 * <p>
 * 查询函数执行表达式 服务类
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-04-20
 */
public interface IQueryFunctionService extends IService<QueryFunction> {

    Page<QueryFunction> selectPageByQueryFunction(Page<QueryFunction> pagePg, QueryFunction queryFunction);

    ParamQuery[] expAnalysisQuery(String exp);

    ParamQuery[] expResultQuery(String exp);
}
