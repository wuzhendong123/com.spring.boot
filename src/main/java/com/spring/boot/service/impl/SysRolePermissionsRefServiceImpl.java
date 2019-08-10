package com.spring.boot.service.impl;
import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.SysRolePermissionsRef;
import com.spring.boot.mapper.SysRolePermissionsRefMapper;
import com.spring.boot.service.ISysRolePermissionsRefService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * <p>
 * 角色和权限关系 服务实现类
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-05-28
 */
@Service
public class SysRolePermissionsRefServiceImpl extends ServiceImpl<SysRolePermissionsRefMapper, SysRolePermissionsRef> implements ISysRolePermissionsRefService {
        @Override
        public Page<SysRolePermissionsRef> selectPageBySysRolePermissionsRef(Page<SysRolePermissionsRef> pagePg, SysRolePermissionsRef obj) {
        pagePg.setRecords( this.baseMapper.selectPageBySysRolePermissionsRef(pagePg,obj));
        return pagePg;
        }
}
