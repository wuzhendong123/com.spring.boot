package com.spring.boot.web;

import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.config.statemachine.handler.OrderPersistStateMachineHandler;
import com.spring.boot.config.statemachine.listener.OrderPersistStateChangeListener;
import com.spring.boot.entity.Student;
import com.spring.boot.enums.OrderEventEnum;
import com.spring.boot.enums.OrderStatusEnum;
import com.spring.boot.function.FunctionRuleJudgeMapper;
import com.spring.boot.mapper.StudentMapper;
import com.spring.boot.service.IStudentService;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.boot.config.mq.MqProperties;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

@Controller
@Validated
@RequestMapping("/test")
public class TestController implements InitializingBean {
@Autowired
private MqProperties mqProperties;
@Autowired
private IStudentService studentService;
	@Autowired
	private StudentMapper studentMapper;
@Autowired
private CacheManager cacheManager;

    @Autowired
    private TempBatchService tempBatchService;

private String prefix = "test/";
@Autowired
private FunctionRuleJudgeMapper functionRuleJudgeMapper;
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

	@RequestMapping(value="/test_properties")
	@ResponseBody
	public Student test() {
		Student student=new Student();
		student.setName("name1");
		studentService.insert(student);
		System.out.println(mqProperties);
		return student;
//		return mqProperties.toString();
	}

	@RequestMapping(value="/student_page")
	@ResponseBody
	public Page<Student> student_page(int pageNum, int limit) {
		try{

			//student=studentDao.findByCode("111");
			System.out.println(pageNum+"|"+limit);
			Page<Student> page=new Page<>(pageNum,limit);

			studentService.findStudentByName(page,"name1");
//			return studentService.findByName("name1",pageNum,limit);
		}catch (Exception e){
			e.printStackTrace();
		}


		return null;
	}

	@RequestMapping(value="/student_code")
	@ResponseBody
	public Student student_code(String code) {

		//student=studentDao.findByCode("111");
		return studentService.selectById(code);
//		return mqProperties.toString();
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

	@RequestMapping(value="/student_ext")
	public void order_check(@ModelAttribute Student student) {

		log.info(student.toString());
	}
	@RequestMapping(value="/test_function")
	@ResponseBody
	public List<String> funct_check(String name ,String code) {
		Student student=new Student();
		student.setName(name);
		List<String> li= functionRuleJudgeMapper.testStudent(student,code);

		log.info(String.valueOf(li.size()));
		return li;
	}
	@RequestMapping(value="/test_function_2")
	@ResponseBody
	public List<String> funct_check_2(String real ,String code) {
		Student student=new Student();
		student.setReal(real);
		List<String> li= functionRuleJudgeMapper.testStudent2(student,code);

		log.info(String.valueOf(li.size()));
		return li;
	}
	@RequestMapping(value="/student/code/{code}")
	@ResponseBody
	public Student findByCode(@PathVariable("code") String code) {
		studentMapper.findStudentByName(null,code);
		studentService.findByCode(code);

		return studentMapper.findByCode(code);
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
