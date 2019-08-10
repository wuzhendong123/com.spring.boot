package com.spring.boot.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.FunctionRuleRef;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.spring.boot.query.FunctionRuleRefQuery;
import com.spring.boot.query.respone.FunRuleRefBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 函数规则引用 Mapper 接口
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-04-30
 */
public interface FunctionRuleRefMapper extends BaseMapper<FunctionRuleRef> {
        List<FunctionRuleRef> selectPageByFunctionRuleRef(Page<FunctionRuleRef> pagePg, FunctionRuleRef obj);

    List<FunctionRuleRef> selectByRuleCode(@Param("ruleCode") String ruleCode, @Param("status")String status);

    List<FunRuleRefBean> selectPageByFunRuleRefBean(Page<FunRuleRefBean> pagePg, FunctionRuleRefQuery functionRuleRefQuery);
}
