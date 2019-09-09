package avenger.service.annotation.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import avenger.service.annotation.NotNullHandler;

/**
 * 
 * @author zhangjingqi
 * @date 2019年9月9日下午2:44:21
 *
 **/
@Aspect
@Component
public class NotNullAspect {

	@Pointcut("execution(* avenger.service.annotation.NotNullService.*(..))")
	private void pointCut() {
	}

	@Around(value = "pointCut()")
	private Object Around(ProceedingJoinPoint joinPoint) throws Throwable {
		Object[] args = joinPoint.getArgs();
		Signature s = joinPoint.getSignature();
		MethodSignature ms  = (MethodSignature) s;
		//获取方法
		System.out.println(ms.getName());
		String value = NotNullHandler.getHandler().handle(args[0]);
		if (value != null)
			return value;
		return joinPoint.proceed();
	}

	@AfterReturning(pointcut = "pointCut()", returning = "returnValue")
	private void AfterReturning(Object returnValue) {
		System.out.println("returnValue : " + returnValue);
	}
}
