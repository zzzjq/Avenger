package avenger.service.eventbus;

import java.util.function.Function;

/**
 * AsyncResult
 * 
 * @author zhangjingqi
 * @date 2019年5月27日下午4:13:36
 *
 **/
public interface AsyncResult<T> {

	T result();

	Throwable cause();

	boolean success();

	boolean fail();
	
	default <U> AsyncResult<U> map (Function<T, U> f){
		if(f == null)
			throw new NullPointerException();
		return new AsyncResult<U>() {

			@Override
			public U result() {
				if(success()) {
					return f.apply(AsyncResult.this.result());
				}
				return null;
			}

			@Override
			public Throwable cause() {	
				return AsyncResult.this.cause(); 
			}

			@Override
			public boolean success() {
				return AsyncResult.this.success();
			}

			@Override
			public boolean fail() {
				return AsyncResult.this.fail();
			}
		};
	}
	
	default <V> AsyncResult<V> map(V value) {
		return map(t -> value);
	}
	
	default <V> AsyncResult<V> mapEmpty() {
		return map((V) null);
	}

}
