package com.spring.boot.service;
import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.DictTypeHistory;
import com.baomidou.mybatisplus.service.IService;
import java.util.List;

/**
 * <p>
 * 字典类型表 服务类
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-09-09
 */
public interface IDictTypeHistoryService extends IService<DictTypeHistory> {
        Page<DictTypeHistory> selectPageByDictTypeHistory(Page<DictTypeHistory> pagePg, DictTypeHistory obj);
}
