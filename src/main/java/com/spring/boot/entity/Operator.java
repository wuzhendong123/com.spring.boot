package com.spring.boot.entity;

import java.beans.Transient;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.spring.boot.entity.base.BaseEntity;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhendong.wu
 * @since 2018-09-01
 */
public class Operator extends BaseEntity<Operator> {

    private static final long serialVersionUID = 1L;

	private String name;
	@TableField("pass_word")
	private String passWord;
	private String phone;
    /**
     * 操作员
     */
	private String status;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Operator{" +
			"name=" + name +
			", passWord=" + passWord +
			", phone=" + phone +
			", status=" + status +
			"}";
	}
}
