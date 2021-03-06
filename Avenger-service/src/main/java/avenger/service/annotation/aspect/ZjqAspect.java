package avenger.service.annotation.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import avenger.service.annotation.Zjq;

/**
 * 
 * @author zhangjingqi
 * @date 2019年9月3日下午3:29:51
 *
 **/
@Aspect
@Component
public class ZjqAspect {

	@Pointcut("@annotation(avenger.service.annotation.Zjq)")
	public void pointCut() {
	}

	@Around(value = "pointCut()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("target:" + joinPoint.getTarget());
		MethodSignature method = (MethodSignature) joinPoint.getSignature();
		Zjq zjq = method.getMethod().getAnnotation(Zjq.class);
		System.out.println(zjq.value());
		System.out.println(zjq.type());
		return joinPoint.proceed();
	}
	
}
