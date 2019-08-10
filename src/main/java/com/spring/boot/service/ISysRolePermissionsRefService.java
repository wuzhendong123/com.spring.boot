package com.spring.boot.service;
import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.SysRolePermissionsRef;
import com.baomidou.mybatisplus.service.IService;
import java.util.List;

/**
 * <p>
 * 角色和权限关系 服务类
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-05-28
 */
public interface ISysRolePermissionsRefService extends IService<SysRolePermissionsRef> {
        Page<SysRolePermissionsRef> selectPageBySysRolePermissionsRef(Page<SysRolePermissionsRef> pagePg, SysRolePermissionsRef obj);
}
