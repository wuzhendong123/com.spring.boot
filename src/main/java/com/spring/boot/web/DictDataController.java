package com.spring.boot.web;

import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.DictData;
import com.spring.boot.query.DictDataQuery;
import com.spring.boot.service.IDictDataService;
import com.spring.boot.web.base.BaseController;
import com.spring.boot.web.respone.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @program: com.spring.boot
 * @description:
 * @author: zhendong.wu
 * @create: 2019-04-16 18:47
 **/
@Controller
@RequestMapping(value="/dict/data")
public class DictDataController extends BaseController<DictData,DictDataQuery> {
    @Autowired
    private IDictDataService dictDataService;
    private String prefix = "dict/data";

    @RequestMapping(value="/index/")
    public  String index(){
        return prefix+"/data";
    }

    @RequestMapping(value="/list")
    @ResponseBody
    public R list(@RequestParam("page") int page,@RequestParam("limit") int limit,DictData dictData){
        Page<DictData> pagePg=new Page<>(page,limit);
        pagePg=dictDataService.selectPageByDictData(pagePg,dictData);
        R r=R.okList(pagePg);
        return r;
    }
    @RequestMapping(value="/type/{dictType}")
    @ResponseBody
    public List<DictData> type(@PathVariable("dictType")String dictType){
        List<DictData> dictDatas= dictDataService.selectDictDataByType(dictType);
        return dictDatas;
    }
    @RequestMapping(value="/add/{dictType}")
    public ModelAndView add(@PathVariable("dictType")String dictType){
        ModelAndView mav=new ModelAndView(prefix+"/add");
        mav.addObject("dictType",dictType);
        return mav;
    }
    @RequestMapping(value="/doAdd")
    @ResponseBody
    public R doAdd(DictData dictData){
        dictDataService.insert(dictData);
        return R.ok();
    }
}
