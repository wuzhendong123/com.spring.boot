package com.spring.boot.service;

import com.spring.boot.common.domain.Col;
import com.spring.boot.entity.FunResultRef;
import com.baomidou.mybatisplus.service.IService;
import com.spring.boot.query.base.ParamQuery;

/**
 * <p>
 * 函数结果输出格式 服务类
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-04-21
 */
public interface IFunResultRefService extends IService<FunResultRef> {

    Col[] bulid(String funCode, String express);
}
