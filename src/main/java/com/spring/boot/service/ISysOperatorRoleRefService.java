package com.spring.boot.service;
import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.SysOperatorRoleRef;
import com.baomidou.mybatisplus.service.IService;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-05-28
 */
public interface ISysOperatorRoleRefService extends IService<SysOperatorRoleRef> {
        Page<SysOperatorRoleRef> selectPageBySysOperatorRoleRef(Page<SysOperatorRoleRef> pagePg, SysOperatorRoleRef obj);
}
