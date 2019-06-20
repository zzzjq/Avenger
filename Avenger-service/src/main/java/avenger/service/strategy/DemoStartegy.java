package avenger.service.strategy;

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
		// TODO Auto-generated method stub
		return BaseStrategyEnum.DEMO;
	}

	@Override
	public void execute() {
		System.out.println("执行demo策略");
	}

}
