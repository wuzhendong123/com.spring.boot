package com.spring.boot.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.DictType;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 字典类型表 Mapper 接口
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-03-26
 */
public interface DictTypeMapper extends BaseMapper<DictType> {

    List<DictType> selectPageByDictType(Page<DictType> pagePg, DictType dictType);
}
