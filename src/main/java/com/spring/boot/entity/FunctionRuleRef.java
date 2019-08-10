package com.spring.boot.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.spring.boot.entity.base.BaseEntity;

/**
 * <p>
 * 函数规则引用
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-05-01
 */
@TableName("function_rule_ref")
public class FunctionRuleRef extends BaseEntity<FunctionRuleRef> {

    private static final long serialVersionUID = 1L;

    private String status;
    /**
     * 函数模板code
     */
    @TableField("fun_temple_code")
    private String funTempleCode;
    /**
     * 规则code
     */
    @TableField("rule_code")
    private String ruleCode;
    /**
     * 内容展示
     */
    private String html;
    /**
     * 具体表达式
     */
    private String express;
    /**
     * [{key:key,value:value}]
     */
    @TableField("param_array")
    private String paramArray;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFunTempleCode() {
        return funTempleCode;
    }

    public void setFunTempleCode(String funTempleCode) {
        this.funTempleCode = funTempleCode;
    }

    public String getRuleCode() {
        return ruleCode;
    }

    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getExpress() {
        return express;
    }

    public void setExpress(String express) {
        this.express = express;
    }

    public String getParamArray() {
        return paramArray;
    }

    public void setParamArray(String paramArray) {
        this.paramArray = paramArray;
    }


    @Override
    public String toString() {
        return "FunctionRuleRef{" +
        "status=" + status +
        ", funTempleCode=" + funTempleCode +
        ", ruleCode=" + ruleCode +
        ", html=" + html +
        ", express=" + express +
        ", paramArray=" + paramArray +
        "}";
    }
}
