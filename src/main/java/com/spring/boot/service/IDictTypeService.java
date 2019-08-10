package com.spring.boot.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.DictType;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 字典类型表 服务类
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-03-26
 */
public interface IDictTypeService extends IService<DictType> {

    Page<DictType> selectPageByDictType(Page<DictType> pagePg, DictType dictType);

    Boolean checkDictTypeUnique(DictType dictType);
}
