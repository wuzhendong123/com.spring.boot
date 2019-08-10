package com.spring.boot.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.SysPermissions;
import com.spring.boot.mapper.SysPermissionsMapper;
import com.spring.boot.service.ISysPermissionsService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 权限校验 服务实现类
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-05-28
 */
@Service
public class SysPermissionsServiceImpl extends ServiceImpl<SysPermissionsMapper, SysPermissions> implements ISysPermissionsService {
    @Override
    public Page<SysPermissions> selectPageBySysPermissions(Page<SysPermissions> pagePg, SysPermissions obj) {
        pagePg.setRecords(this.baseMapper.selectPageBySysPermissions(pagePg, obj));
        return pagePg;
    }

    @Override
    public Set<String> selectPermsByUserId(String userCode) {
        return baseMapper.selectPermsByUserId(userCode);
    }
}
