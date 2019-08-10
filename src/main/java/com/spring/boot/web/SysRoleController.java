package com.spring.boot.web;


import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.SysRole;
import com.spring.boot.service.ISysRoleService;
import com.spring.boot.web.respone.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-05-28
 */
@Controller
@RequestMapping("/sysRole")
public class SysRoleController {
@Autowired
private ISysRoleService SysRoleServiceImpl;
private String prefix =  "sysRole";
@RequestMapping(value="/index")
public  String index(){
        return prefix+"/sysRole";
        }
@RequestMapping("/add")
public String add()
        {
        return prefix + "/add";
        }
@RequestMapping(value="/list")
@ResponseBody
public R list(@RequestParam("page") int page, @RequestParam("limit") int limit, SysRole obj){
        Page<SysRole > pagePg=new Page<>(page,limit);
        pagePg= SysRoleServiceImpl.selectPageBySysRole(pagePg,obj);
        R r=R.okList(pagePg);
        return r;
        }
}
