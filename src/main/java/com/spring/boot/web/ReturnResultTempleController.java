package com.spring.boot.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.FunctionRuleRef;
import com.spring.boot.entity.ReturnResultRuleRef;
import com.spring.boot.entity.ReturnResultTemple;
import com.spring.boot.entity.Rule;
import com.spring.boot.enums.StatusEnum;
import com.spring.boot.query.request.FunctionRuleRefAggreRequest;
import com.spring.boot.query.request.ReturnResultAggRequet;
import com.spring.boot.service.IReturnResultTempleService;
import com.spring.boot.util.BeanUtil;
import com.spring.boot.web.respone.R;
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
 * 返回结果模板 前端控制器
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-05-04
 */
@Controller
@RequestMapping("/returnResultTemple")
public class ReturnResultTempleController {
    @Autowired
    private IReturnResultTempleService returnResultTempleService;
    private String prefix = "returnResultTemple";

    @RequestMapping(value = "/index")
    public String index() {
        return prefix + "/returnResultTemple";
    }

    @RequestMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    @RequestMapping("/doAdd")
    @ResponseBody
    public R doAdd(ReturnResultTemple returnResultTemple) {
        returnResultTempleService.insert(returnResultTemple);
    return R.ok();
    }
    @RequestMapping("/edit/{code}")
    public ModelAndView edit(@PathVariable("code") String code) {
        ModelAndView mav=new ModelAndView(prefix+"/edit");
        ReturnResultTemple returnResultTemple= returnResultTempleService.selectById(code);
        mav.addObject("returnResultTemple",returnResultTemple);
        return mav;
    }
    @RequestMapping("/doEdit")
    @ResponseBody
    public R doEdit(ReturnResultTemple returnResultTemple){
        ReturnResultTemple returnResultTempleDB=returnResultTempleService.selectById(returnResultTemple.getCode());
        BeanUtil.copyPropertiesIgnoreNull(returnResultTemple,returnResultTempleDB);
        returnResultTempleService.updateById(returnResultTempleDB);
        return R.ok();
    }


    @RequestMapping(value = "/list")
    @ResponseBody
    public R list(@RequestParam("page") int page, @RequestParam("limit") int limit, ReturnResultTemple obj) {
        Page<ReturnResultTemple> pagePg = new Page<>(page, limit);
        pagePg = returnResultTempleService.selectPageByReturnResultTemple(pagePg, obj);
        R r = R.okList(pagePg);
        return r;
    }
    @RequestMapping(value = "/findResultRuleTemple/type/{type}")
    public ModelAndView findResultRuleTempleByType(@PathVariable("type") String type) {
        ModelAndView modelAndView=new ModelAndView(prefix + "/returnTemple");
        Wrapper wrapper=new EntityWrapper<ReturnResultTemple>();
        wrapper.where("type={0}",type);
        List<ReturnResultTemple> returnResultTempleList= returnResultTempleService.selectList(wrapper);
        modelAndView.addObject("returnResultTempleList",returnResultTempleList);
        return modelAndView;
    }

}
