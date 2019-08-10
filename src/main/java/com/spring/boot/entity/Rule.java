package com.spring.boot.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.spring.boot.entity.base.BaseEntity;

import java.io.Serializable;

/**
 * <p>
 * 定义规则(组)执行一组表达式
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-04-23
 */
public class Rule extends BaseEntity<Rule> {

    private static final long serialVersionUID = 1L;

    /**
     * 规则名称
     */
    private String name;
    /**
     * 状态
     */
    private String status;
    /**
     * 路由code
     */
    @TableField("route_code")
    private String routeCode;

    /**
     * 成功动作类型(方法,值)
     */
    @TableField("success_action_type")
    private String successActionType;
    /**
     * 使用数据版本
     */
    @TableField("data_version")
    private Integer dataVersion;
    /**
     * 顺序
     */
    private Integer level;
    /**
     * 父类规则
     */
    @TableField("parent_rule_code")
    private String parentRuleCode;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }

    public String getSuccessActionType() {
        return successActionType;
    }

    public void setSuccessActionType(String successActionType) {
        this.successActionType = successActionType;
    }

    public Integer getDataVersion() {
        return dataVersion;
    }

    public void setDataVersion(Integer dataVersion) {
        this.dataVersion = dataVersion;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getParentRuleCode() {
        return parentRuleCode;
    }

    public void setParentRuleCode(String parentRuleCode) {
        this.parentRuleCode = parentRuleCode;
    }


    @Override
    public String toString() {
        return "Rule{" +
        "name=" + name +
        ", status=" + status +
        ", routeCode=" + routeCode +
        ", successActionType=" + successActionType +
        ", dataVersion=" + dataVersion +
        ", level=" + level +
        ", parentRuleCode=" + parentRuleCode +
        "}";
    }
}
