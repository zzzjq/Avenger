package avenger.service.strategy.demo;

import avenger.service.strategy.BaseStrategy;
import avenger.service.strategy.enums.BaseStrategyEnum;

/**
 * 
 * @author zhangjingqi
 * @date 2019年6月20日下午4:19:03
 *
 **/
public class DemoStartegy implements BaseStrategy {

	@Override
	public BaseStrategyEnum getStartegyType() {
		return BaseStrategyEnum.DEMO;
	}

	@Override
	public void execute() {
		System.out.println("执行demo策略");
	}

}
