package com.spring.boot.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.SysRole;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-05-28
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {
    List<SysRole> selectPageBySysRole(Page<SysRole> pagePg, SysRole obj);

    List<SysRole>  selectRoleKeys(@Param("userCode") String userCode);
}
