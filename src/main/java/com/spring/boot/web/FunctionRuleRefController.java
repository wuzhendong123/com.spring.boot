package com.spring.boot.web;


import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.FunctionRuleRef;
import com.spring.boot.query.FunctionRuleRefQuery;
import com.spring.boot.query.respone.FunRuleRefBean;
import com.spring.boot.service.IFunctionRuleRefService;
import com.spring.boot.service.impl.FunctionRuleRefServiceImpl;
import com.spring.boot.web.respone.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 函数规则引用 前端控制器
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-04-30
 */
@Controller
@RequestMapping("/functionRuleRef")
public class FunctionRuleRefController {
    @Autowired
    private IFunctionRuleRefService functionRuleRefService;
    private String prefix = "functionRuleRef";

    @RequestMapping(value = "/index")
    public String index() {
        return prefix + "/functionRuleRef";
    }

    @RequestMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public R list(@RequestParam("page") int page, @RequestParam("limit") int limit, FunctionRuleRef obj) {
        Page<FunctionRuleRef> pagePg = new Page<>(page, limit);
        pagePg = functionRuleRefService.selectPageByFunctionRuleRef(pagePg, obj);
        R r = R.okList(pagePg);
        return r;
    }
    @RequestMapping(value = "/listByRule")
    @ResponseBody
    public R list(@RequestParam("page") int page, @RequestParam("limit") int limit, FunctionRuleRefQuery functionRuleRefQuery) {
        Page<FunRuleRefBean> pagePg = new Page<>(page, limit);
        pagePg = functionRuleRefService.selectPageByFunRuleRefBean(pagePg, functionRuleRefQuery);
        R r = R.okList(pagePg);
        return r;
    }
}
