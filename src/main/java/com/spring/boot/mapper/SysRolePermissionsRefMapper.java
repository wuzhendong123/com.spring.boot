package com.spring.boot.mapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.SysRolePermissionsRef;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

/**
 * <p>
 * 角色和权限关系 Mapper 接口
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-05-28
 */
public interface SysRolePermissionsRefMapper extends BaseMapper<SysRolePermissionsRef> {
        List<SysRolePermissionsRef> selectPageBySysRolePermissionsRef(Page<SysRolePermissionsRef> pagePg, SysRolePermissionsRef obj);
}
