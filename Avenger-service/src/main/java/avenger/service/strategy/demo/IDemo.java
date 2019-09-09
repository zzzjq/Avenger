package avenger.service.strategy.demo;

import avenger.service.strategy.contatiner.IContainer;
import avenger.service.strategy.enums.BaseStrategyEnum;

/**
 * demo策略容器接口
 * 
 * @author zhangjingqi
 * @date 2019年9月5日下午2:33:07
 *
 **/
public interface IDemo extends IContainer<BaseStrategyEnum, DemoStartegy> {
}
