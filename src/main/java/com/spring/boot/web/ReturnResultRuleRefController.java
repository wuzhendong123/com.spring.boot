package com.spring.boot.web;


import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.ReturnResultRuleRef;
import com.spring.boot.service.IReturnResultRuleRefService;
import com.spring.boot.service.impl.ReturnResultRuleRefServiceImpl;
import com.spring.boot.web.respone.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 返回结果规则关联 前端控制器
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-05-04
 */
@Controller
@RequestMapping("/returnResultRuleRef")
public class ReturnResultRuleRefController {
    @Autowired
    private IReturnResultRuleRefService returnResultRuleRefService;
    private String prefix = "returnResultRuleRef";

    @RequestMapping(value = "/index")
    public String index() {
        return prefix + "/returnResultRuleRef";
    }

    @RequestMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public R list(@RequestParam("page") int page, @RequestParam("limit") int limit, ReturnResultRuleRef obj) {
        Page<ReturnResultRuleRef> pagePg = new Page<>(page, limit);
        pagePg = returnResultRuleRefService.selectPageByReturnResultRuleRef(pagePg, obj);
        R r = R.okList(pagePg);
        return r;
    }
}
