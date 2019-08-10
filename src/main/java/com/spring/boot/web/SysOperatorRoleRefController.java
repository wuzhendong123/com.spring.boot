package com.spring.boot.web;


import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.SysOperatorRoleRef;
import com.spring.boot.service.ISysOperatorRoleRefService;
import com.spring.boot.web.respone.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-05-28
 */
@Controller
@RequestMapping("/sysOperatorRoleRef")
public class SysOperatorRoleRefController {
    @Autowired
    private ISysOperatorRoleRefService SysOperatorRoleRefServiceImpl;
    private String prefix = "sysOperatorRoleRef";

    @RequestMapping(value = "/index")
    public String index() {
        return prefix + "/sysOperatorRoleRef";
    }

    @RequestMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public R list(@RequestParam("page") int page, @RequestParam("limit") int limit, SysOperatorRoleRef obj) {
        Page<SysOperatorRoleRef> pagePg = new Page<>(page, limit);
        pagePg = SysOperatorRoleRefServiceImpl.selectPageBySysOperatorRoleRef(pagePg, obj);
        R r = R.okList(pagePg);
        return r;
    }
}
