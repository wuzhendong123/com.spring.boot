package com.spring.boot.web;

import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.DictType;
import com.spring.boot.entity.ParamHtmlTemple;
import com.spring.boot.query.DictTypeQuery;
import com.spring.boot.query.ParamHtmlTempleQuery;
import com.spring.boot.service.IDictTypeService;
import com.spring.boot.service.IParamHtmlTempleService;
import com.spring.boot.util.BeanUtil;
import com.spring.boot.web.base.BaseController;
import com.spring.boot.web.respone.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: com.spring.boot
 * @description:
 * @author: zhendong.wu
 * @create: 2019-04-16 18:47
 **/
@Controller
@RequestMapping(value="/paramHtmlTemple")
public class ParamHtmlTempleController extends BaseController<ParamHtmlTemple,ParamHtmlTempleQuery> {
    @Autowired
    private IParamHtmlTempleService paramHtmlTempleService;
    private String prefix = "paramHtmlTemple";
    @RequestMapping(value="/index")
    public  String index(){
        return prefix+"/paramHtmlTemple";
    }

    @RequestMapping(value="/list")
    @ResponseBody
    public R list(@RequestParam("page") int page,@RequestParam("limit") int limit,ParamHtmlTemple dictType){
        Page<ParamHtmlTemple> pagePg=new Page<>(page,limit);
        pagePg= paramHtmlTempleService.selectPageByParamHtmlTemple(pagePg,dictType);
       // dictTypeService.selectPage(pagePg);
        R r=R.okList(pagePg);
        return r;
    }
    @RequestMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }
    @RequestMapping("/doAdd")
    @ResponseBody
    public R doAdd(ParamHtmlTempleQuery paramHtmlTempleQuery)
    {
        log.info(paramHtmlTempleQuery.toString());
        ParamHtmlTemple paramHtmlTemple=  paramHtmlTempleService.bulid(paramHtmlTempleQuery);
        paramHtmlTempleService.insert(paramHtmlTemple);
        return R.ok();
    }
    @RequestMapping("/edit/{code}")
    @ResponseBody
    public ModelAndView edit(@PathVariable("code") String code)
    {
        ModelAndView mav=new ModelAndView(prefix+"/edit");
        ParamHtmlTemple paramHtmlTemple=  paramHtmlTempleService.selectById(code);
        mav.addObject("paramHtmlTemple", paramHtmlTemple);
        return mav;
    }
    @RequestMapping("/doEdit")
    @ResponseBody
    public R edit(ParamHtmlTempleQuery paramHtmlTempleQuery)
    {
        ParamHtmlTemple paramHtmlTemple=  paramHtmlTempleService.bulid(paramHtmlTempleQuery);
        ParamHtmlTemple paramHtmlTempleDB=  paramHtmlTempleService.selectById(paramHtmlTempleQuery.getCode());
        BeanUtil.copyPropertiesIgnoreNull(paramHtmlTemple,paramHtmlTempleDB);
        paramHtmlTempleService.updateById(paramHtmlTempleDB);
        return R.ok();
    }




}
