package com.spring.boot.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhendong.wu
 * @since 2018-09-01
 */
public interface IStudentService extends IService<Student> {
    public Page<Student> findStudentByName(Page<Student> page, String name);

    void insert1(Student student);
    Student findByCode(String code);
}
