package avenger.service.strategy.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import avenger.service.strategy.contatiner.IDemo;
import avenger.service.strategy.enums.BaseStrategyEnum;

/**
 * Demo策略执行上下文
 * 
 * @author zhangjingqi
 * @date 2019年9月5日下午3:19:56
 *
 **/
@Component("demoContext")
public class DemoContext implements IContext {

	@Autowired
	@Qualifier("demoContainer")
	IDemo demoContainer;

	@Override
	public void execute() {
		demoContainer.getStrategy(BaseStrategyEnum.DEMO).execute();
	}

}
