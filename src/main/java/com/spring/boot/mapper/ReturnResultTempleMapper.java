package com.spring.boot.mapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.ReturnResultTemple;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 返回结果模板 Mapper 接口
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-05-04
 */
public interface ReturnResultTempleMapper extends BaseMapper<ReturnResultTemple> {
        List<ReturnResultTemple> selectPageByReturnResultTemple(Page<ReturnResultTemple> pagePg, ReturnResultTemple obj);
}
