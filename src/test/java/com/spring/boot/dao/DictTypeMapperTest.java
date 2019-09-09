package com.spring.boot.dao;

import com.spring.boot.BaseTest;
import com.spring.boot.entity.DictType;
import com.spring.boot.mapper.DictTypeMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: com.spring.boot
 * @description:
 * @author: zhendong.wu
 * @create: 2019-07-10 14:37
 **/
public class DictTypeMapperTest extends BaseTest {
    @Autowired
    private DictTypeMapper dictTypeMapper;

    @Test
    public void testAdd(){
        DictType dictType=new DictType();
        dictType.setRemark("dddd");
        dictTypeMapper.insert(dictType);
    }

    @Test
    public void testUpdate(){
        DictType dictType=dictTypeMapper.selectById(1171088144162938882L);
        dictType.setRemark("dddd");
        dictType.setStatus("11");
        dictType.setCreateBy("dddd");
        dictType.setUpdateBy("cccc");
        //dictType.updateById();
        dictTypeMapper.updateById(dictType);
    }
}
