package com.spring.boot.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.Route;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 规则组 服务类
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-04-23
 */
public interface IRouteService extends IService<Route> {

    Page<Route> selectPageByRoute(Page<Route> pagePg, Route obj);
}
