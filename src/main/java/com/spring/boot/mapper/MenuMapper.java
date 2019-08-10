package com.spring.boot.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.spring.boot.entity.Menu;
import com.spring.boot.query.MenuQuery;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhendong.wu
 * @since 2018-09-02
 */
public interface MenuMapper extends BaseMapper<Menu> {
    public List<Menu> findByPath(Pagination page, String name);
    public List<Menu> findAll();

    public Menu findRootMenu();

    List<Menu> findMenuList(Menu menu);
}
