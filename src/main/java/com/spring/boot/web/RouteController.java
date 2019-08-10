package com.spring.boot.web;


import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.ParamHtmlTemple;
import com.spring.boot.entity.Route;
import com.spring.boot.query.ParamHtmlTempleQuery;
import com.spring.boot.service.IRouteService;
import com.spring.boot.service.impl.RouteServiceImpl;
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
 * 规则组 前端控制器
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-04-23
 */
@Controller
@RequestMapping("/route")
public class RouteController {
        @Autowired
        private IRouteService routeService;
        private String prefix = "route";
        private String prefixRule = "rule";
        private String prefixFunRouteTemp = "functionRouteTemple";

        @RequestMapping(value = "/index")
        public String index() {
                return prefix + "/route";
        }

        @RequestMapping("/add")
        public String add() {
                return prefix + "/add";
        }

        @RequestMapping(value = "/list")
        @ResponseBody
        public R list(@RequestParam("page") int page, @RequestParam("limit") int limit, Route obj) {
                Page<Route> pagePg = new Page<>(page, limit);
                pagePg = routeService.selectPageByRoute(pagePg, obj);
                R r = R.okList(pagePg);
                return r;
        }
        //////////////
        @RequestMapping("/doAdd")
        @ResponseBody
        public R doAdd(Route route)
        {
                routeService.insert(route);
                return R.ok();
        }
        @RequestMapping("/addRule/{code}")
        public ModelAndView addRule(@PathVariable("code")  String code)
        {
                ModelAndView mav=new ModelAndView(prefixRule+"/add");
                Route route=routeService.selectById(code);
                mav.addObject("routeCode",route.getCode());
                return  mav;
        }
        @RequestMapping("/addDecide/{code}")
        public ModelAndView addDecide(@PathVariable("code")  String code)
        {
                ModelAndView mav=new ModelAndView(prefixFunRouteTemp+"/add");
                Route route=routeService.selectById(code);
                mav.addObject("refCode",route.getCode());
                return  mav;
        }


        public Logger log = LoggerFactory.getLogger(getClass());
}
