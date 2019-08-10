package com.spring.boot.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.DictData;
import com.spring.boot.mapper.DictDataMapper;
import com.spring.boot.service.IDictDataService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 字典数据表 服务实现类
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-03-26
 */
@Service
public class DictDataServiceImpl extends ServiceImpl<DictDataMapper, DictData> implements IDictDataService {
    @Override
    public List<DictData> selectDictDataByType(String dictType) {
        return this.baseMapper.selectDictDataByType(dictType);
    }

    @Override
    public Page<DictData> selectPageByDictData(Page<DictData> pagePg, DictData dictData) {
        pagePg.setRecords(this.baseMapper.selectPageByDictData(pagePg,dictData));
        return pagePg;
    }
}
