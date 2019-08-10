package com.spring.boot;

import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.DictType;
import com.spring.boot.service.common.SqlCommonService;
import org.apache.ibatis.mapping.MappedStatement;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseTest {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private SqlCommonService sqlCommonService;
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	@Test
	public void test() throws Exception {
		System.out.println(jdbcTemplate);
	}
	@Test
	public void testSql() throws Exception {
		String sql="<script> select * from query_function <where> 1=1 and name like  concat('%', #{name}, '%') </where> </script>";
		Map<String,Object> map=new HashMap<>();
		map.put("name",2);
		MappedStatement mappedStatement=sqlCommonService.bulid(sql,"111");
		mappedStatement=sqlCommonService.bulid(sql,"111");
		Page pagePg=new Page(1,10);
		System.out.println(sqlSessionTemplate.selectList(sqlCommonService.bulidSqlId("111"),map,pagePg));
		System.out.println(pagePg.getTotal());
		System.out.println(map);

	}
}
		