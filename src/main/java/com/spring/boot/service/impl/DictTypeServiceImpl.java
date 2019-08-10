package com.spring.boot.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.DictType;
import com.spring.boot.mapper.DictTypeMapper;
import com.spring.boot.service.IDictTypeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 字典类型表 服务实现类
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-03-26
 */
@Service
public class DictTypeServiceImpl extends ServiceImpl<DictTypeMapper, DictType> implements IDictTypeService {

    @Override
    public Page<DictType> selectPageByDictType(Page<DictType> pagePg, DictType dictType) {
        pagePg.setRecords(baseMapper.selectPageByDictType(pagePg,dictType));
        return pagePg;
    }

    @Override
    public Boolean checkDictTypeUnique(DictType dictType) {
        Page<DictType> pagePg=new Page<DictType> (1,10);
      List<DictType> dictTypes= baseMapper.selectPageByDictType(pagePg,dictType);
        return (dictTypes!=null&&!dictTypes.isEmpty())?false:true;
    }
}
