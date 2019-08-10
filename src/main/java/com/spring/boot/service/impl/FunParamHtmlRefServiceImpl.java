package com.spring.boot.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.FunParamHtmlRef;
import com.spring.boot.entity.ParamHtmlTemple;
import com.spring.boot.mapper.FunParamHtmlRefMapper;
import com.spring.boot.query.FunParamHtmlRefAggreQuery;
import com.spring.boot.query.FunParamHtmlRefQuery;
import com.spring.boot.service.IFunParamHtmlRefService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.spring.boot.service.IParamHtmlTempleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * <p>
 * 函数参数html关系 服务实现类
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-04-20
 */
@Service
public class FunParamHtmlRefServiceImpl extends ServiceImpl<FunParamHtmlRefMapper, FunParamHtmlRef> implements IFunParamHtmlRefService {
    @Autowired
    private IParamHtmlTempleService paramHtmlTempleService;

    @Override
    public Page<FunParamHtmlRef> selectPageByFunParamHtmlRef(Page<FunParamHtmlRef> pagePg, FunParamHtmlRef obj) {
        return pagePg.setRecords(baseMapper.selectPageByFunParamHtmlRef(pagePg,obj));
    }
    @Override
    public List<FunParamHtmlRef> selectByFunCode(String code) {
        return baseMapper.selectByFunCode(code);
    }
    @Override
    public List<FunParamHtmlRef> build(FunParamHtmlRefAggreQuery funParamHtmlRefAggreQuery) {
        List<FunParamHtmlRef> funParamHtmlRefs=new ArrayList<>();
        FunParamHtmlRefQuery[] funParamHtmlRefQuery=funParamHtmlRefAggreQuery.getFunParam();
        Arrays.stream(funParamHtmlRefQuery).forEach(new Consumer<FunParamHtmlRefQuery>() {
            @Override
            public void accept(FunParamHtmlRefQuery funParamHtmlRefQuery) {
                FunParamHtmlRef funParamHtmlRef=new FunParamHtmlRef();
                funParamHtmlRef.setQueryCode(funParamHtmlRefAggreQuery.getQueryCode());
                funParamHtmlRef.setParamHtmlCode(funParamHtmlRefQuery.getParamHtmlCode());
                funParamHtmlRef.setParamExp(funParamHtmlRefQuery.getParamExp());
                funParamHtmlRef.setParamKey(funParamHtmlRefQuery.getParamKey());
                funParamHtmlRef.setCode(funParamHtmlRefQuery.getCode());
                ParamHtmlTemple paramHtmlTemple=paramHtmlTempleService.selectById(funParamHtmlRefQuery.getParamHtmlCode());
                String html=paramHtmlTempleService.bulidHtml(paramHtmlTemple.getHtml(),funParamHtmlRefQuery.getParamMapQuery());
                funParamHtmlRef.setHtml(html);
                funParamHtmlRef.setStatus(funParamHtmlRefQuery.getStatus());
                funParamHtmlRefs.add(funParamHtmlRef);
            }
        });


        return funParamHtmlRefs;
    }


}
