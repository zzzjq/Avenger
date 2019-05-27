package avenger.service.eventbus.impl;

import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import avenger.service.eventbus.AsyncResult;
import avenger.service.eventbus.Event;
import avenger.service.eventbus.EventBus;

/**
 * 
 * @author zhangjingqi
 * @date 2019年5月27日下午3:52:28
 *
 **/
public class EventBusImpl implements EventBus{
	
	private ConcurrentHashMap<String, Event<AsyncResult>> continer = new ConcurrentHashMap<String, Event<AsyncResult>>();

	@Override
	public <T> EventBus resiger(Event<AsyncResult> event) {
		// TODO Auto-generated method stub
		continer.put(event.eventName(), event);
		return this;
	}

	@Override
	public void executeEvent() {
		for(Entry<String, Event<AsyncResult>> entry : continer.entrySet()) {
			System.out.println(entry.getKey());
			AsyncResult result = entry.getValue().execute();
			System.out.println(result.result());
		}
	}

}
