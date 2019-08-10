package com.spring.boot.query.respone;

/**
 * @program: com.spring.boot
 * @description:
 * @author: zhendong.wu
 * @create: 2019-05-04 22:08
 **/
public class RuleBean {
    private String name;
    private String routeCode;
    private String routeName;
    private String successActionType;
    private String code;
    private String parentRuleCode;
    private Integer level;
    private String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getSuccessActionType() {
        return successActionType;
    }

    public void setSuccessActionType(String successActionType) {
        this.successActionType = successActionType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
