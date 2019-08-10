package com.spring.boot.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.spring.boot.entity.base.BaseEntity;

import java.io.Serializable;

/**
 * <p>
 * 临时批次
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-04-24
 */
@TableName("temp_batch")
public class TempBatch extends BaseEntity<TempBatch> {

    private static final long serialVersionUID = 1L;

    /**
     * 标识
     */
    private String mark;
    /**
     * 批次号
     */
    @TableField("bacth_no")
    private String bacthNo;


    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getBacthNo() {
        return bacthNo;
    }

    public void setBacthNo(String bacthNo) {
        this.bacthNo = bacthNo;
    }



    @Override
    public String toString() {
        return "TempBatch{" +
        "mark=" + mark +
        ", bacthNo=" + bacthNo +
        "}";
    }
}
