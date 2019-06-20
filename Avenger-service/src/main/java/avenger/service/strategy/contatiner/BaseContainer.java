package avenger.service.strategy.contatiner;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import avenger.service.strategy.IStrategy;
import avenger.service.strategy.util.SpringBeanUtil;

/**
 * 通过spring获取+注册所有策略，
 * 
 * @author zhangjingqi
 * @date 2019年6月20日下午2:24:42
 *
 **/
public class BaseContainer<I, S extends IStrategy<I>> implements IContainer<I, S> {

	private final Map<I, S> map = new ConcurrentHashMap<I, S>();

	@Override
	public S getStrategy(I type) {
		if (!map.containsKey(type))
			initStrategy();
		return map.get(type);
	}

	private synchronized void initStrategy() {
		final Class<S> strategyClass = (Class<S>) this.getClass(this.getClass().getGenericSuperclass(), 1);
		final Class<I> typeClass = (Class<I>) this.getClass(this.getClass().getGenericSuperclass(), 0);
		final Collection<S> strategys = SpringBeanUtil.getBeans(strategyClass).values();
		for (S s : strategys) {
			map.put(s.getStartegyType(), s);
		}
	}

	private Class<?> getClass(final Type type, final int i) {
		if (type instanceof ParameterizedType) {
			return getGenericClass((ParameterizedType) type, i);
		} else if (type instanceof TypeVariable) {
			final TypeVariable typeVariable = (TypeVariable) type;
			// 获取范型变量的上限 <t extends x >[0]获取 t
			return getClass(((TypeVariable) type).getBounds()[0], 0);
		} else {
			return (Class<?>) type;
		}
	}

	private Class<?> getGenericClass(final ParameterizedType type, final int i) {
		// 获取范型
		final Type genericClass = type.getActualTypeArguments()[i];
		if (genericClass instanceof ParameterizedType) {
			return (Class<?>) ((ParameterizedType) genericClass).getRawType();
		} else if (genericClass instanceof GenericArrayType) {
			return (Class<?>) ((GenericArrayType) genericClass).getGenericComponentType();
		} else if (genericClass instanceof TypeVariable) {
			final TypeVariable typeVariable = (TypeVariable) type;
			// 获取范型变量的上限 <t extends x >[0]获取 t
			return getClass(((TypeVariable) type).getBounds()[0], 0);
		} else {
			return (Class<?>) genericClass;
		}
	}

}
