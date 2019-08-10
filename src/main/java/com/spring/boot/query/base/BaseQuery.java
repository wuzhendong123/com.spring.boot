package com.spring.boot.query.base;

import com.spring.boot.entity.base.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: com.spring.boot
 * @description: 基本查询bean
 * @author: zhendong.wu
 * @create: 2018-09-09 17:24
 **/
public class BaseQuery implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String code;
    private Integer optimistic ;
    private Date createTime;
    private Date updateTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getOptimistic() {
        return optimistic;
    }

    public void setOptimistic(Integer optimistic) {
        this.optimistic = optimistic;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(final Object other) {
        if (!(other instanceof BaseEntity))
            return false;
        BaseEntity castOther = (BaseEntity) other;
        if(code==null||castOther.getCode()==null){
            return false;
        }
        return code.equals(castOther.getCode());
    }

    @Override
    public int hashCode() {
        return new StringBuffer().append(code).toString().hashCode();
    }

}

