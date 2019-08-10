package com.spring.boot.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.spring.boot.entity.base.BaseEntity;

/**
 * <p>
 * 角色和权限关系
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-05-28
 */
@TableName("sys_role_permissions_ref")
public class SysRolePermissionsRef extends BaseEntity<SysRolePermissionsRef> {

    private static final long serialVersionUID = 1L;

    private String status;
    /**
     * 角色code
     */
    @TableField("rule_code")
    private String ruleCode;
    /**
     * 权限code
     */
    @TableField("per_code")
    private String perCode;


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

    public String getPerCode() {
        return perCode;
    }

    public void setPerCode(String perCode) {
        this.perCode = perCode;
    }


    @Override
    public String toString() {
        return "SysRolePermissionsRef{" +
        "status=" + status +
        ", ruleCode=" + ruleCode +
        ", perCode=" + perCode +
        "}";
    }
}
