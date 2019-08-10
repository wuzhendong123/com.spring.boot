package com.spring.boot.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.Route;
import com.spring.boot.mapper.RouteMapper;
import com.spring.boot.service.IRouteService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 规则组 服务实现类
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-04-23
 */
@Service
public class RouteServiceImpl extends ServiceImpl<RouteMapper, Route> implements IRouteService {

    @Override
    public Page<Route> selectPageByRoute(Page<Route> pagePg, Route obj) {
        pagePg.setRecords( this.baseMapper.selectPageByRoute(pagePg,obj));
        return pagePg;
    }
}
