package avenger.service.strategy;

/**
 * 策略容器接口
 * 
 * @author zhangjingqi
 * @date 2019年6月20日下午2:22:40
 *
 **/

public interface IContainer<I, S extends IStrategy<I>> {

	S getStrategy(final I type);
}
