package com.spring.boot.web;


import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.SysRoleMenuRef;
import com.spring.boot.service.ISysRoleMenuRefService;
import com.spring.boot.web.respone.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 角色和菜单关系 前端控制器
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-05-28
 */
@Controller
@RequestMapping("/sysRoleMenuRef")
public class SysRoleMenuRefController {
@Autowired
private ISysRoleMenuRefService SysRoleMenuRefServiceImpl;
private String prefix =  "sysRoleMenuRef";
@RequestMapping(value="/index")
public  String index(){
        return prefix+"/sysRoleMenuRef";
        }
@RequestMapping("/add")
public String add()
        {
        return prefix + "/add";
        }
@RequestMapping(value="/list")
@ResponseBody
public R list(@RequestParam("page") int page, @RequestParam("limit") int limit, SysRoleMenuRef obj){
        Page<SysRoleMenuRef > pagePg=new Page<>(page,limit);
        pagePg= SysRoleMenuRefServiceImpl.selectPageBySysRoleMenuRef(pagePg,obj);
        R r=R.okList(pagePg);
        return r;
        }
}
