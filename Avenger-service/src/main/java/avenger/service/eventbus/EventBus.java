package avenger.service.eventbus;

/**
 * 
 * @author zhangjingqi
 * @date 2019年5月27日下午3:47:01
 *
 **/
public interface EventBus<T> {

	void resiger(Event<T> event);

	void executeEvent();
}
