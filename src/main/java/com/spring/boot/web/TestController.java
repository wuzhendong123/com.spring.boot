package com.spring.boot.web;

import com.spring.boot.config.statemachine.handler.OrderPersistStateMachineHandler;
import com.spring.boot.config.statemachine.listener.OrderPersistStateChangeListener;
import com.spring.boot.enums.OrderEventEnum;
import com.spring.boot.enums.OrderStatusEnum;
import com.spring.boot.function.FunctionRuleJudgeMapper;
import com.spring.boot.service.TempBatchService;
import com.spring.boot.web.respone.R;
import org.hibernate.validator.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StopWatch;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.boot.config.mq.MqProperties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@Controller
//@Validated
@RequestMapping("/test")
public class TestController implements InitializingBean {
@Autowired
private MqProperties mqProperties;
@Autowired
private CacheManager cacheManager;

    @Autowired
    private TempBatchService tempBatchService;

private String prefix = "test/";


@Autowired
private FunctionRuleJudgeMapper functionRuleJudgeMapper;

	@RequestMapping(value="/html")
public void html(HttpServletResponse response) throws IOException {
		String html="<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/></head><body><form id = \"pay_form\" action=\"https://gateway.95516.com/gateway/api/frontTransReq.do\" method=\"post\"><input type=\"hidden\" name=\"bizType\" id=\"bizType\" value=\"000902\"/><input type=\"hidden\" name=\"tokenPayData\" id=\"tokenPayData\" value=\"{trId=62000001143&tokenType=01}\"/><input type=\"hidden\" name=\"txnSubType\" id=\"txnSubType\" value=\"00\"/><input type=\"hidden\" name=\"orderId\" id=\"orderId\" value=\"BN2B3L4J2L8GEDGXMLEG\"/><input type=\"hidden\" name=\"backUrl\" id=\"backUrl\" value=\"https://jh.cardinfo.com.cn/payinterface-dispatcher-front/UNIONPAY110001Notice/openCardNotify.htm\"/><input type=\"hidden\" name=\"signature\" id=\"signature\" value=\"Lu9/sJCqQJJxCJqwFxu6xcttY8Aax7xr+GP7aAOi9dEXax3QOOwsQccPCQOH667Hoo+02vjW+Q6OOc02brTHkLtuyvG/mpeQzz/Kt6AxLauKp42tI/eGJdl8Pwc0+XBaU8n9ArMIylgA7yU5mb10V5q/c2KOmhgUpbeuaN3CvKT18G5+ksj0SmisBxWqHYlyAN2LITDDoxzRL4dLbweVUsi8qLO/JAQXsZ7gFOddlv1kIgonugqUzquSm0aMtQhUync+6NuG6Gdoc3kUXkX/2XBSCNpPgPAw0cGp/jeHdaD3vU7CwyRfefOup22uboRCNxpt2e52c970uvtPRElvuw==\"/><input type=\"hidden\" name=\"accNo\" id=\"accNo\" value=\"W5PDNGVA6T8TvU6SdM+g8Q8L4Ik42IHi1XZUx22RmLccedsGX78bZWM6RJzlDpMhZTa8Sm24/YrHWOfdTQdHdTP/jkfYOvB7HJogVIrZqOT/jMz3zBr1QRM+PrJdlEJuOFhrKWy/u/Q5b8/a3paR1NBRdZraQPJC3ayl4Ydhgwxv8waDwVjkHACIVyaXkl21+jy6UVhjF9RL+xLYzgO9VE+I2XW+PhNeJDhKJN8lrixaZcFAld8/u2W1B9+cnCGYQW56/CKOLU5Ynqd/X63PzNACpWftt5e2BZXfeClBJ6RmWbj1hO1NdZnIxY/7vKS9ISkYy8cEb/ex0+9cHZDtlA==\"/><input type=\"hidden\" name=\"customerInfo\" id=\"customerInfo\" value=\"e2NlcnRpZklkPTM1MDMwMTE5OTMwMTEyMjgzMSZjZXJ0aWZUcD0wMSZlbmNyeXB0ZWRJbmZvPUxvSjdrRFNzeURxTXlBekZsVWEvR1ZuZVI1SzlCMFgyWGFGdEoyNEZBbWFMSS9ycm55SllTT0NudDF5TjhVdFdsQWJKTEFPNGZ5SDU1TDVIQnN4cVhWcDM3dWdQWGRVbjExNmlKZ3phTWI2Nm5CbUd0ZUNTRTd2U2IxUDNlQXE1ejU1TzBoMG5XYVJMdFV1VWVnK3lxaE56dEoxMkUrd29jVDAvMFY4czkxMENSV1dUZDRtYzI3UloxVWs0T2U3djU5VllKdFBkZXRhYUsreVpvYmNtNTc1QjdVNThNaWoweFFqNW5lRDRncDFlSHJKb1lTUEg1NFRJZ0xTOHIzNEI5UlZOUG5SMDBMWEI4bmdubFpWdEhGQk5VYmNkcFF0VU82WGNIeTc3cjA5RWZPVGxTdXVXYTlHaHoyUVkxQlhjWVRLOVZRV1pDOVZaWStpZXBpY2MxQT09fQ==\"/><input type=\"hidden\" name=\"txnType\" id=\"txnType\" value=\"79\"/><input type=\"hidden\" name=\"channelType\" id=\"channelType\" value=\"07\"/><input type=\"hidden\" name=\"frontUrl\" id=\"frontUrl\" value=\"https://jh.cardinfo.com.cn/payinterface-dispatcher-front/UNIONPAY110001Notice/frontRcvResponse.htm?orderCode=BN2B3L4J2L8GEDGXMLEG\"/><input type=\"hidden\" name=\"certId\" id=\"certId\" value=\"74215158628\"/><input type=\"hidden\" name=\"encoding\" id=\"encoding\" value=\"UTF-8\"/><input type=\"hidden\" name=\"version\" id=\"version\" value=\"5.1.0\"/><input type=\"hidden\" name=\"accessType\" id=\"accessType\" value=\"0\"/><input type=\"hidden\" name=\"encryptCertId\" id=\"encryptCertId\" value=\"77447321186\"/><input type=\"hidden\" name=\"reqReserved\" id=\"reqReserved\" value=\"BN2B3L4J2L8GEDGXMLEG\"/><input type=\"hidden\" name=\"txnTime\" id=\"txnTime\" value=\"20190920190240\"/><input type=\"hidden\" name=\"merId\" id=\"merId\" value=\"801100048160009\"/><input type=\"hidden\" name=\"accType\" id=\"accType\" value=\"01\"/><input type=\"hidden\" name=\"signMethod\" id=\"signMethod\" value=\"01\"/></form></body><script type=\"text/javascript\">document.all.pay_form.submit();</script></html>";
		response.getOutputStream().write(html.getBytes());
}
    @RequestMapping(value="/index")
    public String index() {
       return prefix+"test";
//		return mqProperties.toString();
    }
    @RequestMapping(value="/upload")
    @ResponseBody
    public R upload(HttpServletRequest request) throws IOException {
        tempBatchService.createTempByRequest(request);
        return  R.ok();
    }

