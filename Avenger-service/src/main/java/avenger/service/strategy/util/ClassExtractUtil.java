package avenger.service.strategy.util;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

import avenger.service.strategy.demo.DemoContainer;

/**
 * java_type 体系抽取器
 * 
 * @author zhangjingqi
 * @date 2019年9月5日下午3:07:01
 *
 **/
public final class ClassExtractUtil {

	private ClassExtractUtil() {
	}

	public static Class<?> getClass(final Type type, final int i) {
		// 如果是范型实际类型，提取多级范型
		if (type instanceof ParameterizedType) {
			return getGenericClass((ParameterizedType) type, i);
		}
		// 如果是范型变量
		else if (type instanceof TypeVariable) {
			final TypeVariable<?> typeVariable = (TypeVariable<?>) type;
			// 获取范型变量的上限 <t extends x >[0]获取 t
			return getClass(typeVariable.getBounds()[0], 0);
		} else {
			return (Class<?>) type;
		}
	}

	public static Class<?> getGenericClass(final ParameterizedType type, final int i) {
		// 获取第i个范型变量
		final Type genericClass = type.getActualTypeArguments()[i];
		// 如果是范型实际类型，获取声明范型的类或者接口
		if (genericClass instanceof ParameterizedType) {
			return (Class<?>) ((ParameterizedType) genericClass).getRawType();
		}
		// 如果是范型实际类型数组，获取范型实际类型数组的元素类型
		else if (genericClass instanceof GenericArrayType) {
			return (Class<?>) ((GenericArrayType) genericClass).getGenericComponentType();
		}
		// 如果是范型变量
		else if (genericClass instanceof TypeVariable) {
			final TypeVariable<?> typeVariable = (TypeVariable<?>) genericClass;
			// 获取范型变量的上限 <t extends x >[0]获取 t
			return getClass(typeVariable.getBounds()[0], 0);
		} else {
			return (Class<?>) genericClass;
		}
	}
	
	public static void main(String[] args) {
		DemoContainer c = new DemoContainer();
		getClass(c.getClass().getGenericSuperclass(), 1);
	}

}
