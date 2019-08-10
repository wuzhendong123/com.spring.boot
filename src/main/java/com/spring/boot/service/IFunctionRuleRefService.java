package com.spring.boot.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.FunctionRuleRef;
import com.baomidou.mybatisplus.service.IService;
import com.spring.boot.query.FunctionRuleRefQuery;
import com.spring.boot.query.request.FunctionRuleRefAggreRequest;
import com.spring.boot.query.respone.FunRuleRefBean;

import java.util.List;

/**
 * <p>
 * 函数规则引用 服务类
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-04-30
 */
public interface IFunctionRuleRefService extends IService<FunctionRuleRef> {
        Page<FunctionRuleRef> selectPageByFunctionRuleRef(Page<FunctionRuleRef> pagePg, FunctionRuleRef obj);

    List<FunctionRuleRef> buld(String ruleCode, FunctionRuleRefAggreRequest[] functionRuleRefAggreRequests);

    List<FunctionRuleRef> selectByRuleCode(String ruleCode, String status);

    Page<FunRuleRefBean> selectPageByFunRuleRefBean(Page<FunRuleRefBean> pagePg, FunctionRuleRefQuery functionRuleRefQuery);

    List<FunctionRuleRefAggreRequest> buildByfunctionRuleRef(List<FunctionRuleRef> functionRuleRefs);

    void createUpdateBatch(String code, List<FunctionRuleRef> functionRuleRefs);
}
