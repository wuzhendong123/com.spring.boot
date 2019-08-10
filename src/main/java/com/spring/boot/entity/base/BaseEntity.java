package com.spring.boot.entity.base;




import com.baomidou.mybatisplus.MybatisDefaultParameterHandler;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.KeySequence;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.Version;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.toolkit.TableInfoHelper;
import org.apache.catalina.core.ApplicationFilterFactory;
import org.apache.ibatis.binding.MapperProxy;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import java.io.Serializable;
import java.util.Date;


public class BaseEntity<T> extends Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	org.springframework.boot.autoconfigure.web.HttpEncodingAutoConfiguration
//		TableInfoHelper
//	MybatisDefaultParameterHandler
//	ApplicationFilterFactory
//	WebApplicationInitializer
	//MapperFactoryBean
	//MapperProxy
	@TableId( type = IdType.ID_WORKER_STR)
	private String code;
	@Version
	@TableField(value="optimistic",fill =  FieldFill.INSERT)
	private Integer optimistic ;
	@TableField(value="create_time",fill =  FieldFill.INSERT_UPDATE)
    private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }
	@TableField(value="update_time",fill =  FieldFill.UPDATE)
	private Date updateTime;

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
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

	@Override
	protected Serializable pkVal() {
		return code;
	}
}
