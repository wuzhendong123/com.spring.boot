package com.spring.boot.web;


import com.spring.boot.entity.SysRolePermissionsRef;
import com.spring.boot.service.ISysRolePermissionsRefService;
import com.spring.boot.util.BeanUtil;
import com.spring.boot.web.respone.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * 角色和权限关系 前端控制器
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-11-02
 */
@Controller
@RequestMapping("/sys/rolePermissionsRef")
public class SysRolePermissionsRefController {
    @Autowired
    private ISysRolePermissionsRefService sysRolePermissionsRefService;
    private String prefix = "/sys/rolePermissionsRef";

    @RequestMapping(value = "/index")
    public String index() {
        return prefix + "/rolePermissionsRef";
    }

    @RequestMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public R list(@RequestParam("page") int page, @RequestParam("limit") int limit, SysRolePermissionsRef obj) {
        Page<SysRolePermissionsRef> pagePg = new Page<>(page, limit);
        pagePg = sysRolePermissionsRefService.selectPageBySysRolePermissionsRef(pagePg, obj);
        R r = R.okList(pagePg);
        return r;
    }

    @RequestMapping("/edit/{code}")
    public ModelAndView edit(@PathVariable("code") String code) {
        ModelAndView mav = new ModelAndView(prefix + "/edit");
        SysRolePermissionsRef entity = sysRolePermissionsRefService.selectById(code);
        mav.addObject("entity", entity);
        return mav;
    }

    @RequestMapping(value = "/doEdit")
    @ResponseBody
    public R doEdit(SysRolePermissionsRef entity) {
        SysRolePermissionsRef entityDB = sysRolePermissionsRefService.selectById(entity.getCode());
        BeanUtil.copyPropertiesIgnoreNull(entity, entityDB);
        sysRolePermissionsRefService.updateById(entityDB);
        R r = R.ok();
        return r;

    }

    @RequestMapping(value = "/doAdd")
    @ResponseBody
    public R doAdd(SysRolePermissionsRef entity) {
        sysRolePermissionsRefService.insert(entity);
        R r = R.ok();
        return r;

    }
}
