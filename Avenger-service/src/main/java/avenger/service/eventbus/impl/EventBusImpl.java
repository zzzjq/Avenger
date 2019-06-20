package avenger.service.eventbus.impl;

import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import avenger.service.eventbus.Event;
import avenger.service.eventbus.EventBus;

/**
 * 
 * @author zhangjingqi
 * @date 2019年5月27日下午3:52:28
 *
 **/
public class EventBusImpl implements EventBus{
	
	private ConcurrentHashMap<String, Event> continer = new ConcurrentHashMap<String, Event>();

	@Override
	public <T> EventBus resiger(Event<T> event) {
		// TODO Auto-generated method stub
		continer.put(event.eventName(), event);
		return this;
	}

	@Override
	public void executeEvent() {
		for(Entry<String, Event> entry : continer.entrySet()) {
			entry.getValue().execute();
		}
	}

}
