package com.spring.boot;

import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.Menu;
import com.spring.boot.query.MenuQuery;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class GenericTest<T,E> {
public static void main(String[] args) {

//	notNull(null,"str is null");org.springframework.util.Assert
	String agentIds=",123,456,777,";
	
	System.out.println(agentIds.indexOf(",123,"));

	MenuQuery menuQuery=new MenuQuery();
	menuQuery.setName("qqq");
	Page<Menu> page =new Page<>(1,10);
	List<Menu> liMenu=new ArrayList<>();
	for(int i=0;i<4;i++){
		Menu menu=new Menu();
		menu.setName(i+"1");
		liMenu.add(menu);
	}
	page.setRecords(liMenu);

	GenericTest<Menu,MenuQuery> ss=new GenericTest();


	Page<MenuQuery>  pageLi=ss.transfer(page,MenuQuery.class);
	System.out.println(pageLi.getRecords().size());
	List<MenuQuery> Limenuquery=pageLi.getRecords();
	for(MenuQuery t1:Limenuquery){
		System.out.println(t1.getName());
	}
}
	public Page<E> transfer(Page<T> t, Class<E> cla){
		try {
			List<T> li=t.getRecords();
			List<E> lie=new ArrayList<>(t.getSize());
			Page<E> page=new Page<>();
			for(T t1:li){
				E ob=cla.newInstance();
				BeanUtils.copyProperties(t1,ob);
				lie.add(ob);
			}
			page.setRecords(lie);
		return page;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
}
