package com.spring.boot.mapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.SysOperatorRoleRef;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-05-28
 */
public interface SysOperatorRoleRefMapper extends BaseMapper<SysOperatorRoleRef> {
        List<SysOperatorRoleRef> selectPageBySysOperatorRoleRef(Page<SysOperatorRoleRef> pagePg, SysOperatorRoleRef obj);
}
