package com.spring.boot.service.impl;
import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.SysOperatorRoleRef;
import com.spring.boot.mapper.SysOperatorRoleRefMapper;
import com.spring.boot.service.ISysOperatorRoleRefService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-05-28
 */
@Service
public class SysOperatorRoleRefServiceImpl extends ServiceImpl<SysOperatorRoleRefMapper, SysOperatorRoleRef> implements ISysOperatorRoleRefService {
        @Override
        public Page<SysOperatorRoleRef> selectPageBySysOperatorRoleRef(Page<SysOperatorRoleRef> pagePg, SysOperatorRoleRef obj) {
        pagePg.setRecords( this.baseMapper.selectPageBySysOperatorRoleRef(pagePg,obj));
        return pagePg;
        }
}
