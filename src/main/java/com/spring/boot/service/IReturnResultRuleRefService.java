package com.spring.boot.service;
import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.ReturnResultRuleRef;
import com.baomidou.mybatisplus.service.IService;
import com.spring.boot.query.request.ReturnResultAggRequet;

import java.util.List;

/**
 * <p>
 * 返回结果规则关联 服务类
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-05-04
 */
public interface IReturnResultRuleRefService extends IService<ReturnResultRuleRef> {
        Page<ReturnResultRuleRef> selectPageByReturnResultRuleRef(Page<ReturnResultRuleRef> pagePg, ReturnResultRuleRef obj);

        List<ReturnResultRuleRef> bulid(String code, ReturnResultAggRequet[] returnResultAggRequet);

    List<ReturnResultRuleRef> selectByRuleCode(String ruleCode,String status);
    List<ReturnResultRuleRef> selectByRuleCode(String ruleCode);

    List<ReturnResultAggRequet> buildByReturnResultRuleRef(List<ReturnResultRuleRef> returnResultRuleRefs);

    void createUpdateBatch(String code, List<ReturnResultRuleRef> returnResultRuleRefs);
}
