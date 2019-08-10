package com.spring.boot.service.impl;
import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.ReturnResultTemple;
import com.spring.boot.mapper.ReturnResultTempleMapper;
import com.spring.boot.service.IReturnResultTempleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 返回结果模板 服务实现类
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-05-04
 */
@Service
public class ReturnResultTempleServiceImpl extends ServiceImpl<ReturnResultTempleMapper, ReturnResultTemple> implements IReturnResultTempleService {
        @Override
        public Page<ReturnResultTemple> selectPageByReturnResultTemple(Page<ReturnResultTemple> pagePg, ReturnResultTemple obj) {
        pagePg.setRecords( this.baseMapper.selectPageByReturnResultTemple(pagePg,obj));
        return pagePg;
        }
}
