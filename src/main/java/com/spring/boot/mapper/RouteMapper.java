package com.spring.boot.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.Route;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 规则组 Mapper 接口
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-04-23
 */
public interface RouteMapper extends BaseMapper<Route> {

    List<Route> selectPageByRoute(Page<Route> pagePg, Route obj);
}
