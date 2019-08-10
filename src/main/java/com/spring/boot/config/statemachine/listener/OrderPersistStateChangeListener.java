package com.spring.boot.config.statemachine.listener;

import com.spring.boot.enums.OrderEventEnum;
import com.spring.boot.enums.OrderStatusEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.transition.Transition;
import org.springframework.stereotype.Component;

/**
 * @program: com.spring.boot
 * @description:
 * @author: zhendong.wu
 * @create: 2019-01-13 18:21
 **/
@Component("orderPersistStateChangeListener")
public class OrderPersistStateChangeListener  implements PersistStateChangeListener{
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onPersist(State<OrderStatusEnum, OrderEventEnum> state, Message<OrderEventEnum> message, Transition<OrderStatusEnum, OrderEventEnum> transition, StateMachine<OrderStatusEnum, OrderEventEnum> stateMachine) {
        logger.info("state {} event {} stateMachine {} ",state.getId(),message.getPayload(),stateMachine.getState().getId());
    }
}
