package com.spring.boot.config.statemachine.event;

import com.spring.boot.enums.OrderStatusEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

/**
 * @program: com.spring.boot
 * @description:
 * @author: zhendong.wu
 * @create: 2019-01-13 18:19
 **/
@WithStateMachine
public class OrderStateMachineEventConfig {

    // Spring StateMachine 提供了注解配置实现方式，所有 StateMachineListener
    // 接口中定义的事件都能通过注解的方式来进行配置实现。这里以连接事件为案例，
    // @OnTransition 中 source 指定原始状态，target 指定目标状态，当事件触发时将会被监听到从而调用 connect() 方法。

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @OnTransition(source = "SAVE")
    public void saveEvent(){
        logger.warn("---------创建订单---------");
        logger.info("订单生成 ");
    }
    @OnTransition(source = "GENERATE", target = "REVIEWED")
    public void checkEvent(){
        logger.warn("---------电审事件---------");
        logger.info("订单生成 ------> 已审核");
    }

    @OnTransition(source = "GENERATE", target = "FEED_BACKED")
    public void checkFailEvent(){
        logger.warn("---------电审失败---------");
        logger.info("订单生成 ------> 已完结");
    }

    @OnTransition(source = "REVIEWED", target = "PUBLISHED")
    public void makePriceEvent(){
        logger.warn("--------定价发布----------");
        logger.info("已审核 -------> 已发布");
    }


    @OnTransition(source = "PUBLISHED", target = "NOT_PAY")
    public void acceptOrderEvent(){
        logger.warn("--------接单时间----------");
        logger.info("已发布 ------> 待付款");
    }

    @OnTransition(source = "PUBLISHED", target = "FEED_BACKED")
    public void notPeopleAcceptEvent(){
        logger.warn("---------无人接单失效---------");
        logger.info("已发布 -------> 已完结");
    }

    @OnTransition(source = "NOT_PAY", target = "PAID")
    public void payOrderEvent(){
        logger.warn("--------付款事件----------");
        logger.info("待付款 --------> 已付款");
    }

    @OnTransition(source = "NOT_PAY", target = "FEED_BACKED")
    public void orderFailureEvent(){
        logger.warn("--------接单有人支付失效----------");
        logger.info("待付款 ------> 已完结");
    }

    @OnTransition(source = "PAID", target = "FEED_BACKED")
    public void feedBackEvent(){
        logger.warn("--------反馈事件----------");
        logger.info("已付款 -------> 已完结");
    }
}
