package com.spring.boot.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.spring.boot.entity.base.BaseEntity;

import java.io.Serializable;

/**
 * <p>
 * 函数结果输出格式
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-04-21
 */
@TableName("fun_result_ref")
public class FunResultRef extends BaseEntity<FunResultRef> {

    private static final long serialVersionUID = 1L;

    /**
     * 函数code
     */
    @TableField("query_code")
    private String queryCode;
    private String status;
    /**
     * 类样式
     */
    @TableField("clss_ui")
    private String clssUi;
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
    /**
     * 标题
     */
    private String title;
    /**
     * 行合计
     */
    @TableField("row_total")
    private Integer rowTotal;


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

    public String getClssUi() {
        return clssUi;
    }

    public void setClssUi(String clssUi) {
        this.clssUi = clssUi;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getRowTotal() {
        return rowTotal;
    }

    public void setRowTotal(Integer rowTotal) {
        this.rowTotal = rowTotal;
    }


    @Override
    public String toString() {
        return "FunResultRef{" +
        "queryCode=" + queryCode +
        ", status=" + status +
        ", clssUi=" + clssUi +
        ", paramExp=" + paramExp +
        ", paramKey=" + paramKey +
        ", title=" + title +
        ", rowTotal=" + rowTotal +
        "}";
    }
}
