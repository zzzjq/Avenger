package avenger.service.eventbus;

/**
 * 
 * @author zhangjingqi
 * @date 2019年5月27日下午4:53:16
 *
 **/
public class DemoEvent implements Event<AsyncResult<String>>{

	@Override
	public String eventName() {
		return "demo";
	}

	@Override
	public AsyncResult<String> execute() {
		return new AsyncResult<String>() {

			@Override
			public String result() {
				return "demo";
			}

			@Override
			public Throwable cause() {
				return new Throwable();
			}

			@Override
			public boolean success() {
				return true;
			}

			@Override
			public boolean fail() {
				// TODO Auto-generated method stub
				return false;
			}
		};
	}

}
