package com.spring.boot.service.impl;

import com.spring.boot.mapper.OperatorMapper;
import com.spring.boot.entity.Operator;
import com.spring.boot.service.IMenuService;
import com.spring.boot.service.IOperatorService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhendong.wu
 * @since 2018-09-01
 */
@Service("operatorService")
public class OperatorServiceImpl extends ServiceImpl<OperatorMapper, Operator> implements IOperatorService {

    @Override
    public Operator findByNameByPass(String username, String password) {
        return baseMapper.findByNameByPass(username,password);
    }
}
