package avenger.service.eventbus;

import avenger.service.eventbus.impl.EventBusImpl;

/**
 * 
 * @author zhangjingqi
 * @date 2019年5月27日下午5:02:22
 *
 **/
public class Main {

	public static void main(String[] args) {
		EventBus e = new EventBusImpl();
		Event ev = new DemoEvent();
		e.resiger(ev);
		e.executeEvent();
	}
}