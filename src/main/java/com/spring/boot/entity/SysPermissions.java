package com.spring.boot.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.spring.boot.entity.base.BaseEntity;

/**
 * <p>
 * 权限校验
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-05-28
 */
@TableName("sys_permissions")
public class SysPermissions extends BaseEntity<SysPermissions> {

    private static final long serialVersionUID = 1L;

    private String status;
    /**
     * 权限名称
     */
    private String name;
    /**
     * 权限编码
     */
    @TableField("permissions_mark")
    private String permissionsMark;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermissionsMark() {
        return permissionsMark;
    }

    public void setPermissionsMark(String permissionsMark) {
        this.permissionsMark = permissionsMark;
    }


    @Override
    public String toString() {
        return "SysPermissions{" +
        "status=" + status +
        ", name=" + name +
        ", permissionsMark=" + permissionsMark +
        "}";
    }
}
