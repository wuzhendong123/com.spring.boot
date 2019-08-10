package com.spring.boot.service;
import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.ReturnResultTemple;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 返回结果模板 服务类
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-05-04
 */
public interface IReturnResultTempleService extends IService<ReturnResultTemple> {
        Page<ReturnResultTemple> selectPageByReturnResultTemple(Page<ReturnResultTemple> pagePg, ReturnResultTemple obj);
}
