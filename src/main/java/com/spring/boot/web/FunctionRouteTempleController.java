package com.spring.boot.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.FunctionRouteTemple;
import com.spring.boot.service.IFunctionRouteTempleService;
import com.spring.boot.util.BeanUtil;
import com.spring.boot.web.respone.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <p>
 * 函数模板定义 前端控制器
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-04-30
 */
@Controller
@RequestMapping("/functionRouteTemple")
public class FunctionRouteTempleController {
    @Autowired
    private IFunctionRouteTempleService functionRouteTempleService;
    private static String prefix = "functionRouteTemple";

    @RequestMapping(value = "/index")
    public String index() {
        return prefix + "/functionRouteTemple";
    }

    @RequestMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public R list(@RequestParam("page") int page, @RequestParam("limit") int limit, FunctionRouteTemple obj) {
        Page<FunctionRouteTemple> pagePg = new Page<>(page, limit);
        pagePg = functionRouteTempleService.selectPageByFunctionRouteTemple(pagePg, obj);
        R r = R.okList(pagePg);
        return r;
    }
    @RequestMapping("/edit/{code}")
    public ModelAndView edit(@PathVariable("code") String code) {
        ModelAndView mav=new ModelAndView(prefix+"/edit");
        FunctionRouteTemple functionRouteTemple =  functionRouteTempleService.selectById(code);
        mav.addObject("functionRouteTemple", functionRouteTemple);
        return mav;
    }

    @RequestMapping(value = "/findFunTemple/{routeCode}")
    public ModelAndView findFunTemple(@PathVariable("routeCode") String routeCode) {
        ModelAndView modelAndView=new ModelAndView(prefix + "/funTemple");
        Wrapper wrapper=new EntityWrapper<FunctionRouteTemple>();
        wrapper.where("ref_code={0}",routeCode);
       List<FunctionRouteTemple> functionRouteTempleList = functionRouteTempleService.selectList(wrapper);
       log.info("functionRouteTempleList size {} ", functionRouteTempleList.size());
        modelAndView.addObject("functionRouteTempleList", functionRouteTempleList);
        return modelAndView;
    }
    @RequestMapping(value = "/doAdd")
    @ResponseBody
    public R doAdd(FunctionRouteTemple obj) {
        functionRouteTempleService.insert(obj);
        return R.ok();
    }
    @RequestMapping(value = "/doEdit")
    @ResponseBody
    public R doEdit(FunctionRouteTemple obj) {
        FunctionRouteTemple functionRouteTempleDB = functionRouteTempleService.selectById(obj.getCode());
        BeanUtil.copyPropertiesIgnoreNull(obj, functionRouteTempleDB);
        functionRouteTempleService.updateById(functionRouteTempleDB);
        return R.ok();
    }

    public Logger log = LoggerFactory.getLogger(getClass());

}
