package com.spring.boot.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring.boot.entity.ParamHtmlTemple;
import com.spring.boot.mapper.ParamHtmlTempleMapper;
import com.spring.boot.query.ParamHtmlTempleQuery;
import com.spring.boot.query.base.ParamMapQuery;
import com.spring.boot.service.IParamHtmlTempleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.spring.boot.util.JSONUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * 参数html模板 服务实现类
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-04-20
 */
@Service
public class ParamHtmlTempleServiceImpl extends ServiceImpl<ParamHtmlTempleMapper, ParamHtmlTemple> implements IParamHtmlTempleService {
    static String regex = "\\$\\{(.+?)\\}";
    @Override
    public ParamHtmlTemple bulid(ParamHtmlTempleQuery paramHtmlTempleQuery) {
        ParamHtmlTemple paramHtmlTemple=new ParamHtmlTemple();

        paramHtmlTemple.setHtml(paramHtmlTempleQuery.getHtml());
        String html=paramHtmlTempleQuery.getHtml();
        String exampleHtml=doBulidHtml(html,paramHtmlTempleQuery.getParamMapQuery());
        paramHtmlTemple.setName(paramHtmlTempleQuery.getName());
        paramHtmlTemple.setExampleHtml(exampleHtml);
        paramHtmlTemple.setStatus(paramHtmlTempleQuery.getStatus());
        try {
            paramHtmlTemple.setHtmlParam(JSONUtil.writeValueAsString(paramHtmlTempleQuery.getParamQuery()));
            paramHtmlTemple.setExampleHtmlParam(JSONUtil.writeValueAsString(paramHtmlTempleQuery.getParamMapQuery()));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return paramHtmlTemple;
    }

    @Override
    public String bulidHtml(String html, ParamMapQuery[] paramMapQuery) {
        return doBulidHtml(html, paramMapQuery);
    }

    @Override
    public Page<ParamHtmlTemple> selectPageByParamHtmlTemple(Page<ParamHtmlTemple> pagePg, ParamHtmlTemple dictType) {
        pagePg.setRecords( baseMapper.selectPageByParamHtmlTemple(pagePg,dictType));
        return pagePg;
    }

    private  String doBulidHtml(String html,ParamMapQuery[] paramMapQuery){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(html);
        Map<String,String> map=new HashMap<>();
        for(ParamMapQuery pkq : paramMapQuery){
            map.put(pkq.getKey(),pkq.getValue());
        }
        while(matcher.find()){
            html= html.replace(matcher.group(0),map.get(matcher.group(1)));
        }
        return html;
    }
}
