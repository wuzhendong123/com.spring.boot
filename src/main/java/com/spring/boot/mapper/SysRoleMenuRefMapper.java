package com.spring.boot.mapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.SysRoleMenuRef;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

/**
 * <p>
 * 角色和菜单关系 Mapper 接口
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-05-28
 */
public interface SysRoleMenuRefMapper extends BaseMapper<SysRoleMenuRef> {
        List<SysRoleMenuRef> selectPageBySysRoleMenuRef(Page<SysRoleMenuRef> pagePg, SysRoleMenuRef obj);
}
