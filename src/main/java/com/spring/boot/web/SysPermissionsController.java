package com.spring.boot.web;


import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.SysPermissions;
import com.spring.boot.service.ISysPermissionsService;
import com.spring.boot.util.BeanUtil;
import com.spring.boot.web.respone.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * 权限校验 前端控制器
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-11-05
 */
@Controller
@RequestMapping("/sys/permissions")
public class SysPermissionsController {
@Autowired
private ISysPermissionsService sysPermissionsService;
private String prefix="sys/permissions";
@RequestMapping(value = "/index")
public  String index(){
        return prefix+"/permissions";
        }
@RequestMapping("/add")
public String add()
        {
        return prefix+"/add";
        }
@RequestMapping(value = "/list")
@ResponseBody
public R list(@RequestParam("page") int page, @RequestParam("limit") int limit, SysPermissions obj){
        Page<SysPermissions > pagePg=new Page<>(page,limit);
        pagePg= sysPermissionsService.selectPageBySysPermissions(pagePg,obj);
        R r=R.okList(pagePg);
        return r;
        }

@RequestMapping("/edit/{code}")
public ModelAndView edit(@PathVariable("code") String code){
        ModelAndView mav=new ModelAndView(prefix+"/edit");
    SysPermissions entity=  sysPermissionsService.selectById(code);
        mav.addObject("entity",entity);
        return mav;
        }

@RequestMapping(value = "/doEdit")
@ResponseBody
public R doEdit(SysPermissions entity){
    SysPermissions entityDB=sysPermissionsService.selectById(entity.getCode());
        BeanUtil.copyPropertiesIgnoreNull(entity,entityDB);
    sysPermissionsService.updateById(entityDB);
        R r = R.ok();
        return r;

        }
@RequestMapping(value = "/doAdd")
@ResponseBody
public R doAdd(SysPermissions entity){
    sysPermissionsService.insert(entity);
        R r = R.ok();
        return r;

        }
        }
