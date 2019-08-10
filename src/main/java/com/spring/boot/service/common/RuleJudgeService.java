package com.spring.boot.service.common;

import com.spring.boot.entity.FunctionRuleRef;
import com.spring.boot.entity.ReturnResultRuleRef;
import com.spring.boot.entity.Rule;
import com.spring.boot.enums.StatusEnum;
import com.spring.boot.service.IFunctionRuleRefService;
import com.spring.boot.service.IReturnResultRuleRefService;
import com.spring.boot.service.IRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

/**
 * @program: com.spring.boot
 * @description:
 * @author: zhendong.wu
 * @create: 2019-05-01 17:55
 **/
@Component
public class RuleJudgeService {
    @Resource
    private IRuleService ruleService;
    @Resource
    private IFunctionRuleRefService functionRuleRefService;
    @Resource
    private IReturnResultRuleRefService returnResultRuleRefService;

    public List<String> judgeResult(String routeCode, EvaluationContext evaluationContext){
        List<String> lis=new LinkedList<>();
        List<String> liArrays=new LinkedList<>();
        List<Rule> rules= ruleService.selectParentByRouteCode(routeCode);

        liArrays= doJudgeResult(rules,evaluationContext,StatusEnum.TRUE.name());
        lis.addAll(liArrays);
        return lis;
    }

    private List<String> doJudgeResult(List<Rule> rules, EvaluationContext evaluationContext, String status) {
        List<String> liArrays=new LinkedList<>();
        if(rules!=null&&rules.size()>0){
            rules.stream().forEach(new Consumer<Rule>() {
                @Override
                public void accept(Rule rule) {
                    List results=ruleJudge(rule,evaluationContext,status);
                    if(results!=null&&!results.isEmpty()){
                        liArrays.addAll( results);
                    }

                }
            });
        }
        return liArrays;
    }

    public List<String> ruleJudge(Rule rule, EvaluationContext evaluationContext,String status) {
        List<FunctionRuleRef> lis= functionRuleRefService.selectByRuleCode(rule.getCode(),status);
        if(lis==null||lis.isEmpty()){
            return getResult(rule, evaluationContext, status);
        }else{
            int size=lis.size();
            BitSet bi=new BitSet(size);
            for(int i=0;i<size;i++){
                String   express=  lis.get(i).getExpress();
                Expression expression = getExpression(express);
                if(expression.getValue(evaluationContext,Boolean.class)){
                    bi.set(i);
                }
            }
            if( bi.cardinality()>=size){
                return getResult(rule, evaluationContext, status);
            }


        }
        return null;
    }



    private List<String> getResult(Rule rule,EvaluationContext evaluationContext,String status) {
        List<Rule> childRules=this.ruleService.findByParentRuleCode(rule.getCode(),status);
        if(childRules!=null&&!childRules.isEmpty()){
            return doJudgeResult(childRules,evaluationContext,status);
        }else{
            List<String> result=getResult(rule);
            return result;
        }
    }

    public List<String> getResult(Rule rule) {
        List<String> lis=new LinkedList<>();
        List<ReturnResultRuleRef> returnResultRuleRefs=returnResultRuleRefService.selectByRuleCode(rule.getCode());
        returnResultRuleRefs.forEach(new Consumer<ReturnResultRuleRef>() {
            @Override
            public void accept(ReturnResultRuleRef returnResultRuleRef) {
                lis.add(returnResultRuleRef.getValue());
            }
        });
        return lis;

    }

    private Expression getExpression(String express){
        Expression expression=  mapExp.get( express);
        if(expression==null){
            expression=  parser.parseExpression(express);
            mapExp.put(express,expression);
        }
        return expression;
    }
    SpelParserConfiguration config = new SpelParserConfiguration(SpelCompilerMode.IMMEDIATE,null);
    ExpressionParser parser = new SpelExpressionParser(config);
    Map<String,Expression> mapExp=new ConcurrentHashMap<>();


}
