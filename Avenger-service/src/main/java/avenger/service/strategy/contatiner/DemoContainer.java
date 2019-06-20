package avenger.service.strategy.contatiner;

import org.springframework.stereotype.Component;

import avenger.service.strategy.DemoStartegy;
import avenger.service.strategy.enums.BaseStrategyEnum;

/**
 * 
 * @author zhangjingqi
 * @date 2019年6月20日下午4:20:37
 *
 **/
@Component
public class DemoContainer {
	
	static BaseContainer<BaseStrategyEnum, DemoStartegy> container = new BaseContainer<BaseStrategyEnum, DemoStartegy>();

	public DemoStartegy getStrategy(BaseStrategyEnum type) {

		return container.getStrategy(type);
	}
}
