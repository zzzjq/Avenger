package avenger.service.annotation.model;

import avenger.service.annotation.NotNull;

/**
 * person测试类
 * 
 * @author zhangjingqi
 * @date 2019年6月12日下午8:59:59
 *
 **/
public class Person {

	@NotNull("姓名不能空")
	private String name;

	@NotNull("年龄不能空")
	private String age;

	public Person() {

	}

	public Person(String name, String age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}
