package com.spring.boot.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.TempBatch;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 临时批次 Mapper 接口
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-04-24
 */
public interface TempBatchMapper extends BaseMapper<TempBatch> {
        List<TempBatch> selectPageByTempBatch(Page<TempBatch> pagePg, TempBatch obj);
}
