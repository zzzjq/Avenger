package avenger.service.eventbus.main;

import avenger.service.eventbus.AsyncResult;
import avenger.service.eventbus.Event;
import avenger.service.eventbus.EventBus;
import avenger.service.eventbus.impl.EventBusImpl;

/**
 * 
 * @author zhangjingqi
 * @date 2019年5月27日下午5:02:22
 *
 **/
public class Main {

	public static void main(String[] args) {
		EventBus<AsyncResult<String>> e = new EventBusImpl();
		Event<AsyncResult<String>> ev = new DemoEvent();
		e.resiger(ev);
		e.executeEvent();
	}
}
