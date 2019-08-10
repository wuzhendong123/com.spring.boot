package com.spring.boot.web;


import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.DictType;
import com.spring.boot.entity.ParamHtmlTemple;
import com.spring.boot.entity.QueryFunction;
import com.spring.boot.query.ParamHtmlTempleQuery;
import com.spring.boot.query.base.ParamQuery;
import com.spring.boot.service.IQueryFunctionService;
import com.spring.boot.service.common.SqlCommonService;
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

/**
 * <p>
 * sql函数执行表达式 前端控制器
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-04-20
 */
@Controller
@RequestMapping("/queryfunction")
public class QueryFunctionController {
    public Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private IQueryFunctionService queryFunctionService;
    @Autowired
    private SqlCommonService sqlCommonService;
    private String prefix = "queryfunction/";

    @RequestMapping(value = "/index")
    public String index() {
        return prefix + "/queryfunction";
    }

    @RequestMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public R list(@RequestParam("page") int page, @RequestParam("limit") int limit, QueryFunction queryFunction) {
        Page<QueryFunction> pagePg = new Page<>(page, limit);
        pagePg = queryFunctionService.selectPageByQueryFunction(pagePg, queryFunction);
        R r = R.okList(pagePg);
        return r;
    }

    @RequestMapping("/doAdd")
    @ResponseBody
    public R doAdd(QueryFunction queryFunction) {
        boolean result = queryFunctionService.insert(queryFunction);
        if (result) {
            sqlCommonService.bulid(queryFunction.getExpress(), queryFunction.getCode());
            return R.ok();
        }

        return R.error();
    }

    //----------以上通用----------------
    @RequestMapping("/addQuery/{code}")
    public ModelAndView addQuery(@PathVariable("code") String code) {
        ModelAndView mav = new ModelAndView(prefix + "/addQuery");

        QueryFunction queryFunction = queryFunctionService.selectById(code);
        ParamQuery[] paramQuerys = queryFunctionService.expAnalysisQuery(queryFunction.getExpress());
        mav.addObject("queryFunction", queryFunction);
        mav.addObject("paramQuerys", paramQuerys);
        log.info("paramQuerys size {} ", paramQuerys.length);
        return mav;
    }

    @RequestMapping("/edit/{code}")
    @ResponseBody
    public ModelAndView edit(@PathVariable("code") String code) {
        ModelAndView mav = new ModelAndView(prefix + "/edit");
        QueryFunction queryFunction = queryFunctionService.selectById(code);
        mav.addObject("queryFunction", queryFunction);
        return mav;
    }

    @RequestMapping("/doEdit")
    @ResponseBody
    public R edit(QueryFunction queryFunction) {
        QueryFunction queryFunctionDB = queryFunctionService.selectById(queryFunction.getCode());
        BeanUtil.copyPropertiesIgnoreNull(queryFunction, queryFunctionDB);
        boolean result = queryFunctionService.updateById(queryFunctionDB);
        if (result) {
            sqlCommonService.reset(queryFunctionDB.getExpress(), queryFunctionDB.getCode());
            return R.ok();
        }

        return R.error();
    }
}

