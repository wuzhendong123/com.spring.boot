package com.spring.boot.service.impl;
import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.SysRoleMenuRef;
import com.spring.boot.mapper.SysRoleMenuRefMapper;
import com.spring.boot.service.ISysRoleMenuRefService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * <p>
 * 角色和菜单关系 服务实现类
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-05-28
 */
@Service
public class SysRoleMenuRefServiceImpl extends ServiceImpl<SysRoleMenuRefMapper, SysRoleMenuRef> implements ISysRoleMenuRefService {
        @Override
        public Page<SysRoleMenuRef> selectPageBySysRoleMenuRef(Page<SysRoleMenuRef> pagePg, SysRoleMenuRef obj) {
        pagePg.setRecords( this.baseMapper.selectPageBySysRoleMenuRef(pagePg,obj));
        return pagePg;
        }
}
