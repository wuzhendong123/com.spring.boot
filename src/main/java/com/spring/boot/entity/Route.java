package com.spring.boot.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.spring.boot.entity.base.BaseEntity;

import java.io.Serializable;

/**
 * <p>
 * 规则组
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-04-23
 */
public class Route extends BaseEntity<Route> {

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
     * 使用数据版本
     */
    @TableField("data_version")
    private Integer dataVersion;


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

    public Integer getDataVersion() {
        return dataVersion;
    }

    public void setDataVersion(Integer dataVersion) {
        this.dataVersion = dataVersion;
    }



    @Override
    public String toString() {
        return "Route{" +
        "name=" + name +
        ", status=" + status +
        ", dataVersion=" + dataVersion +
        "}";
    }
}
