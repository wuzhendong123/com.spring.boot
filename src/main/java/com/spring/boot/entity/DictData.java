package com.spring.boot.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.spring.boot.entity.base.BaseEntity;

import java.io.Serializable;

/**
 * <p>
 * 字典数据表
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-03-26
 */
@TableName("dict_data")
public class DictData extends BaseEntity<DictData> {

    private static final long serialVersionUID = 1L;

    /**
     * 字典排序
     */
    @TableField("dict_sort")
    private Integer dictSort;
    /**
     * 字典标签
     */
    @TableField("dict_label")
    private String dictLabel;
    /**
     * 字典键值
     */
    @TableField("dict_value")
    private String dictValue;
    /**
     * 字典类型
     */
    @TableField("dict_type")
    private String dictType;
    /**
     * 样式属性（其他样式扩展）
     */
    @TableField("css_class")
    private String cssClass;
    /**
     * 表格回显样式
     */
    @TableField("list_class")
    private String listClass;
    /**
     * 是否默认（Y是 N否）
     */
    @TableField("is_default")
    private String isDefault;
    /**
     * 状态（0正常 1停用）
     */
    private String status;
    /**
     * 创建者
     */
    @TableField("create_by")
    private String createBy;
    /**
     * 更新者
     */
    @TableField("update_by")
    private String updateBy;
    /**
     * 备注
     */
    private String remark;


    public Integer getDictSort() {
        return dictSort;
    }

    public void setDictSort(Integer dictSort) {
        this.dictSort = dictSort;
    }

    public String getDictLabel() {
        return dictLabel;
    }

    public void setDictLabel(String dictLabel) {
        this.dictLabel = dictLabel;
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public String getListClass() {
        return listClass;
    }

    public void setListClass(String listClass) {
        this.listClass = listClass;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }



    @Override
    public String toString() {
        return "DictData{" +
        "dictSort=" + dictSort +
        ", dictLabel=" + dictLabel +
        ", dictValue=" + dictValue +
        ", dictType=" + dictType +
        ", cssClass=" + cssClass +
        ", listClass=" + listClass +
        ", isDefault=" + isDefault +
        ", status=" + status +
        ", createBy=" + createBy +
        ", updateBy=" + updateBy +
        ", remark=" + remark +
        "}";
    }
}
