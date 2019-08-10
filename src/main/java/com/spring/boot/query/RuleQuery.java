package com.spring.boot.query;

import com.spring.boot.query.base.BaseQuery;

/**
 * @program: com.spring.boot
 * @description:
 * @author: zhendong.wu
 * @create: 2019-05-04 22:06
 **/
public class RuleQuery extends BaseQuery {
    /**
     * 规则名称
     */
    private String name;
    /**
     * 状态
     */
    private String status;
    private String routeName;
    private String routeCode;


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

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }
}
