package com.spring.boot.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.FunctionRouteTemple;
import com.spring.boot.mapper.FunctionRouteTempleMapper;
import com.spring.boot.query.base.ParamMapQuery;
import com.spring.boot.service.IFunctionRouteTempleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * 函数模板定义 服务实现类
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-05-04
 */
@Service
public class FunctionRouteTempleServiceImpl extends ServiceImpl<FunctionRouteTempleMapper, FunctionRouteTemple> implements IFunctionRouteTempleService {
    static String regex = "\\$\\{(.+?)\\}";
    Pattern pattern = Pattern.compile(regex);
    @Override
    public Page<FunctionRouteTemple> selectPageByFunctionRouteTemple(Page<FunctionRouteTemple> pagePg, FunctionRouteTemple obj) {
        pagePg.setRecords(this.baseMapper.selectPageByFunctionRouteTemple(pagePg, obj));
        return pagePg;
    }

    @Override
    public String buildExpress(String express, ParamMapQuery[] param) {

        Matcher matcher = pattern.matcher(express);
        Map<String, String> map = new HashMap<>();
        for (ParamMapQuery pkq : param) {
            map.put(pkq.getKey(), pkq.getValue());
        }
        while (matcher.find()) {
            express = express.replace(matcher.group(0), String.format("'%s'", map.get(matcher.group(1))))
            ;
        }
        return express;
    }
}
