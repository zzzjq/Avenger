package avenger.service.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 非空判断
 * 
 * @author zhangjingqi
 * @date 2019年9月9日下午2:41:35
 *
 **/
@Documented
@Retention(RUNTIME)
@Target(FIELD)
public @interface NotNull {

	String value();

}
