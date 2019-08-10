package com.spring.boot.enums;

import java.util.Arrays;
import java.util.EnumMap;

public enum OrderStatusEnum {
    //订单生成
    GENERATE,

    //已审核
    REVIEWED,

    //已发布
    PUBLISHED,

    //待付款
    NOT_PAY,

    //已付款
    PAID,

    //已完结
    FEED_BACKED;

    public static EnumMap<OrderStatusEnum, String> getMap() {
        EnumMap<OrderStatusEnum, String> map = new EnumMap<>(OrderStatusEnum.class);
        Arrays.stream(OrderStatusEnum.values()).forEach(x -> map.put(x, x.name()));
        return map;
    }
}
