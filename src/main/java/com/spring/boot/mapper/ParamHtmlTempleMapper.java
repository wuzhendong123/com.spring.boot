package com.spring.boot.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.DictType;
import com.spring.boot.entity.ParamHtmlTemple;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 参数html模板 Mapper 接口
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-04-20
 */
public interface ParamHtmlTempleMapper extends BaseMapper<ParamHtmlTemple> {

    List<ParamHtmlTemple> selectPageByParamHtmlTemple(Page<ParamHtmlTemple> pagePg, ParamHtmlTemple dictType);
}
