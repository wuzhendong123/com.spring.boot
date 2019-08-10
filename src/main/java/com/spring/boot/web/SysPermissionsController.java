package com.spring.boot.web;


import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.SysPermissions;
import com.spring.boot.service.ISysPermissionsService;
import com.spring.boot.web.respone.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 权限校验 前端控制器
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-05-28
 */
@Controller
@RequestMapping("/sysPermissions")
public class SysPermissionsController {
@Autowired
private ISysPermissionsService SysPermissionsServiceImpl;
private String prefix =  "sysPermissions";
@RequestMapping(value="/index")
public  String index(){
        return prefix+"/sysPermissions";
        }
@RequestMapping("/add")
public String add()
        {
        return prefix + "/add";
        }
@RequestMapping(value="/list")
@ResponseBody
public R list(@RequestParam("page") int page, @RequestParam("limit") int limit, SysPermissions obj){
        Page<SysPermissions > pagePg=new Page<>(page,limit);
        pagePg= SysPermissionsServiceImpl.selectPageBySysPermissions(pagePg,obj);
        R r=R.okList(pagePg);
        return r;
        }
}
