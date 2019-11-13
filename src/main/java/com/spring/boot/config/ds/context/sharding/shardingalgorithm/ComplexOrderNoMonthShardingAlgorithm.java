package com.spring.boot.config.ds.context.sharding.shardingalgorithm;

import io.shardingsphere.core.api.algorithm.sharding.ShardingValue;
import io.shardingsphere.core.api.algorithm.sharding.complex.ComplexKeysShardingAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

/**
 * @program: com.spring.boot
 * @description:按照月份分片
 * @author: zhendong.wu
 * @create: 2019-11-13 17:50
 **/
public class ComplexOrderNoMonthShardingAlgorithm implements ComplexKeysShardingAlgorithm {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, Collection<ShardingValue> shardingValues) {
        logger.info("doSharding availableTargetNames={} shardingValues={}",availableTargetNames,shardingValues);
        ShardingValue shardingValue=shardingValues.iterator().next();
        return null;
    }
}
