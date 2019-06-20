package avenger.service.strategy;

import avenger.service.strategy.enums.BaseStrategyEnum;

/**
 * 
 * @author zhangjingqi
 * @date 2019年6月20日下午2:20:32
 *
 **/
public interface BaseStrategy extends IStrategy<BaseStrategyEnum> {

	void execute();
	
}
