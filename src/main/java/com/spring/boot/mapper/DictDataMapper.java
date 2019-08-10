package com.spring.boot.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.DictData;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 字典数据表 Mapper 接口
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-03-26
 */
public interface DictDataMapper extends BaseMapper<DictData> {

    List<DictData> selectDictDataByType(String dictType);

    List<DictData> selectPageByDictData(Page<DictData> pagePg, DictData dictData);
}
