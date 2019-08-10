package com.spring.boot.service;
import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.FunctionRouteTemple;
import com.baomidou.mybatisplus.service.IService;
import com.spring.boot.query.base.ParamMapQuery;

/**
 * <p>
 * 函数模板定义 服务类
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-05-04
 */
public interface IFunctionRouteTempleService extends IService<FunctionRouteTemple> {
        Page<FunctionRouteTemple> selectPageByFunctionRouteTemple(Page<FunctionRouteTemple> pagePg, FunctionRouteTemple obj);

        String buildExpress(String express, ParamMapQuery[] param);
}
