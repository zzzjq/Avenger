package avenger.service.strategy.contatiner;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import avenger.service.strategy.IContainer;
import avenger.service.strategy.IStrategy;
import avenger.service.strategy.util.ClassExtractUtil;
import avenger.service.strategy.util.SpringBeanUtil;

/**
 * 通过spring获取+注册所有策略，
 * 
 * @author zhangjingqi
 * @date 2019年6月20日下午2:24:42
 *
 **/
public abstract class BaseContainer<I, S extends IStrategy<I>> implements IContainer<I, S> {

	private final Map<I, S> map = new HashMap<I, S>();

	@Override
	public S getStrategy(final I type) {
		if (!map.containsKey(type))
			initStrategy();
		return map.get(type);
	}

	@SuppressWarnings("unchecked")
	private final synchronized void initStrategy() {
		if (map.size() > 0)
			return;
		if (this.getClass() != BaseContainer.class)
			throw new RuntimeException("不允许使用");
		final Class<S> strategyClass = (Class<S>) ClassExtractUtil.getClass(this.getClass().getGenericSuperclass(), 1);
		final Collection<S> strategys = SpringBeanUtil.getBeans(strategyClass).values();
		for (S s : strategys) {
			if (map.containsKey(s.getStartegyType()))
				continue;
			map.put(s.getStartegyType(), s);
		}
	}

}
