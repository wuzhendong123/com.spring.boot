package com.spring.boot.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.spring.boot.entity.base.BaseEntity;

/**
 * <p>
 * 返回结果规则关联
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-05-04
 */
@TableName("return_result_rule_ref")
public class ReturnResultRuleRef extends BaseEntity<ReturnResultRuleRef> {

    private static final long serialVersionUID = 1L;

    private String status;
    /**
     * 中文描述
     */
    private String text;
    /**
     * 值
     */
    private String value;
    /**
     * 规则code
     */
    @TableField("rule_code")
    private String ruleCode;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRuleCode() {
        return ruleCode;
    }

    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
    }


    @Override
    public String toString() {
        return "ReturnResultRuleRef{" +
        "status=" + status +
        ", text=" + text +
        ", value=" + value +
        ", ruleCode=" + ruleCode +
        "}";
    }
}
