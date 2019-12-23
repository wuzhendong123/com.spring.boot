package com.spring.boot.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.IService;
import com.spring.boot.common.domain.Ztree;
import com.spring.boot.entity.Menu;
import com.spring.boot.entity.Operator;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhendong.wu
 * @since 2018-09-02
 */
public interface IMenuService extends IService<Menu> {
    public Page<Menu> findByPath(Page page, String path);
    public List<Menu> findAll();
    public List<Menu> findByUsrer(Operator operator);

    public  Menu findRootMenu();

    List<Map<String,Object>> roleMenuTreeData();

    List<Menu> findMenuList(Menu menu);

    List<Ztree> findAllTree();

}
