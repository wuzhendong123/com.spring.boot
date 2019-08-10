package com.spring.boot.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.common.domain.Ztree;
import com.spring.boot.entity.Rule;
import com.baomidou.mybatisplus.service.IService;
import com.spring.boot.query.RuleQuery;
import com.spring.boot.query.respone.RuleBean;
import org.springframework.expression.EvaluationContext;

import java.util.List;

/**
 * <p>
 * 定义规则(组)执行一组表达式 服务类
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-04-30
 */
public interface IRuleService extends IService<Rule> {
        Page<Rule> selectPageByRule(Page<Rule> pagePg, Rule obj);

        List<Rule> selectParentByRouteCode(String routeCode);

        List<Ztree> findByRouteAllTree(String parentRouteCode);

        List<Rule> findByParentRuleCode(String parentRuleCode,String status);

     Page<RuleBean> selectPageByRuleQuery(Page<RuleBean> pagePg, RuleQuery ruleQuery);
}
