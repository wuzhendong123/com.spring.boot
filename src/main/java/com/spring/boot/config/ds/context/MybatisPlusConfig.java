package com.spring.boot.config.ds.context;

import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.baomidou.mybatisplus.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.spring.boot.config.ds.context.Interceptor.HistoryInterceptor;
import com.spring.boot.entity.base.genid.ObjectIdGenId;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


@Configuration
//实体扫描，多个package用逗号或者分号分隔
@MapperScan(basePackages = "com.spring.boot.mapper")
public class MybatisPlusConfig {
	Logger logger = LoggerFactory.getLogger(getClass());

		@Bean
		public GlobalConfiguration globalConfiguration() {
		GlobalConfiguration conf = new GlobalConfiguration();
		return conf;
		}
		/**
		 * 分页插件
		 */
		@Bean
		public PaginationInterceptor paginationInterceptor() {
			return new PaginationInterceptor();
		}
		@Bean
			public HistoryInterceptor historyInterceptor() {
		return new HistoryInterceptor();
	}

		@Bean
		public OptimisticLockerInterceptor optimisticLockerInterceptor() {
			return new OptimisticLockerInterceptor();
		}

		@Bean
	    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
	        return new SqlSessionTemplate(sqlSessionFactory);
	    }
	    @Bean
	    public JdbcTemplate jdbcTemplate(@Qualifier("dataSource") DataSource bossDataSource) {
	        return new JdbcTemplate(bossDataSource);
	    }
}
