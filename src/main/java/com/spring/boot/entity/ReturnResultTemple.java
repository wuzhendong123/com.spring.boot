package com.spring.boot.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.spring.boot.entity.base.BaseEntity;

/**
 * <p>
 * 返回结果模板
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-05-04
 */
@TableName("return_result_temple")
public class ReturnResultTemple extends BaseEntity<ReturnResultTemple> {

    private static final long serialVersionUID = 1L;

    private String status;
    /**
     * 名称
     */
    private String name;
    /**
     * 类型(方法,select,text)
     */
    private String type;
    /**
     * 中文表达式(用于页面配置)
     */
    @TableField("cn_express")
    private String cnExpress;
    /**
     * 内容展示
     */
    private String html;


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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCnExpress() {
        return cnExpress;
    }

    public void setCnExpress(String cnExpress) {
        this.cnExpress = cnExpress;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }


    @Override
    public String toString() {
        return "ReturnResultTemple{" +
        "status=" + status +
        ", name=" + name +
        ", type=" + type +
        ", cnExpress=" + cnExpress +
        ", html=" + html +
        "}";
    }
}
