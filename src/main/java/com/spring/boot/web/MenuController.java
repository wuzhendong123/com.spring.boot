package com.spring.boot.web;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.common.domain.Ztree;
import com.spring.boot.entity.Menu;
import com.spring.boot.query.MenuQuery;
import com.spring.boot.query.MenuRequestQuery;
import com.spring.boot.service.IMenuService;
import com.spring.boot.util.BeanUtil;
import com.spring.boot.web.base.BaseController;
import com.spring.boot.web.respone.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="/menu")
public class MenuController extends BaseController<Menu,MenuQuery> {
	@Autowired
	private IMenuService menuService;
	private String prefix = "menu";

	@RequestMapping(value="/index")
	public String index() {

		return prefix+"/menu";
	}

	@RequestMapping(value="/add/{code}")
	public ModelAndView add(@PathVariable("code") String code) {

		Menu menu = menuService.selectById(code);

		ModelAndView mav=new ModelAndView("/menu/add");
		mav.addObject("menu", menu);
		return mav;
	}
	@PostMapping("/add")
	@ResponseBody
	public R addSave(Menu menu)
	{
		menuService.insert(menu);
		return R.ok();
	}

	@RequestMapping(value="/path")
	public Page<MenuQuery> findByPath(@RequestParam("path") String path,@RequestParam(defaultValue = "1") Integer current,@RequestParam(defaultValue = "10") Integer size){
		Page<Menu> page=new Page<>(current,size);
		page=menuService.findByPath(page,path);

		return transfer(page,MenuQuery.class);
	}
	@RequestMapping(value="/query")
	public ModelAndView query(MenuRequestQuery menuRequestQuery) {
		Page<Menu> page=new Page<>(menuRequestQuery.getPage(),menuRequestQuery.getSize());
		EntityWrapper<Menu> entityWrapper=new EntityWrapper<>();
		entityWrapper.like("name",menuRequestQuery.getName());
		page =menuService.selectPage(page,entityWrapper);
		ModelAndView mav=new ModelAndView("/menu/list");
//		ModelAndView mav=new ModelAndView("menu/index");

		mav.addObject("page",page);
		return mav;
	}
	@RequestMapping(value="/list")
	@ResponseBody
	public List<Menu> list(Menu menu) {
		List<Menu>  listMenu=menuService.findMenuList(menu);
		return listMenu;
	}
	@RequestMapping(value="/edit/{code}")
	public ModelAndView edit(@PathVariable("code") String code){
		Menu menu=menuService.selectById(code);
		Menu menuParent = menuService.selectById(menu.getParentCode());
		ModelAndView mav=new ModelAndView(prefix+"/edit");
		mav.addObject("menu",menu);
		mav.addObject("menuParent", menuParent);
		return mav;
	}
	@RequestMapping(value="/edit")
	@ResponseBody
	public R edit(Menu menu){
		Menu menuDB=menuService.selectById(menu.getCode());
        BeanUtil.copyPropertiesIgnoreNull(menu,menuDB);
		menuService.updateById(menuDB);
		return R.ok();
	}

	@RequestMapping(value="/selectMenuTree/{code}")
	public ModelAndView selectMenuTree(@PathVariable("code")  String parentCode){
		Menu menu=menuService.selectById(parentCode);
		ModelAndView mav=new ModelAndView(prefix+"/tree");
		mav.addObject("menu",menu);
		return mav;
	}
    @RequestMapping(value="/menuTreeData")
	@ResponseBody
    public List<Ztree>  menuTreeData(){
		List<Ztree> ztrees =menuService.findAllTree();
        return ztrees;
    }

	@RequestMapping(value="/roleMenuTreeData")
	@ResponseBody
	public List<Map<String,Object>> roleMenuTreeData(){
		List<Map<String,Object>> tree=menuService.roleMenuTreeData();
		return tree;
	}
	/**
	 * 选择菜单图标
	 */
	@GetMapping("/icon")
	public String icon()
	{
		return prefix + "/icon";
	}

}
