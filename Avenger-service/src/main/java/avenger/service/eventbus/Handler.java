package avenger.service.eventbus;

/**
 * 
 * @author zhangjingqi
 * @date 2019年9月9日下午2:25:16
 *
 **/
@FunctionalInterface
public interface Handler<E> {

	void hande(E event);
}
