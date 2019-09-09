package com.spring.boot.service.impl;
import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.DictTypeHistory;
import com.spring.boot.mapper.DictTypeHistoryMapper;
import com.spring.boot.service.IDictTypeHistoryService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * <p>
 * 字典类型表 服务实现类
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-09-09
 */
@Service
public class DictTypeHistoryServiceImpl extends ServiceImpl<DictTypeHistoryMapper, DictTypeHistory> implements IDictTypeHistoryService {
        @Override
        public Page<DictTypeHistory> selectPageByDictTypeHistory(Page<DictTypeHistory> pagePg, DictTypeHistory obj) {
        pagePg.setRecords( this.baseMapper.selectPageByDictTypeHistory(pagePg,obj));
        return pagePg;
        }
}
