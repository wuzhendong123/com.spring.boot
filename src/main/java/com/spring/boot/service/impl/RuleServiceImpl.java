package com.spring.boot.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.common.domain.Ztree;
import com.spring.boot.entity.FunctionRuleRef;
import com.spring.boot.entity.Rule;
import com.spring.boot.enums.StatusEnum;
import com.spring.boot.mapper.RuleMapper;
import com.spring.boot.query.RuleQuery;
import com.spring.boot.query.respone.RuleBean;
import com.spring.boot.service.IFunParamHtmlRefService;
import com.spring.boot.service.IFunctionRuleRefService;
import com.spring.boot.service.IRuleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

/**
 * <p>
 * 定义规则(组)执行一组表达式 服务实现类
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-04-30
 */
@Service
public class RuleServiceImpl extends ServiceImpl<RuleMapper, Rule> implements IRuleService {
        @Autowired
        private IFunctionRuleRefService functionRuleRefService;

        @Override
        public Page<RuleBean> selectPageByRuleQuery(Page<RuleBean> pagePg, RuleQuery ruleQuery) {
                pagePg.setRecords(baseMapper.selectPageByRuleQuery(pagePg,ruleQuery));
                return pagePg;
        }
        @Override
        public Page<Rule> selectPageByRule(Page<Rule> pagePg, Rule obj) {
                pagePg.setRecords(this.baseMapper.selectPageByRule(pagePg, obj));
                return pagePg;
        }

        @Override
        public List<Rule> selectParentByRouteCode(String routeCode) {
                return this.baseMapper.selectParentByRouteCode(routeCode);
        }

        @Override
        public List<Ztree> findByRouteAllTree(String parentRouteCode) {
                List<Rule> rules=this.baseMapper.findByParentRuleCode(parentRouteCode,null);
                return initZtree(rules);
         }

        @Override
        public List<Rule> findByParentRuleCode(String parentRuleCode,String status) {
                return this.baseMapper.findByParentRuleCode(parentRuleCode,status);
        }


        public List<Ztree> initZtree( List<Rule> rules){

                List<Ztree> ztrees = new ArrayList<Ztree>();
                for (Rule rule : rules)
                {
                        Ztree ztree = new Ztree();
                        ztree.setId(rule.getCode());
                        ztree.setpId(rule.getParentRuleCode());
                        ztree.setName(rule.getName());
                        ztree.setTitle(rule.getName());

                        ztrees.add(ztree);
                }
                return ztrees;
        }


}
