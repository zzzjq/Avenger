package avenger.service.strategy.contatiner;

import org.springframework.stereotype.Component;

import avenger.service.strategy.DemoStartegy;
import avenger.service.strategy.enums.BaseStrategyEnum;

/**
 * Demo策略容器实现类
 * 
 * @author zhangjingqi
 * @date 2019年6月20日下午4:20:37
 *
 **/
@Component
public class DemoContainer extends BaseContainer<BaseStrategyEnum, DemoStartegy> implements IDemo {

	@Override
	public DemoStartegy getStrategy(BaseStrategyEnum type) {
		return super.getStrategy(type);
	}

}
