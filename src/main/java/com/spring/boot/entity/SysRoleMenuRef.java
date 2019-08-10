package com.spring.boot.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.spring.boot.entity.base.BaseEntity;

/**
 * <p>
 * 角色和菜单关系
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-05-28
 */
@TableName("sys_role_menu_ref")
public class SysRoleMenuRef extends BaseEntity<SysRoleMenuRef> {

    private static final long serialVersionUID = 1L;

    private String status;
    /**
     * 角色名称
     */
    @TableField("rule_code")
    private String ruleCode;
    /**
     * 菜单code
     */
    @TableField("menu_code")
    private String menuCode;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRuleCode() {
        return ruleCode;
    }

    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }


    @Override
    public String toString() {
        return "SysRoleMenuRef{" +
        "status=" + status +
        ", ruleCode=" + ruleCode +
        ", menuCode=" + menuCode +
        "}";
    }
}
