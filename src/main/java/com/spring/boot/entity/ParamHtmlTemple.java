package com.spring.boot.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.spring.boot.entity.base.BaseEntity;

import java.io.Serializable;

/**
 * <p>
 * 参数html模板
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-04-20
 */
@TableName("param_html_temple")
public class ParamHtmlTemple extends BaseEntity<ParamHtmlTemple> {

    private static final long serialVersionUID = 1L;

    /**
     * 组件类型(文本框,日期框)
     */
    private String type;
    private String status;
    /**
     * css样式
     */
    @TableField("class_ui")
    private String classUi;
    /**
     * 模板名称
     */
    private String name;
    /**
     * html内容
     */
    private String html;
    /**
     * html例子
     */
    @TableField("example_html")
    private String exampleHtml;
    /**
     * html例子参数
     */
    @TableField("example_html_param")
    private String exampleHtmlParam;
    /**
     * html参数
     */
    @TableField("html_param")
    private String htmlParam;


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

    public String getClassUi() {
        return classUi;
    }

    public void setClassUi(String classUi) {
        this.classUi = classUi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getExampleHtml() {
        return exampleHtml;
    }

    public void setExampleHtml(String exampleHtml) {
        this.exampleHtml = exampleHtml;
    }

    public String getExampleHtmlParam() {
        return exampleHtmlParam;
    }

    public void setExampleHtmlParam(String exampleHtmlParam) {
        this.exampleHtmlParam = exampleHtmlParam;
    }

    public String getHtmlParam() {
        return htmlParam;
    }

    public void setHtmlParam(String htmlParam) {
        this.htmlParam = htmlParam;
    }


    @Override
    public String toString() {
        return "paramHtmlTemple{" +
        "type=" + type +
        ", status=" + status +
        ", classUi=" + classUi +
        ", name=" + name +
        ", html=" + html +
        ", exampleHtml=" + exampleHtml +
        ", exampleHtmlParam=" + exampleHtmlParam +
        ", htmlParam=" + htmlParam +
        "}";
    }
}
