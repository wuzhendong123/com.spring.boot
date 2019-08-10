package com.spring.boot.entity;

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
@TableName("sys_role")
public class SysRole extends BaseEntity<SysRole> {

    private static final long serialVersionUID = 1L;

    private String status;
    /**
     * 角色名称
     */
    private String name;


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


    @Override
    public String toString() {
        return "SysRole{" +
        "status=" + status +
        ", name=" + name +
        "}";
    }
}
