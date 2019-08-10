package com.spring.boot.web;


import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.FunParamHtmlRef;
import com.spring.boot.entity.ParamHtmlTemple;
import com.spring.boot.query.FunParamHtmlRefAggreQuery;
import com.spring.boot.service.IFunParamHtmlRefService;
import com.spring.boot.service.impl.FunParamHtmlRefServiceImpl;
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
 * 函数参数html关系 前端控制器
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-04-20
 */
@Controller
@RequestMapping("/funParamHtmlRef")
public class FunParamHtmlRefController {
    @Autowired
    private IFunParamHtmlRefService funParamHtmlRefService;
    private String prefix = "funParamHtmlRef";

    @RequestMapping(value = "/index")
    public String index() {
        return prefix + "/funParamHtmlRef";
    }

    @RequestMapping("/add/{queryCode}")
    public ModelAndView add(@PathVariable("queryCode") String queryCode) {
        ModelAndView mav=new ModelAndView(prefix+"/add");
        mav.addObject("queryCode",queryCode);
        return mav;
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public R list(@RequestParam("page") int page, @RequestParam("limit") int limit, FunParamHtmlRef obj) {
        Page<FunParamHtmlRef> pagePg = new Page<>(page, limit);
        pagePg = funParamHtmlRefService.selectPageByFunParamHtmlRef(pagePg, obj);
        R r = R.okList(pagePg);
        return r;
    }
    @RequestMapping(value = "/addArray")
    @ResponseBody
    public R addArray(FunParamHtmlRefAggreQuery funParamHtmlRefAggreQuery){
        log.info("-----------------------------------------------funParamHtmlRefAggreQuery {}" ,funParamHtmlRefAggreQuery);
        List<FunParamHtmlRef> funParamHtmlRefs=funParamHtmlRefService.build(funParamHtmlRefAggreQuery);
        funParamHtmlRefService.insertBatch(funParamHtmlRefs);
         return R.ok();
    }
    @RequestMapping("/edit/{code}")
    @ResponseBody
    public ModelAndView edit(@PathVariable("code") String code)
    {
        ModelAndView mav=new ModelAndView(prefix+"/edit");
        FunParamHtmlRef funParamHtmlRef=  funParamHtmlRefService.selectById(code);
        mav.addObject("funParamHtmlRef", funParamHtmlRef);
        return mav;
    }
    //虽然是数组但是只有一个
    @RequestMapping(value = "/doEdit")
    @ResponseBody
    public R doEdit(FunParamHtmlRefAggreQuery funParamHtmlRefAggreQuery){
        log.info("-----funParamHtmlRefAggreQuery---- {}" ,funParamHtmlRefAggreQuery);
        List<FunParamHtmlRef> funParamHtmlRefs=funParamHtmlRefService.build(funParamHtmlRefAggreQuery);
        FunParamHtmlRef funParamHtmlRef=funParamHtmlRefs.get(0);
        FunParamHtmlRef funParamHtmlRefDB=funParamHtmlRefService.selectById(funParamHtmlRef.getCode());
        BeanUtil.copyPropertiesIgnoreNull(funParamHtmlRef,funParamHtmlRefDB);
        funParamHtmlRefService.updateById(funParamHtmlRefDB);
        return R.ok();
    }
    //虽然是数组但是只有一个
    @RequestMapping(value = "/doAdd")
    @ResponseBody
    public R doAdd(FunParamHtmlRefAggreQuery funParamHtmlRefAggreQuery){
        return addArray(funParamHtmlRefAggreQuery);
    }
    public Logger log = LoggerFactory.getLogger(getClass());
}
