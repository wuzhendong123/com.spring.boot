package com.spring.boot.entity.base;

import se.spagettikod.optimist.Identity;
import se.spagettikod.optimist.Version;

public class BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Identity("ID")
	private Long id;
	@Version("OPTIMISTIC")
    private Integer optimistic = 0;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		if(id==null||castOther.getId()==null){
			return false;
		}
		return id.equals(castOther.getId());
	}

	@Override
	public int hashCode() {
		return new StringBuffer().append(id).toString().hashCode();
	}	

}
