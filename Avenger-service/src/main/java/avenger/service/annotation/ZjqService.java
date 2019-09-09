package avenger.service.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import avenger.service.annotation.model.ZjqEnums;

/**
 * 
 * @author zhangjingqi
 * @date 2019年9月9日下午3:44:42
 *
 **/
@Service
public class ZjqService {

	@Zjq(type = ZjqEnums.GO, value = "hahaha")
	public void test() {
		System.out.println("test");
	}

	public static void main(String[] args) {
		ClassPathXmlApplicationContext c = new ClassPathXmlApplicationContext("/aspectj-aop.xml");
		c.start();
		ZjqService zjqService = (ZjqService) c.getBean("zjqService");
		zjqService.test();
	}

}
