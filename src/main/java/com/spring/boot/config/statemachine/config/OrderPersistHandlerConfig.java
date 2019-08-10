package com.spring.boot.config.statemachine.config;

import com.spring.boot.config.statemachine.handler.OrderPersistStateMachineHandler;
import com.spring.boot.enums.OrderEventEnum;
import com.spring.boot.enums.OrderStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateMachine;

/**
 * @program: com.spring.boot
 * @description:
 * @author: zhendong.wu
 * @create: 2019-01-13 18:23
 **/
@Configuration
public class OrderPersistHandlerConfig {
    @Autowired
    private StateMachine<OrderStatusEnum, OrderEventEnum> stateMachine;

    @Bean
    public OrderPersistStateMachineHandler persistStateMachineHandler() {
        return new OrderPersistStateMachineHandler(stateMachine);
    }
}
