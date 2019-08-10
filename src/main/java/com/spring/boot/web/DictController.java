package com.spring.boot.web;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.DictType;
import com.spring.boot.entity.Student;
import com.spring.boot.query.DictTypeQuery;
import com.spring.boot.query.MenuQuery;
import com.spring.boot.service.IDictTypeService;
import com.spring.boot.util.BeanUtil;
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
@RequestMapping(value="/dict/type")
public class DictController extends BaseController<DictType,DictTypeQuery> {
    @Autowired
    private IDictTypeService dictTypeService;
    private String prefix = "dict/type";
    private String prefixDictData = "dict/data";
    @RequestMapping(value="/index")
    public  String index(){
        return prefix+"/type";
    }

    @RequestMapping(value="/list")
    @ResponseBody
    public R list(@RequestParam("page") int page,@RequestParam("limit") int limit,DictType dictType){
        Page<DictType> pagePg=new Page<>(page,limit);
        pagePg= dictTypeService.selectPageByDictType(pagePg,dictType);
       // dictTypeService.selectPage(pagePg);
        R r=R.okList(pagePg);
        return r;
    }

    @RequestMapping(value="/edit/{code}")
    public ModelAndView edit(@PathVariable("code")String code){
        DictType dictType= dictTypeService.selectById(code);
        ModelAndView mav=new ModelAndView(prefix+"/edit");
        mav.addObject("dictType",dictType);
        return mav;
    }
    @RequestMapping(value="/doEdit")
    @ResponseBody
    public R edit(DictType dictType){
        DictType dictTypeDB= dictTypeService.selectById(dictType.getCode());
        BeanUtil.copyPropertiesIgnoreNull(dictType,dictTypeDB);
        dictTypeService.updateById(dictTypeDB);
        return R.ok();
    }

    @RequestMapping(value="/add")
    public ModelAndView add(){
        ModelAndView mav=new ModelAndView(prefix+"/add");
        return mav;
    }
    @RequestMapping(value="/doAdd")
    @ResponseBody
    public R  doAdd(DictType dictType){
        dictTypeService.insert(dictType);
        return R.ok();
    }
    @RequestMapping(value="/checkDictTypeUnique")
    @ResponseBody
    public Boolean checkDictTypeUnique(DictType dictType){
        return dictTypeService.checkDictTypeUnique(dictType);
    }

    @RequestMapping(value="/data/{code}")
    public ModelAndView data(@PathVariable("code")String code){
        ModelAndView mav=new ModelAndView(prefixDictData+"/data");
        DictType dictType= dictTypeService.selectById(code);
        mav.addObject("dictType",dictType);
        return mav;
    }

}
