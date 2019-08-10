package com.spring.boot.web;

import com.spring.boot.entity.Menu;
import com.spring.boot.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: com.spring.boot
 * @description:
 * @author: zhendong.wu
 * @create: 2019-01-26 16:28
 **/
@Controller
public class IndexController {
    @Autowired
    private IMenuService menuService;
    @RequestMapping("/index")
    public  String index(ModelMap mmap){

        List<Menu>  menus=menuService.findAll();
        Menu rootMenu=menuService.findRootMenu();
        rootMenu=  sortByParent(menus,rootMenu);
        mmap.put("menus", rootMenu.getChildMenus());
        return "index";
    }
    public Menu sortByParent(List<Menu>  menus,Menu parentMenu){
        List<Menu> childMenus=new ArrayList<>();
        for(Menu childmenu:menus ){
                if(parentMenu.getCode().equals(childmenu.getParentCode())){
                    childMenus.add(sortByParent(menus,childmenu));
                }
        }
        parentMenu.setChildMenus(childMenus);
        return parentMenu;
    }
}
