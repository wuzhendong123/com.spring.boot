package com.spring.boot.web;


import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.common.domain.Ztree;
import com.spring.boot.entity.FunctionRuleRef;
import com.spring.boot.entity.ReturnResultRuleRef;
import com.spring.boot.entity.Route;
import com.spring.boot.entity.Rule;
import com.spring.boot.enums.StatusEnum;
import com.spring.boot.query.RuleQuery;
import com.spring.boot.query.request.FunctionRuleRefAggreRequest;
import com.spring.boot.query.request.ReturnResultAggRequet;
import com.spring.boot.query.request.RuleAggreRequest;
import com.spring.boot.query.respone.RuleBean;
import com.spring.boot.service.IFunctionRuleRefService;
import com.spring.boot.service.IReturnResultRuleRefService;
import com.spring.boot.service.IReturnResultTempleService;
import com.spring.boot.service.IRuleService;
import com.spring.boot.service.impl.RuleServiceImpl;
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
 * 定义规则(组)执行一组表达式 前端控制器
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-04-23
 */
@Controller
@RequestMapping("/rule")
public class RuleController {
    @Autowired
    private IRuleService ruleService;
    @Autowired
    private IFunctionRuleRefService functionRuleRefService;
    @Autowired
    private IReturnResultRuleRefService returnResultRuleRefService;


    private String prefix = "rule";

    @RequestMapping(value = "/index")
    public String index() {
        return prefix + "/rule";
    }

    @RequestMapping("/add")
    public String add() {
        return prefix + "/add";
    }


    @RequestMapping("/edit/{code}")
    public ModelAndView edit(@PathVariable("code") String code) {
        ModelAndView mav=new ModelAndView(prefix+"/edit");
        Rule rule= ruleService.selectById(code);
        String parentRuleCode=rule.getParentRuleCode();
        if(parentRuleCode!=null){
           Rule parentRule= ruleService.selectById(parentRuleCode);
            mav.addObject("parentRule",parentRule);
        }
        mav.addObject("rule",rule);
        mav.addObject("routeCode",rule.getRouteCode());
        List<FunctionRuleRef>  functionRuleRefs= functionRuleRefService.selectByRuleCode(rule.getCode(),StatusEnum.TRUE.name());
        List<FunctionRuleRefAggreRequest> functionRuleRefAggreRequests=  functionRuleRefService.buildByfunctionRuleRef(functionRuleRefs);
        mav.addObject("functionRuleRefAggreRequests",functionRuleRefAggreRequests);
        List<ReturnResultRuleRef>  returnResultRuleRefs= returnResultRuleRefService.selectByRuleCode(rule.getCode(),StatusEnum.TRUE.name());
        List<ReturnResultAggRequet> returnResultAggRequets=returnResultRuleRefService.buildByReturnResultRuleRef(returnResultRuleRefs);
        mav.addObject("returnResultAggRequets",returnResultAggRequets);
        return mav;
    }


    @RequestMapping(value = "/list")
    @ResponseBody
    public List<RuleBean> list(RuleQuery ruleQuery) {
        Page<RuleBean> pagePg = new Page<>(1, 1000);
        pagePg = ruleService.selectPageByRuleQuery(pagePg, ruleQuery);
        return pagePg.getRecords();
    }
    @RequestMapping("/addChild/{code}")
    public ModelAndView addRule(@PathVariable("code")  String code)
    {
        ModelAndView mav=new ModelAndView(prefix+"/add");
        Rule rule=ruleService.selectById(code);
        mav.addObject("parentRule",rule);
        mav.addObject("routeCode",rule.getRouteCode());
        return  mav;
    }

    @RequestMapping(value = "/doAdd")
    @ResponseBody
    public R doAdd(RuleAggreRequest ruleAggreRequest) {
        Rule rule= ruleAggreRequest.getRule();
        ruleService.insert(rule);
        FunctionRuleRefAggreRequest[]   functionRuleRefAggreRequests=ruleAggreRequest.getFunRouAggRequet();

        List<FunctionRuleRef> functionRuleRefs=functionRuleRefService.buld(rule.getCode(),functionRuleRefAggreRequests);
        functionRuleRefService.insertBatch(functionRuleRefs);


        List<ReturnResultRuleRef> returnResultRuleRefs= returnResultRuleRefService.bulid(rule.getCode(),ruleAggreRequest.getReturnResultAggRequet());
        returnResultRuleRefService.insertBatch(returnResultRuleRefs);
        R r = R.ok();
        return r;
    }
    @RequestMapping(value = "/doEdit")
    @ResponseBody
    public R doEdit(RuleAggreRequest ruleAggreRequest) {
        Rule rule= ruleAggreRequest.getRule();
        Rule ruleDB=ruleService.selectById(rule.getCode());
        BeanUtil.copyPropertiesIgnoreNull(rule,ruleDB);
        ruleService.updateById(ruleDB);

        FunctionRuleRefAggreRequest[]   functionRuleRefAggreRequests=ruleAggreRequest.getFunRouAggRequet();

        List<FunctionRuleRef> functionRuleRefs=functionRuleRefService.buld(rule.getCode(),functionRuleRefAggreRequests);
        functionRuleRefService.createUpdateBatch(rule.getCode(),functionRuleRefs);

        List<ReturnResultRuleRef> returnResultRuleRefs= returnResultRuleRefService.bulid(rule.getCode(),ruleAggreRequest.getReturnResultAggRequet());

        returnResultRuleRefService.createUpdateBatch(rule.getCode(),returnResultRuleRefs);
        R r = R.ok();
        return r;
    }
//--------树状----
    @RequestMapping(value="/selectTree/{code}")
    public ModelAndView selectMenuTree(@PathVariable("code")  String code){
        //  Menu menu=menuService.selectById(parentCode);
        Rule rule= ruleService.selectById(code);
        Ztree ztree=new Ztree();
        ztree.setId(rule.getCode());
        ztree.setName(rule.getName());
        ModelAndView mav=new ModelAndView(prefix+"/tree");
        mav.addObject("tree",ztree);
        mav.addObject("prefix",prefix);
        mav.addObject("treeTopCode",rule.getRouteCode());
        return mav;
    }
    @RequestMapping(value="/treeData/{treeTopCode}")
    @ResponseBody
    public List<Ztree> menuTreeData(@PathVariable("treeTopCode")String treeTopCode){
        List<Ztree> ztrees =ruleService.findByRouteAllTree(treeTopCode);
        return ztrees;
    }
}
