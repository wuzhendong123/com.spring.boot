package com.spring.boot.mapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.FunctionRouteTemple;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 函数模板定义 Mapper 接口
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-05-04
 */
public interface FunctionRouteTempleMapper extends BaseMapper<FunctionRouteTemple> {
        List<FunctionRouteTemple> selectPageByFunctionRouteTemple(Page<FunctionRouteTemple> pagePg, FunctionRouteTemple obj);
}
