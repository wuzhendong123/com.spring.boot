package com.spring.boot.web;


import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.SysRole;
import com.spring.boot.service.ISysRoleService;
import com.spring.boot.util.BeanUtil;
import com.spring.boot.web.respone.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-05-28
 */
@Controller
@RequestMapping("/sys/role")
public class SysRoleController {
    @Autowired
    private ISysRoleService sysRoleService;
    private String prefix = "/sys/role";

    @RequestMapping(value = "/index")
    public String index() {
        return prefix + "/role";
    }

    @RequestMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public R list(@RequestParam("page") int page, @RequestParam("limit") int limit, SysRole obj) {
        Page<SysRole> pagePg = new Page<>(page, limit);
        pagePg = sysRoleService.selectPageBySysRole(pagePg, obj);
        R r = R.okList(pagePg);
        return r;
    }
    @RequestMapping("/edit/{code}")
    public ModelAndView edit(@PathVariable("code") String code){
        ModelAndView mav=new ModelAndView(prefix+"/edit");
        SysRole entity= sysRoleService.selectById(code);
        mav.addObject("entity",entity);
        return mav;
    }


    @RequestMapping(value = "/doEdit")
    @ResponseBody
    public R doEdit(SysRole entity){
        SysRole entityDB=sysRoleService.selectById(entity.getCode());
        BeanUtil.copyPropertiesIgnoreNull(entity,entityDB);
        sysRoleService.updateById(entityDB);
        R r = R.ok();
        return r;

    }
    @RequestMapping(value = "/doAdd")
    @ResponseBody
    public R doAdd(SysRole entity){
        sysRoleService.insert(entity);
        R r = R.ok();
        return r;

    }

}
