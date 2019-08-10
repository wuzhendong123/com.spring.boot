package com.spring.boot.service;

import com.baomidou.mybatisplus.service.IService;
import com.spring.boot.entity.Operator;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhendong.wu
 * @since 2018-09-01
 */
public interface IOperatorService extends IService<Operator> {

    Operator findByNameByPass(String username, String password);
}
