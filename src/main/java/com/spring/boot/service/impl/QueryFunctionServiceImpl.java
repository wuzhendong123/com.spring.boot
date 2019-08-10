package com.spring.boot.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.QueryFunction;
import com.spring.boot.mapper.QueryFunctionMapper;
import com.spring.boot.query.base.ParamQuery;
import com.spring.boot.service.IQueryFunctionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * 查询函数执行表达式 服务实现类
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-04-20
 */
@Service
public class QueryFunctionServiceImpl extends ServiceImpl<QueryFunctionMapper, QueryFunction> implements IQueryFunctionService {
    static String regex = "\\#\\{(.+?)\\}";
    static String regexResult = "select(.+?)from";
    static String regexCol="as([^,]+)[,]*?";
    static Pattern patternRegex ;
    static Pattern patternRegexResult ;
    static Pattern patternRegexCol ;
    static {
         patternRegex = Pattern.compile(regex);
        patternRegexResult = Pattern.compile(regexResult);
        patternRegexCol = Pattern.compile(regexCol);
    }
    @Override
    public Page<QueryFunction> selectPageByQueryFunction(Page<QueryFunction> pagePg, QueryFunction queryFunction) {
        pagePg.setRecords(baseMapper.selectPageByQueryFunction(pagePg,queryFunction));
        return pagePg;
    }
    @Override
    public ParamQuery[] expAnalysisQuery(String exp){
        List<ParamQuery> liP=new ArrayList<ParamQuery>();
        exp =exp.toLowerCase();
        Matcher matcher = patternRegex.matcher(exp);

        while(matcher.find()){
            ParamQuery paramQuery=new ParamQuery();
            paramQuery.setKey(matcher.group(1));
            liP.add(paramQuery);
        }
        return  liP.toArray(new ParamQuery[liP.size()]);
    }

    @Override
    public ParamQuery[] expResultQuery(String exp){
        List<ParamQuery> liP=new ArrayList<ParamQuery>();
        exp =exp.toLowerCase();
        Matcher matcher = patternRegexResult.matcher(exp);
        if(matcher.find()){
            String colStr= matcher.group(1);
            Matcher matcher2 =patternRegexCol.matcher(colStr);
            while(matcher2.find()){
                String key=matcher2.group(1);
                if(key!=null&&!"".equals(key)){
                    ParamQuery paramQuery=new ParamQuery();
                    paramQuery.setKey(key.trim());
                    liP.add(paramQuery);
                }

            }
        }

        return  liP.toArray(new ParamQuery[liP.size()]);
    }


}
