package com.spring.boot.web;


import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.SysRolePermissionsRef;
import com.spring.boot.service.ISysRolePermissionsRefService;
import com.spring.boot.web.respone.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 角色和权限关系 前端控制器
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-05-28
 */
@Controller
@RequestMapping("/sysRolePermissionsRef")
public class SysRolePermissionsRefController {
@Autowired
private ISysRolePermissionsRefService SysRolePermissionsRefServiceImpl;
private String prefix =  "sysRolePermissionsRef";
@RequestMapping(value="/index")
public  String index(){
        return prefix+"/sysRolePermissionsRef";
        }
@RequestMapping("/add")
public String add()
        {
        return prefix + "/add";
        }
@RequestMapping(value="/list")
@ResponseBody
public R list(@RequestParam("page") int page, @RequestParam("limit") int limit, SysRolePermissionsRef obj){
        Page<SysRolePermissionsRef > pagePg=new Page<>(page,limit);
        pagePg= SysRolePermissionsRefServiceImpl.selectPageBySysRolePermissionsRef(pagePg,obj);
        R r=R.okList(pagePg);
        return r;
        }
}
