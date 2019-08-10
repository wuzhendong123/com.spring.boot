package com.spring.boot.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.ParamHtmlTemple;
import com.baomidou.mybatisplus.service.IService;
import com.spring.boot.query.ParamHtmlTempleQuery;
import com.spring.boot.query.base.ParamMapQuery;

/**
 * <p>
 * 参数html模板 服务类
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-04-20
 */
public interface IParamHtmlTempleService extends IService<ParamHtmlTemple> {
    public ParamHtmlTemple bulid(ParamHtmlTempleQuery paramHtmlTempleQuery);
    public String bulidHtml(String html,ParamMapQuery[] paramMapQuery);


    Page<ParamHtmlTemple> selectPageByParamHtmlTemple(Page<ParamHtmlTemple> pagePg, ParamHtmlTemple dictType);
}
