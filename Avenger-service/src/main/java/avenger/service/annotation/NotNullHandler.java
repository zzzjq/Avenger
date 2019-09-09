package avenger.service.annotation;

import java.lang.reflect.Field;

/**
 * NotNull注解解析
 * 
 * @author zhangjingqi
 * @date 2019年9月9日下午3:04:01
 *
 **/
public class NotNullHandler {

	private NotNullHandler() {
	}

	private static class InnerHandler {
		private static NotNullHandler HANDLER = new NotNullHandler();
	}

	public static NotNullHandler getHandler() {
		return InnerHandler.HANDLER;
	}

	public String handle(Object o) {
		Field[] fields = o.getClass().getDeclaredFields();
		for (Field f : fields) {
			f.setAccessible(true);
			NotNull notNull = f.getAnnotation(NotNull.class);
			if (notNull == null)
				return null;
			try {
				Object value = f.get(o);
				if (value == null)
					return notNull.value();
			} catch (IllegalArgumentException | IllegalAccessException e) {
				return null;
			}
		}
		return null;
	}

}
