package com.spring.boot.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.spring.boot.entity.base.BaseEntity;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-05-28
 */
@TableName("sys_operator_role_ref")
public class SysOperatorRoleRef extends BaseEntity<SysOperatorRoleRef> {

    private static final long serialVersionUID = 1L;

    private String status;
    /**
     * 操作员code
     */
    @TableField("oper_code")
    private String operCode;
    /**
     * 角色code
     */
    @TableField("role_code")
    private String roleCode;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOperCode() {
        return operCode;
    }

    public void setOperCode(String operCode) {
        this.operCode = operCode;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }


    @Override
    public String toString() {
        return "SysOperatorRoleRef{" +
        "status=" + status +
        ", operCode=" + operCode +
        ", roleCode=" + roleCode +
        "}";
    }
}
