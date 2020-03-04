package com.accenture.companymanagement.view.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Pointcut("within(@org.springframework.stereotype.Repository *)"
			+ " || within(@org.springframework.stereotype.Service *)"
			+ " || within(@org.springframework.stereotype.Controller *)")
	public void springBeansPointcut() {
	}

	@Around("springBeansPointcut()")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info("Enter: {}.{} () with arguments[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));

		try {
			Object result = joinPoint.proceed();

			log.info("Exit: {}.{} () with result = {}", joinPoint.getSignature().getDeclaringTypeName(),
					joinPoint.getSignature().getName(), result);

			return result;
		} catch (IllegalArgumentException e) {
			throw e;
		}
	}
	
	@Before("execution(* com.accenture.companymanagement.service.CompanyService.save*(..))")
	public void pointcutServiceBeforeSaveMethods(final JoinPoint joinPoint) {
		log.info("Before: {}.{} () with arguments[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));		
	}

	@After("execution(* com.accenture.companymanagement.service.CompanyService.save*(..))")
	public void pointcutServiceAfterSaveMethods(final JoinPoint joinPoint) {
		log.info("After: {}.{} () with arguments[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
