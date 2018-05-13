package com.spring.boot.config.ds.context;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;


@Configuration
@MapperScan(basePackages = "com.spring.boot.dao.mapper")
public class BossMybatisConfig {
//	private final String AliasesPackage="com.spring.boot.entity";
//	private final String mapper_path="classpath:/mybatis/mapper*.xml";
	private final String config_path="classpath:/mybatis/mybatis-conf.xml";
	Logger logger = LoggerFactory.getLogger(getClass());
	
	 @Bean(name = "sqlSessionFactory")
	    public SqlSessionFactory sqlSessionFactoryBean(@Qualifier("dataSource") DataSource bossDataSource) {
	        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
	        bean.setDataSource(bossDataSource);
//	        bean.setTypeAliasesPackage(AliasesPackage);
	        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
	        try {
//	        	bean.setMapperLocations(resolver.getResources(mapper_path));
	        	bean.setConfigLocation(resolver.getResource(config_path));
	        	logger.info("sqlSessionFactoryBean resources");
	            return bean.getObject();
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new RuntimeException(e);
	        }
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
