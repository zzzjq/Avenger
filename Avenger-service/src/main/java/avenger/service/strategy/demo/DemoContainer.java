package avenger.service.strategy.demo;

import org.springframework.stereotype.Component;

import avenger.service.strategy.BaseStrategy;
import avenger.service.strategy.contatiner.BaseContainer;
import avenger.service.strategy.enums.BaseStrategyEnum;

/**
 * Demo策略容器实现类
 * 
 * @author zhangjingqi
 * @date 2019年6月20日下午4:20:37
 *
 **/
@Component("demoContainer")
public class DemoContainer extends BaseContainer<BaseStrategyEnum, BaseStrategy> implements IDemo {

	@Override
	public BaseStrategy getStrategy(BaseStrategyEnum type) {
		return super.getStrategy(type);
	}

}
