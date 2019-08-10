package com.spring.boot.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.Rule;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.spring.boot.query.RuleQuery;
import com.spring.boot.query.respone.RuleBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 定义规则(组)执行一组表达式 Mapper 接口
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-04-30
 */
public interface RuleMapper extends BaseMapper<Rule> {
    List<Rule> selectPageByRule(Page<Rule> pagePg, Rule obj);

    List<Rule> selectParentByRouteCode(@Param("routeCode") String routeCode);


    List<Rule> findByParentRuleCode(@Param("parentRuleCode") String parentRuleCode, @Param("status") String status);

    List<RuleBean> selectPageByRuleQuery(Page<RuleBean> pagePg, RuleQuery ruleQuery);
}
