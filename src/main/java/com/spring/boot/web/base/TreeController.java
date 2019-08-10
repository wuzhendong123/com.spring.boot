package com.spring.boot.web.base;

import com.spring.boot.common.domain.Ztree;
import com.spring.boot.entity.Menu;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @program: com.spring.boot
 * @description:
 * @author: zhendong.wu
 * @create: 2019-05-02 23:46
 **/
public class TreeController {

  /*  @RequestMapping(value="/selectTree/{code}")
    public ModelAndView selectMenuTree(@PathVariable("code")  String parentCode){
      //  Menu menu=menuService.selectById(parentCode);
        ModelAndView mav=new ModelAndView(prefix+"/tree");
        //mav.addObject("menu",menu);
        return mav;
    }
    @RequestMapping(value="/treeData")
    @ResponseBody
    public List<Ztree> menuTreeData(){
        List<Ztree> ztrees =menuService.findAllTree();
        return ztrees;
    }*/
}
