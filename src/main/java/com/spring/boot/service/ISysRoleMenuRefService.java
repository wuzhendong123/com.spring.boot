package com.spring.boot.service;
import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.SysRoleMenuRef;
import com.baomidou.mybatisplus.service.IService;
import java.util.List;

/**
 * <p>
 * 角色和菜单关系 服务类
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-05-28
 */
public interface ISysRoleMenuRefService extends IService<SysRoleMenuRef> {
        Page<SysRoleMenuRef> selectPageBySysRoleMenuRef(Page<SysRoleMenuRef> pagePg, SysRoleMenuRef obj);
}
