package com.spring.boot.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring.boot.entity.FunctionRouteTemple;
import com.spring.boot.entity.FunctionRuleRef;
import com.spring.boot.enums.StatusEnum;
import com.spring.boot.mapper.FunctionRuleRefMapper;
import com.spring.boot.query.FunctionRuleRefQuery;
import com.spring.boot.query.base.ParamMapQuery;
import com.spring.boot.query.request.FunctionRuleRefAggreRequest;
import com.spring.boot.query.respone.FunRuleRefBean;
import com.spring.boot.service.IFunctionRouteTempleService;
import com.spring.boot.service.IFunctionRuleRefService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.spring.boot.util.BeanUtil;
import com.spring.boot.util.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;

/**
 * <p>
 * 函数规则引用 服务实现类
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-04-30
 */
@Service
public class FunctionRuleRefServiceImpl extends ServiceImpl<FunctionRuleRefMapper, FunctionRuleRef> implements IFunctionRuleRefService {
    @Autowired
    private IFunctionRouteTempleService functionRouteTempleService;
    @Override
    public Page<FunctionRuleRef> selectPageByFunctionRuleRef(Page<FunctionRuleRef> pagePg, FunctionRuleRef obj) {
        pagePg.setRecords(this.baseMapper.selectPageByFunctionRuleRef(pagePg, obj));
        return pagePg;
    }

    @Override
    public List<FunctionRuleRef> buld(String ruleCode,FunctionRuleRefAggreRequest[] functionRuleRefAggreRequests) {
        List<FunctionRuleRef> funParamHtmlRefs=new ArrayList<>();
        Arrays.stream(functionRuleRefAggreRequests).forEach(new Consumer<FunctionRuleRefAggreRequest>() {
            @Override
            public void accept(FunctionRuleRefAggreRequest functionRuleRefAggreRequest) {
                FunctionRouteTemple functionRouteTemple = functionRouteTempleService.selectById(functionRuleRefAggreRequest.getFunTempleCode());
                FunctionRuleRef functionRuleRef=new FunctionRuleRef();
                functionRuleRef.setCode(functionRuleRefAggreRequest.getCode());
                if(functionRuleRefAggreRequest.getCode()!=null&&!"".equals(functionRuleRefAggreRequest.getCode())){

                }else{
                    functionRuleRef.setHtml(functionRuleRefAggreRequest.getHtml());
                    functionRuleRef.setRuleCode(ruleCode);
                    functionRuleRef.setStatus(StatusEnum.TRUE.name());
                    functionRuleRef.setFunTempleCode(functionRuleRefAggreRequest.getFunTempleCode());
                    String express= functionRouteTempleService.buildExpress(functionRouteTemple.getExpress(),functionRuleRefAggreRequest.getParam());
                    functionRuleRef.setExpress(express);
                    try {
                        functionRuleRef.setParamArray(JSONUtil.writeValueAsString(functionRuleRefAggreRequest.getParam()));
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                }
                funParamHtmlRefs.add(functionRuleRef);


            }
        });
        return funParamHtmlRefs;
    }

    @Override
    public List<FunctionRuleRef> selectByRuleCode(String ruleCode, String status) {
        return baseMapper.selectByRuleCode(ruleCode,status);
    }

    @Override
    public Page<FunRuleRefBean> selectPageByFunRuleRefBean(Page<FunRuleRefBean> pagePg, FunctionRuleRefQuery functionRuleRefQuery) {
        pagePg.setRecords(this.baseMapper.selectPageByFunRuleRefBean(pagePg, functionRuleRefQuery));
        return pagePg;
    }

    @Override
    public List<FunctionRuleRefAggreRequest> buildByfunctionRuleRef(List<FunctionRuleRef> functionRuleRefs) {
        List<FunctionRuleRefAggreRequest> functionRuleRefAggreRequests=new ArrayList<>();
        functionRuleRefs.stream().forEach(new Consumer<FunctionRuleRef>() {
            @Override
            public void accept(FunctionRuleRef functionRuleRef) {
                FunctionRuleRefAggreRequest functionRuleRefAggreRequest=new FunctionRuleRefAggreRequest();
                functionRuleRefAggreRequest.setHtml(functionRuleRef.getHtml());
                functionRuleRefAggreRequest.setFunTempleCode(functionRuleRef.getFunTempleCode());
                functionRuleRefAggreRequest.setCode(functionRuleRef.getCode());
                try {
                    functionRuleRefAggreRequest.setParam(JSONUtil.readValue(functionRuleRef.getParamArray(),ParamMapQuery[].class));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                functionRuleRefAggreRequests.add(functionRuleRefAggreRequest);
            }
        });
        return functionRuleRefAggreRequests;
    }

    @Override
    public void createUpdateBatch(String ruleCode, List<FunctionRuleRef> functionRuleRefs) {
        List<FunctionRuleRef> functionRuleRefDBs=selectByRuleCode(ruleCode,StatusEnum.TRUE.name());
        List<FunctionRuleRef> lisCreate=new ArrayList<>();
        List<FunctionRuleRef> lisUpdate=new ArrayList<>();
        Map<String,FunctionRuleRef> mapUpdate=new HashMap<>();
        if(functionRuleRefs!=null&&!functionRuleRefs.isEmpty()){

            functionRuleRefs.forEach(new Consumer<FunctionRuleRef>() {
                @Override
                public void accept(FunctionRuleRef functionRuleRef) {
                    if(functionRuleRef.getCode()==null||"".equals(functionRuleRef.getCode())){
                        lisCreate.add(functionRuleRef);
                    }else{
                        mapUpdate.put(functionRuleRef.getCode(),functionRuleRef);
                    }
                }
            });
        }
        if(functionRuleRefDBs!=null&&!functionRuleRefDBs.isEmpty()){
            functionRuleRefDBs.forEach(new Consumer<FunctionRuleRef>() {
                @Override
                public void accept(FunctionRuleRef functionRuleRef) {
                    FunctionRuleRef functionRuleRefTemp=  mapUpdate.get(functionRuleRef.getCode());
                    if(functionRuleRefTemp!=null){
                       // BeanUtil.copyPropertiesIgnoreNull();
                    }else{
                        functionRuleRef.setStatus(StatusEnum.FALSE.name());
                        lisUpdate.add(functionRuleRef);
                    }

                }
            });
        }
        if(!lisCreate.isEmpty()){
            insertBatch(lisCreate);
        }

        if(!lisUpdate.isEmpty()){
            updateBatchById(lisUpdate);
        }

    }
}
