package avenger.service.eventbus.impl;

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
public class EventBusImpl implements EventBus<AsyncResult<String>>{
	
	private ConcurrentHashMap<String, Event<AsyncResult<String>>> continer = new ConcurrentHashMap<String, Event<AsyncResult<String>>>();

	@Override
	public void resiger(Event<AsyncResult<String>> event) {
		// TODO Auto-generated method stub
		continer.put(event.eventName(), event);
	}
	
	@Override
	public void executeEvent() {
		for(Entry<String, Event<AsyncResult<String>>> entry : continer.entrySet()) {
			entry.getValue().execute();
		}
	}

	

}
