package com.spring.boot.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.spring.boot.entity.base.BaseEntity;

import java.io.Serializable;

/**
 * <p>
 * 函数参数html关系
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-04-20
 */
@TableName("fun_param_html_ref")
public class FunParamHtmlRef extends BaseEntity<FunParamHtmlRef> {

    private static final long serialVersionUID = 1L;

    /**
     * 函数code
     */
    @TableField("query_code")
    private String queryCode;
    private String status;
    /**
     * 参数模板code
     */
    @TableField("param_html_code")
    private String paramHtmlCode;
    /**
     * html内容
     */
    private String html;
    /**
     * 参数表达式
     */
    @TableField("param_exp")
    private String paramExp;
    /**
     * 参数key
     */
    @TableField("param_key")
    private String paramKey;


    public String getQueryCode() {
        return queryCode;
    }

    public void setQueryCode(String queryCode) {
        this.queryCode = queryCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getParamHtmlCode() {
        return paramHtmlCode;
    }

    public void setParamHtmlCode(String paramHtmlCode) {
        this.paramHtmlCode = paramHtmlCode;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getParamExp() {
        return paramExp;
    }

    public void setParamExp(String paramExp) {
        this.paramExp = paramExp;
    }

    public String getParamKey() {
        return paramKey;
    }

    public void setParamKey(String paramKey) {
        this.paramKey = paramKey;
    }

    @Override
    public String toString() {
        return "FunParamHtmlRef{" +
        "queryCode=" + queryCode +
        ", status=" + status +
        ", paramHtmlCode=" + paramHtmlCode +
        ", html=" + html +
        ", paramExp=" + paramExp +
        ", paramKey=" + paramKey +
        "}";
    }
}
