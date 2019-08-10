package com.spring.boot.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.spring.boot.entity.base.BaseEntity;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-01-26
 */
public class Menu extends BaseEntity<Menu> {

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

    private String url;

    private String icon;

    @TableField(exist = false)
    private List<Menu> childMenus;


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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<Menu> getChildMenus() {
        return childMenus;
    }

    public void setChildMenus(List<Menu> childMenus) {
        this.childMenus = childMenus;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "name=" + name +
                ", level=" + level +
                ", path=" + path +
                ", status=" + status +
                ", parentCode=" + parentCode +
                ", url=" + url +
                ", icon=" + icon +
                "}";
    }
}
