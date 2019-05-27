package avenger.service.eventbus;

/**
 * event
 * 
 * @author zhangjingqi
 * @date 2019年5月27日下午4:10:39
 *
 **/
public interface Event<T> {

	String eventName();

	T execute();
}
