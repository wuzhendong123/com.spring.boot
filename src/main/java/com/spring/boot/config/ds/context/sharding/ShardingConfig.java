package com.spring.boot.config.ds.context.sharding;

import com.spring.boot.config.ds.context.sharding.shardingalgorithm.ComplexResidualShardingAlgorithm;
import io.shardingsphere.core.api.ShardingDataSourceFactory;
import io.shardingsphere.core.api.config.ShardingRuleConfiguration;
import io.shardingsphere.core.api.config.TableRuleConfiguration;
import io.shardingsphere.core.api.config.strategy.ComplexShardingStrategyConfiguration;
import io.shardingsphere.core.api.config.strategy.ShardingStrategyConfiguration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.*;

/**
 * @program: com.spring.boot
 * @description:
 * @author: zhendong.wu
 * @create: 2019-11-05 19:11
 **/
//@Configuration
public class ShardingConfig {

    @Bean("shardDataSource")
    @Primary
    public DataSource  shardDataSource(@Qualifier("dataSource") DataSource dataSource){
        Map<String, DataSource> dataSourceMap=new HashMap<>();
        dataSourceMap.put("dataSource",dataSource);

        ShardingRuleConfiguration shardingRuleConfiguration=new ShardingRuleConfiguration();
        Map<String, Object> configMap= new LinkedHashMap<>(); ;
         Properties props=new Properties();
        try {
            return ShardingDataSourceFactory.createDataSource(dataSourceMap,shardingRuleConfiguration,configMap,props);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private List<TableRuleConfiguration> findTableRuleConfiguration(){
        List<TableRuleConfiguration> tableRuleConfigurations=new ArrayList<>();
        TableRuleConfiguration tableRuleConfiguration=new TableRuleConfiguration();
        tableRuleConfiguration.setLogicTable("order");
        tableRuleConfiguration.setKeyGeneratorColumnName("order_no");
        ShardingStrategyConfiguration databaseShardingStrategyConfig=new ComplexShardingStrategyConfiguration("user_key",new ComplexResidualShardingAlgorithm());
        tableRuleConfiguration.setDatabaseShardingStrategyConfig(databaseShardingStrategyConfig);
        ShardingStrategyConfiguration tableShardingStrategyConfig=new ComplexShardingStrategyConfiguration("user_key",new ComplexResidualShardingAlgorithm());
        tableRuleConfiguration.setTableShardingStrategyConfig(tableShardingStrategyConfig);

        return tableRuleConfigurations;
    }


}
