package mybatis.service;

import org.aspectj.lang.ProceedingJoinPoint;

public class PojoAspectJ {
	
	public PojoAspectJ() {
		System.out.println(":: PojoAspectJ Default Constructor");
	}

	public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
		
		System.out.println("[Around before] " + getClass()+".invoke() start.....");
		System.out.println("[Around before] 타겟 객체 : " + joinPoint.getTarget().getClass().getName());
		System.out.println("[Around before] 타겟 객체의 호출 될 method : " + joinPoint.getSignature().getName());
		if (joinPoint.getArgs().length != 0) {
			System.out.println("[Around before] 타겟 객체의 호출할 " 
								+ "method에 전달되는 인자 : " + joinPoint.getArgs()[0]);
		}

		//==> 타겟 객체의 Method 를 호출하는 부분
		Object obj = joinPoint.proceed();
		
		System.out.println("[Around after] 타겟 객체의 호출후 return value : " + obj);
		System.out.println("[Around after] " + getClass()+".invoke() end.....");
		
		return obj;
	}
	
}
