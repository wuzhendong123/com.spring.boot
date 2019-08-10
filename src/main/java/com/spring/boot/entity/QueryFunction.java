package com.spring.boot.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.spring.boot.entity.base.BaseEntity;

import java.io.Serializable;

/**
 * <p>
 * 查询函数执行表达式
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-04-20
 */
@TableName("query_function")
public class QueryFunction extends BaseEntity<QueryFunction> {

    private static final long serialVersionUID = 1L;

    /**
     * 函数名称
     */
    private String name;
    /**
     * 表达式
     */
    private String express;
    /**
     * 类型(sql,接口)
     */
    private String type;
    private String status;
    /**
     * 使用数据版本
     */
    @TableField("data_version")
    private Integer dataVersion;
    /**
     * 查询参数
     */
    @TableField("query_name")
    private String queryName;
    /**
     * 结果列表
     */
    @TableField("result_name")
    private String resultName;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpress() {
        return express;
    }

    public void setExpress(String express) {
        this.express = express;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getQueryName() {
        return queryName;
    }

    public void setQueryName(String queryName) {
        this.queryName = queryName;
    }

    public String getResultName() {
        return resultName;
    }

    public void setResultName(String resultName) {
        this.resultName = resultName;
    }


    @Override
    public String toString() {
        return "QueryFunction{" +
        "name=" + name +
        ", express=" + express +
        ", type=" + type +
        ", status=" + status +
        ", dataVersion=" + dataVersion +
        ", queryName=" + queryName +
        ", resultName=" + resultName +
        "}";
    }
}
