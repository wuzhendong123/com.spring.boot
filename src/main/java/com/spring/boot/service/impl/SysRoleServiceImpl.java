package com.spring.boot.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.SysRole;
import com.spring.boot.mapper.SysRoleMapper;
import com.spring.boot.service.ISysRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-05-28
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {
    @Override
    public Page<SysRole> selectPageBySysRole(Page<SysRole> pagePg, SysRole obj) {
        pagePg.setRecords(this.baseMapper.selectPageBySysRole(pagePg, obj));
        return pagePg;
    }

    @Override
    public Set<String> selectRoleKeys(String userCode) {
        Set<String> permsSet = new HashSet<>();
       List<SysRole> roles= baseMapper.selectRoleKeys(userCode);
        for(SysRole role:roles){
            permsSet.add(role.getCode());
        }
        return permsSet;
    }
}
