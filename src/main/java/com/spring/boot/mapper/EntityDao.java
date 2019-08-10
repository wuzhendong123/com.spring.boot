package com.spring.boot.mapper;

//import tk.mybatis.mapper.common.Mapper;
//import tk.mybatis.mapper.common.Mapper;


public  interface EntityDao<T>   {

    public void insert(T t);
    public T findById(long id);
    public T update(T t);
}
