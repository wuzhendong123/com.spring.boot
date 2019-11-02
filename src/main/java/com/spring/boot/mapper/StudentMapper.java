package com.spring.boot.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhendong.wu
 * @since 2018-09-01
 */
public interface StudentMapper extends BaseMapper<Student> {
    public List<Student> findStudentByName(Pagination page, String name);
    @Cacheable(value = "student")
    public Student findByCode(String code);
    @Cacheable(value = "studednt",keyGenerator = "wiselyKeyGenerator")

    public Page<Student> findByName(@Param("name")String name, @Param("pageNum")int pageNum, @Param("pageSize")int limit);
}
