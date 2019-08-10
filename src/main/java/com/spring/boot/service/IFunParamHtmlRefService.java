package com.spring.boot.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.FunParamHtmlRef;
import com.baomidou.mybatisplus.service.IService;
import com.spring.boot.query.FunParamHtmlRefAggreQuery;

import java.util.List;

/**
 * <p>
 * 函数参数html关系 服务类
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-04-20
 */
public interface IFunParamHtmlRefService extends IService<FunParamHtmlRef> {

    Page<FunParamHtmlRef> selectPageByFunParamHtmlRef(Page<FunParamHtmlRef> pagePg, FunParamHtmlRef obj);

    List<FunParamHtmlRef> build(FunParamHtmlRefAggreQuery funParamHtmlRefAggreQuery);

    List<FunParamHtmlRef> selectByFunCode(String code);
}
