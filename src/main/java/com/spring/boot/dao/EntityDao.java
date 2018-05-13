package com.spring.boot.dao;

import org.apache.ibatis.session.SqlSession;

import java.io.Serializable;


public  interface EntityDao<T, PK extends Serializable> {
	public int insert(T t);
	public T selectOneByCode(PK code);


}
