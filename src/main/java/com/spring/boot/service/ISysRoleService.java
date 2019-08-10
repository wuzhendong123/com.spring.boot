package com.spring.boot.service;
import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.SysRole;
import com.baomidou.mybatisplus.service.IService;
import java.util.List;
import java.util.Set;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-05-28
 */
public interface ISysRoleService extends IService<SysRole> {
        Page<SysRole> selectPageBySysRole(Page<SysRole> pagePg, SysRole obj);

        Set<String> selectRoleKeys(String code);
}
