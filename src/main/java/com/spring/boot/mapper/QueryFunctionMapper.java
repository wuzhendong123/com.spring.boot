package com.spring.boot.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.QueryFunction;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 查询函数执行表达式 Mapper 接口
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-04-20
 */
public interface QueryFunctionMapper extends BaseMapper<QueryFunction> {

    List<QueryFunction> selectPageByQueryFunction(Page<QueryFunction> pagePg, QueryFunction queryFunction);
}
