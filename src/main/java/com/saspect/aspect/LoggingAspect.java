package com.saspect.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {
	@Before("execution(* com.saspect.customer.bo.CustomerBo.addCustomer(..))")
	public void logBefore(JoinPoint joinPoint) {

		System.out.println("------------------------------------------------");
		System.out.println("logBefore() is running!");
		System.out
				.println("com.saspect.customer.bo.CustomerBo.addCustomer(..) fonksiyonu çalışmadan önce kontrol altına alındı ve loglama işlemi başarılı oldu.");
		System.out.println("hi sercan : çalıştırdığın fonksiyonun adı : "
				+ joinPoint.getSignature().getName());
		System.out.println("joinPoint.getSourceLocation().toString() : "
				+ joinPoint.getSourceLocation().toString());
		System.out.println("joinPoint.getKind() : " + joinPoint.getKind());
		System.out.println("joinPoint.getThis() : " + joinPoint.getThis());
		System.out.println("******");
	}

	@After("execution(* com.saspect.customer.bo.CustomerBo.addCustomer(..))")
	public void logAfter(JoinPoint joinPoint) {
		System.out.println("------------------------------------------------");
		System.out.println("logAfter() is running!");
		System.out
				.println("com.saspect.customer.bo.CustomerBo.addCustomer(..) fonksiyonu çalıştıktan sonra kontrol altına alındı ve loglama işlemi başarılı oldu.");
		System.out.println("hi sercan : çalıştırdığın fonksiyonun adı : "
				+ joinPoint.getSignature().getName());
		System.out.println("joinPoint.getSourceLocation().toString() : "
				+ joinPoint.getSourceLocation().toString());
		System.out.println("joinPoint.getKind() : " + joinPoint.getKind());
		System.out.println("joinPoint.getThis() : " + joinPoint.getThis());
		System.out.println("******");
	}

	
	// Aspect tanımlanan methodun herhangi bir deger dondurmesi sonucunda bu methoda giris olur ve kontrol edilir. Hangi degeri dondurdugunu bilebiliriz.
	@AfterReturning(pointcut = "execution(* com.saspect.customer.bo.CustomerBo.addCustomerReturnValue(..))", returning = "result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {

		System.out.println("------------------------------------------------");
		System.out.println("logAfterReturning() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("Method returned value is : " + result);
		System.out.println("******");

	}
	
	
	//Belirtilen method herhangi bir hata uretirse o zaman burası çalışacaktır.
	@AfterThrowing(
		      pointcut = "execution(* com.saspect.customer.bo.CustomerBo.addCustomerThrowException(..))",
		      throwing= "error")
		    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
		 
			System.out.println("logAfterThrowing() is running!");
			System.out.println("hi sercan : " + joinPoint.getSignature().getName());
			System.out.println("Exception : " + error);
			System.out.println("******");
		 
		    }
	
	
	// Around annotation all in one means.
	 @Around("execution(* com.saspect.customer.bo.CustomerBo.addCustomerAround(..))")
	   public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
	 
		System.out.println("logAround() is running!");
		System.out.println("hijacked method : " + joinPoint.getSignature().getName());
		System.out.println("hijacked arguments : " + Arrays.toString(joinPoint.getArgs()));
	 
		System.out.println("Around before is running!");
		joinPoint.proceed(); //continue on the intercepted method
		System.out.println("Around after is running!");
	 
		System.out.println("******");
	 
	   }

}
