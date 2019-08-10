package com.spring.boot.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.DictData;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 字典数据表 服务类
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-03-26
 */
public interface IDictDataService extends IService<DictData> {

    List<DictData> selectDictDataByType(String dictType);

    Page<DictData> selectPageByDictData(Page<DictData> pagePg, DictData dictData);
}
