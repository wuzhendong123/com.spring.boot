package com.spring.boot.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.spring.boot.entity.Operator;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zhendong.wu
 * @since 2018-09-01
 */
public interface OperatorMapper extends BaseMapper<Operator> {

    Operator findByNameByPass(@Param("username") String username,@Param("password")  String password);
}
