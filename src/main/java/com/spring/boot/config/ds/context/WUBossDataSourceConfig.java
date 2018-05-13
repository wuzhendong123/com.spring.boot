package com.spring.boot.config.ds.context;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;


@Configuration
public class WUBossDataSourceConfig {
//	DataSourceAutoConfiguration
	Logger logger = LoggerFactory.getLogger(WUBossDataSourceConfig.class);

//	@Bean(name="boss")
//	public DataSource bossDateSource(){
//		  try {
//              //创建数据源需要设置  dataSourceName  属性
////          	C3p0PooledDataSource dataSourceInstance = new C3p0PooledDataSource();
//          	dataSourceInstance.setDataSourceName(dataSourceName);
//          	return dataSourceInstance;
//          } catch (Exception e) {
////          	logger.info("创建数据源抛出异常！创建失败！");
//              e.printStackTrace();
//          }
//          return null;
//	}
    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "c3p0")
    public DataSource bossDataSource()
    {
        return DataSourceBuilder.create().type(com.mchange.v2.c3p0.ComboPooledDataSource.class).build();
    }
   
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("dataSource") DataSource dataSource){
    	DataSourceTransactionManager dataSourceTransactionManager=new DataSourceTransactionManager();
    	dataSourceTransactionManager.setDataSource(dataSource);
		return dataSourceTransactionManager;
    }
    
}
