package com.spring.boot.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.mapper.StudentMapper;
import com.spring.boot.entity.Student;
import com.spring.boot.service.IStudentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhendong.wu
 * @since 2018-09-01
 */
@Service("studentService")
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

    @Override
    public Page<Student> findStudentByName(Page<Student> page, String name) {
        return page.setRecords(this.baseMapper.findStudentByName(page,name));
    }

    @Override
    @Transactional
    public void insert1(Student student) {

        insert(student);
    }

    @Override
    public Student findByCode(String code) {
        return baseMapper.findByCode(code);
    }
}
