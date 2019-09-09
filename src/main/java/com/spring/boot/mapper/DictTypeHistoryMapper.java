package com.spring.boot.mapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.DictTypeHistory;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;

/**
 * <p>
 * 字典类型表 Mapper 接口
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-09-09
 */
public interface DictTypeHistoryMapper extends BaseMapper<DictTypeHistory> {
        List<DictTypeHistory> selectPageByDictTypeHistory(Page<DictTypeHistory> pagePg, DictTypeHistory obj);
}
