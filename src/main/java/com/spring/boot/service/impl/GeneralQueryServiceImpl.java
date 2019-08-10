package com.spring.boot.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.common.domain.Col;
import com.spring.boot.entity.QueryFunction;
import com.spring.boot.query.base.ParamQuery;
import com.spring.boot.service.IFunResultRefService;
import com.spring.boot.service.GeneralQueryService;
import com.spring.boot.service.IQueryFunctionService;
import com.spring.boot.service.TempBatchService;
import com.spring.boot.service.common.SqlCommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: com.spring.boot
 * @description:
 * @author: zhendong.wu
 * @create: 2019-04-25 18:49
 **/
@Service
public class GeneralQueryServiceImpl implements GeneralQueryService {
    @Autowired
    private SqlCommonService sqlCommonService;
    @Autowired
    private IQueryFunctionService queryFunctionService;
    @Autowired
    private IFunResultRefService funResultRefService;
    @Autowired
    private TempBatchService tempBatchService;
    @Override
    public Page generalFind(String code, Object map, Page pagePg) {
        pagePg=   sqlCommonService.selectPageByCode(code,pagePg,map);
        return pagePg;
    }

    @Override
    public Col[] findColByFunCtion(String code) {
        QueryFunction queryFunction=queryFunctionService.selectById(code);
        //ParamQuery[]   paramQuerys=queryFunctionService.expResultQuery(queryFunction.getExpress());
        Col[] cols= funResultRefService.bulid(queryFunction.getCode(),queryFunction.getExpress());
        return cols;
    }

    @Override
    public void bulid(QueryFunction queryFunction) {
        sqlCommonService.bulid(queryFunction.getExpress(),queryFunction.getCode());
    }

    /**
     *
     * @param request
     * @param code
     * @param map
     * @return
     */
    @Override
    public Object generalQueryObj(HttpServletRequest request, String code, Object map) {
        try {

            long  startTime=System.currentTimeMillis();
            //远程调用
            tempBatchService.createTempByRequest(request);

        } catch (Exception e) {
            log.error("generalQueryObj error code {}",code,e);
        }
        return map;
    }
    public Logger log = LoggerFactory.getLogger(getClass());
}
