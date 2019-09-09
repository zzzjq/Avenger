package avenger.service.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import avenger.service.annotation.model.Person;

/**
 * NotNullService测试类
 * 
 * @author zhangjingqi
 * @date 2019年9月9日下午3:20:24
 *
 **/
@Service
public class NotNullService {

	public String doo(Person person) {
		return person.getName() + " , " + person.getAge();
	}
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("/aspectj-aop.xml");
		ac.start();
		NotNullService NotNullService = (NotNullService) ac.getBean(NotNullService.class);
		System.out.println(NotNullService.doo(new Person("zjq", null)));
	}
	
}
