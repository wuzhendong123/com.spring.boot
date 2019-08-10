package com.spring.boot.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.SysPermissions;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 权限校验 服务类
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-05-28
 */
public interface ISysPermissionsService extends IService<SysPermissions> {
    Page<SysPermissions> selectPageBySysPermissions(Page<SysPermissions> pagePg, SysPermissions obj);

    Set<String> selectPermsByUserId(String code);
}
