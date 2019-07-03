package avenger.service.strategy.contatiner;

import org.springframework.stereotype.Component;

import avenger.service.strategy.BaseStrategy;
import avenger.service.strategy.enums.BaseStrategyEnum;

/**
 * 
 * @author zhangjingqi
 * @date 2019年6月20日下午4:20:37
 *
 **/
@Component
public class DemoContainer {
	
	BaseContainer<BaseStrategyEnum, BaseStrategy> container = new BaseContainer<BaseStrategyEnum, BaseStrategy>();

	public BaseStrategy getStrategy(BaseStrategyEnum type) {

		return container.getStrategy(type);
	}
}
