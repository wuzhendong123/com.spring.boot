package com.spring.boot.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.SysPermissions;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 权限校验 Mapper 接口
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-05-28
 */
public interface SysPermissionsMapper extends BaseMapper<SysPermissions> {
    List<SysPermissions> selectPageBySysPermissions(Page<SysPermissions> pagePg, SysPermissions obj);

    Set<String> selectPermsByUserId(@Param("userCode") String userCode);
}
