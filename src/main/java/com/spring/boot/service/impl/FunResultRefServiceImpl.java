package com.spring.boot.service.impl;

import com.spring.boot.common.domain.Col;
import com.spring.boot.entity.FunResultRef;
import com.spring.boot.mapper.FunResultRefMapper;
import com.spring.boot.query.base.ParamQuery;
import com.spring.boot.service.IFunResultRefService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * 函数结果输出格式 服务实现类
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-04-21
 */
@Service
public class FunResultRefServiceImpl extends ServiceImpl<FunResultRefMapper, FunResultRef> implements IFunResultRefService {

    @Override
    public Col[] bulid(String funCode, String express) {
        List<ParamQuery> liP=new ArrayList<ParamQuery>();
        express =express.toLowerCase();
        Matcher matcher = patternRegexResult.matcher(express);
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

        return  bulid(liP.toArray(new ParamQuery[liP.size()]));
    }

    public Col[] bulid( ParamQuery[] paramQuerys){
        //暂不支持
        List<Col> colLis=new ArrayList<>();
        colLis.add(Col.bulidHead());
        for(ParamQuery paramQuery:paramQuerys){
            Col c=new Col(paramQuery.getKey());
            colLis.add(c);
        }
        colLis.add(Col.bulidEnd());
        return colLis.toArray(new Col[colLis.size()]);

    }
    static Pattern patternRegexCol ;
    static Pattern patternRegexResult ;
    static String regexCol="as([^,]+)[,]*?";
    static String regexResult = "select(.+?)from";

    static {
        patternRegexResult = Pattern.compile(regexResult);
        patternRegexCol = Pattern.compile(regexCol);
    }

}
