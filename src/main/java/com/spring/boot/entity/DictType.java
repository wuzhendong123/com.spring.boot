package com.spring.boot.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.spring.boot.entity.base.BaseEntity;

import java.io.Serializable;

/**
 * <p>
 * 字典类型表
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-03-26
 */
@TableName("dict_type")
public class DictType extends BaseEntity<DictType> {

    private static final long serialVersionUID = 1L;

    /**
     * 字典名称
     */
    @TableField("dict_name")
    private String dictName;
    /**
     * 字典类型
     */
    @TableField("dict_type")
    private String dictType;
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


    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
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
        return "DictType{" +
        "dictName=" + dictName +
        ", dictType=" + dictType +
        ", status=" + status +
        ", createBy=" + createBy +
        ", updateBy=" + updateBy +
        ", remark=" + remark +
        "}";
    }
}
