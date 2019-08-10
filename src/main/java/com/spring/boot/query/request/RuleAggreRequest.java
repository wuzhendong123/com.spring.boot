package com.spring.boot.query.request;

import com.spring.boot.entity.Rule;

/**
 * @program: com.spring.boot
 * @description:
 * @author: zhendong.wu
 * @create: 2019-05-01 12:32
 **/
public class RuleAggreRequest {
    private Rule rule;
    private FunctionRuleRefAggreRequest[] funRouAggRequet;

    private ReturnResultAggRequet[] returnResultAggRequet;

    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    public FunctionRuleRefAggreRequest[] getFunRouAggRequet() {
        return funRouAggRequet;
    }

    public void setFunRouAggRequet(FunctionRuleRefAggreRequest[] funRouAggRequet) {
        this.funRouAggRequet = funRouAggRequet;
    }

    public ReturnResultAggRequet[] getReturnResultAggRequet() {
        return returnResultAggRequet;
    }

    public void setReturnResultAggRequet(ReturnResultAggRequet[] returnResultAggRequet) {
        this.returnResultAggRequet = returnResultAggRequet;
    }
}
