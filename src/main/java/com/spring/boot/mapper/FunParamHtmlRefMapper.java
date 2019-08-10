package com.spring.boot.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.FunParamHtmlRef;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 函数参数html关系 Mapper 接口
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-04-20
 */
public interface FunParamHtmlRefMapper extends BaseMapper<FunParamHtmlRef> {

    List<FunParamHtmlRef> selectPageByFunParamHtmlRef(Page<FunParamHtmlRef> pagePg, FunParamHtmlRef obj);

    List<FunParamHtmlRef> selectByFunCode(String code);
}
