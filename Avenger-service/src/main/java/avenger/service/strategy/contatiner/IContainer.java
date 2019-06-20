package avenger.service.strategy.contatiner;

import avenger.service.strategy.IStrategy;

/**
 * 
 * @author zhangjingqi
 * @date 2019年6月20日下午2:22:40
 *
 **/

public interface IContainer<I, S extends IStrategy<I>> {

	S getStrategy(I type);

}
