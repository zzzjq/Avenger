package avenger.service.strategy.util;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 
 * @author zhangjingqi
 * @date 2019年6月20日下午2:27:48
 *
 **/
@Component
public class SpringBeanUtil implements ApplicationContextAware {

	private static ApplicationContext ac;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ac = applicationContext;
	}

	public static ApplicationContext getApplicationContext() {
		return ac;
	}

	public static Object getBean(final String beanName) {
		return ac.getBean(beanName);
	}

	public static <T> T getBean(final Class<T> clazz) {
		return ac.getBean(clazz);
	}

	public static <T> Map<String, T> getBeans(final Class<T> clazz) {
		return ac.getBeansOfType(clazz);
	}

}