	@RequestMapping(value="/cache_test")
	@ResponseBody
	public Collection<String> cache_test() {

		return cacheManager.getCacheNames();
//		return mqProperties.toString();
	}
	@Autowired
	private OrderPersistStateMachineHandler orderPersistStateMachineHandler;
	@Autowired
	private OrderPersistStateChangeListener orderPersistStateChangeListener;
	@RequestMapping(value="/order_save")
	@ResponseBody
	public Boolean order_save() {

		return orderPersistStateMachineHandler.handleEventWithState(MessageBuilder
				.withPayload(OrderEventEnum.SAVE).setHeader("order", "order").build(), OrderStatusEnum.GENERATE);
	}
	@RequestMapping(value="/order_check")
	@ResponseBody
	public Boolean order_check() {

		return orderPersistStateMachineHandler.handleEventWithState(MessageBuilder
				.withPayload(OrderEventEnum.CHECK).setHeader("order", "order").build(), OrderStatusEnum.GENERATE);
	}
	@RequestMapping(value="/validated/code")
	@ResponseBody
	public String validatedCode(@NotBlank(message = "name 不能为空") String code) {
		return "";
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		orderPersistStateMachineHandler.addPersistStateChangeListener(orderPersistStateChangeListener);
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		stopWatch.stop();
	}
	public Logger log = LoggerFactory.getLogger(getClass());
}
