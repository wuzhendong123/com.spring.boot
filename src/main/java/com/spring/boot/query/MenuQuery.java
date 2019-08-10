package com.spring.boot.query;

import com.spring.boot.query.base.BaseQuery;

import java.io.Serializable;

/**
 * @program: com.spring.boot
 * @description: 菜单查询bean
 * @author: zhendong.wu
 * @create: 2018-09-09 17:23
 **/
public class MenuQuery extends BaseQuery {
    private static final long serialVersionUID = 1L;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单级别
     */
    private Integer level;

    /**
     * 记录到顶层路径
     */
    private String path;

    /**
     * 状态
     */
    private String status;
    private String parentCode;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    @Override
    public String toString() {
        return "MenuQuery{" +
                "name=" + name +
                ", level=" + level +
                ", path=" + path +
                ", status=" + status +
                "}";
    }
}
