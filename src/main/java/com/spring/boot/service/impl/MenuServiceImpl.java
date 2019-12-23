package com.spring.boot.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.spring.boot.common.domain.Ztree;
import com.spring.boot.entity.Menu;
import com.spring.boot.entity.Operator;
import com.spring.boot.mapper.MenuMapper;
import com.spring.boot.service.IMenuService;
import com.spring.boot.service.IOperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhendong.wu
 * @since 2018-09-02
 */
@Service("menuService")
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {


    @Override
    public Page<Menu> findByPath(Page page, String path) {

        return page.setRecords(this.baseMapper.findByPath(page,path));
    }

    @Override
    public List<Menu> findAll() {
        return baseMapper.findAll();
    }

    @Override
    public List<Menu> findByUsrer(Operator operator) {
        return null;
    }

    @Override
    public Menu findRootMenu() {
        return baseMapper.findRootMenu();
    }

    @Override
    public List<Map<String, Object>> roleMenuTreeData() {
        List<Menu> menus=baseMapper.findAll();
        return getTrees(menus,false);
    }

    @Override
    public List<Menu> findMenuList(Menu menu) {
        return baseMapper.findMenuList(menu);
    }

    @Override
    public List<Ztree> findAllTree() {
        List<Menu> menus=baseMapper.findAll();
        return initZtree(menus);
    }


    public List<Ztree> initZtree( List<Menu> menus){

        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (Menu menu : menus)
        {
            Ztree ztree = new Ztree();
            ztree.setId(menu.getCode());
            ztree.setpId(menu.getParentCode());
            ztree.setName(menu.getName());
            ztree.setTitle(menu.getName());

            ztrees.add(ztree);
        }
        return ztrees;
    }
    private List<Map<String, Object>> getTrees(List<Menu> menuList, boolean isCheck)
    {
        List<Map<String, Object>> trees = new ArrayList<Map<String, Object>>();
        for (Menu menu : menuList)
        {
            Map<String, Object> deptMap = new HashMap<String, Object>();
            deptMap.put("id", menu.getCode());
            deptMap.put("pId", menu.getParentCode());
            deptMap.put("name", menu.getName());
            deptMap.put("title", menu.getName());
            if (isCheck)
            {
//                deptMap.put("checked", roleMenuList.contains(menu.getMenuId() + menu.getPerms()));
                deptMap.put("checked", false);
            }
            else
            {
                deptMap.put("checked", false);
            }
            trees.add(deptMap);
        }
        return trees;
    }
}
