package com.spring.boot.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.spring.boot.entity.base.BaseEntity;

/**
 * <p>
 * 函数模板定义
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-05-01
 */
@TableName("function_route_temple")
public class FunctionRouteTemple extends BaseEntity<FunctionRouteTemple> {

    private static final long serialVersionUID = 1L;

    private String status;
    private String name;
    /**
     * 引用模板标识
     */
    @TableField("ref_code")
    private String refCode;
    /**
     * 内容展示
     */
    private String html;
    /**
     * 执行表达式
     */
    private String express;
    /**
     * 中文表达式(用于页面配置)
     */
    @TableField("cn_express")
    private String cnExpress;
    /**
     * html布局
     */
    @TableField("html_layout")
    private String htmlLayout;
    /**
     * 参数定义
     */
    @TableField("param_def")
    private String paramDef;


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

    public String getRefCode() {
        return refCode;
    }

    public void setRefCode(String refCode) {
        this.refCode = refCode;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getExpress() {
        return express;
    }

    public void setExpress(String express) {
        this.express = express;
    }

    public String getCnExpress() {
        return cnExpress;
    }

    public void setCnExpress(String cnExpress) {
        this.cnExpress = cnExpress;
    }

    public String getHtmlLayout() {
        return htmlLayout;
    }

    public void setHtmlLayout(String htmlLayout) {
        this.htmlLayout = htmlLayout;
    }

    public String getParamDef() {
        return paramDef;
    }

    public void setParamDef(String paramDef) {
        this.paramDef = paramDef;
    }

    @Override
    public String toString() {
        return "FunctionRouteTemple{" +
        "status=" + status +
        ", name=" + name +
        ", refCode=" + refCode +
        ", html=" + html +
        ", express=" + express +
        ", cnExpress=" + cnExpress +
        ", htmlLayout=" + htmlLayout +
        ", paramDef=" + paramDef +
        "}";
    }
}
