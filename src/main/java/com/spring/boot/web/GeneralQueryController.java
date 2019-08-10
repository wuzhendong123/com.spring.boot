package com.spring.boot.web;


import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.common.domain.Col;
import com.spring.boot.entity.FunParamHtmlRef;
import com.spring.boot.entity.QueryFunction;
import com.spring.boot.service.*;
import com.spring.boot.service.common.GeneraExportService;
import com.spring.boot.web.base.BaseController;
import com.spring.boot.web.respone.R;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 通用查询前端控制器
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-04-20
 */
@Controller
@RequestMapping("/generalQuery")
public class GeneralQueryController extends BaseController {
    @Autowired
    private IQueryFunctionService queryFunctionService;
    @Autowired
    private IFunParamHtmlRefService funParamHtmlRefService;

    @Autowired
    private GeneralQueryService generalQueryService;

    private String prefix = "generalQuery";

    @RequestMapping(value = "/index")
    public String index() {
        return prefix + "/generalQuery";
    }

    @RequestMapping(value="/list")
    @ResponseBody
    public R list(@RequestParam("page") int page, @RequestParam("limit") int limit, QueryFunction queryFunction){
        Page<QueryFunction> pagePg=new Page<>(page,limit);
        pagePg= queryFunctionService.selectPageByQueryFunction(pagePg,queryFunction);
        R r=R.okList(pagePg);
        return r;
    }
    @RequestMapping(value = "/run/{code}")
    public ModelAndView run(@PathVariable("code") String code) {
        ModelAndView modelAndView=new ModelAndView(prefix + "/run");
        QueryFunction queryFunction=queryFunctionService.selectById(code);
        modelAndView.addObject("queryFunction",queryFunction);
       List< FunParamHtmlRef>   funParamHtmlRefs= funParamHtmlRefService.selectByFunCode(code);
        modelAndView.addObject("funParamHtmlRefs",funParamHtmlRefs);
        generalQueryService.bulid(queryFunction);
        return modelAndView;
    }
    @RequestMapping(value = "/paramRun/{code}")
    public ModelAndView paramRun(@PathVariable("code") String code) {
        ModelAndView modelAndView=new ModelAndView(prefix + "/paramRun");
        QueryFunction queryFunction=queryFunctionService.selectById(code);
        modelAndView.addObject("queryFunction",queryFunction);
        List< FunParamHtmlRef>   funParamHtmlRefs= funParamHtmlRefService.selectByFunCode(code);
        modelAndView.addObject("funParamHtmlRefs",funParamHtmlRefs);
        generalQueryService.bulid(queryFunction);
        return modelAndView;
    }
    @RequestMapping(value = "/generalFind/{code}")
    @ResponseBody
    public R generalFind(@RequestParam("page") int page, @RequestParam("limit") int limit,@PathVariable("code") String code,HttpServletRequest request){
        Page pagePg=new Page<>(page,limit);
        Object map=generalQuery(pagePg,code,request);
        log.info("----map----{}",map);
        pagePg=   generalQueryService.generalFind(code,map,pagePg);
        R r=R.okList(pagePg);
        return r;
    }


    @RequestMapping(value = "/export/{code}")
    public void export(@PathVariable("code") String code, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Page pagePg=new Page<>(1,2);
        Object map=generalQuery(pagePg,code,request);
        pagePg=   generalQueryService.generalFind(code,map,pagePg);
        long total= pagePg.getTotal();
            if(total>20000){
                response.getOutputStream().write("超过限制导出条数限制".getBytes());
                return;
            }
        GeneraExportService generaExportService=new GeneraExportService(request,map,this.generalQueryService,code);
        Workbook workbook=generaExportService.export();
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition",
                "attachment;fileName=" + code+".xlsx");
        workbook.write(response.getOutputStream());
        return ;
    }


    public Object generalQuery(Page pagePg,String code,HttpServletRequest request){
        Object map;

        try {
            long  startTime=System.currentTimeMillis();
            map= this.resolveArgument(request);
        } catch (Exception e) {
            log.error("generalQuery error code {}",code,e);
            return pagePg;
        }

        map=generalQueryService.generalQueryObj(request, code,map);
        return map;
    }


    public Col[][] findArrayByFunCtion(String code){
        log.info("findColByFunCtion code {}",code);
        Col[][] cols=new Col[1][];

        cols[0]=findColByFunCtion(code);
        return cols;
    }
    public Col[] findColByFunCtion(String code){
        Col[] cols=  generalQueryService.findColByFunCtion( code);

        return cols;
    }
    public Logger log = LoggerFactory.getLogger(getClass());
}
