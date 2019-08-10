package com.spring.boot.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.ReturnResultRuleRef;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 返回结果规则关联 Mapper 接口
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-05-04
 */
public interface ReturnResultRuleRefMapper extends BaseMapper<ReturnResultRuleRef> {
    List<ReturnResultRuleRef> selectPageByReturnResultRuleRef(Page<ReturnResultRuleRef> pagePg, ReturnResultRuleRef obj);

    List<ReturnResultRuleRef> selectByRuleCode(@Param("ruleCode") String ruleCode, @Param("status") String status);
}
