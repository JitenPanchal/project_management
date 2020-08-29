package com.jiten.pma.logging;

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
public class ApplicationLoggerAspect {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Pointcut("within(com.jiten.pma.controllers..*)")
	public void definePackagePointcuts() {
	}

	@Before("definePackagePointcuts()")
	public void logBeforeMethodIsInvoked() {
		logger.debug("Before method is invoked");
	}

	@After("definePackagePointcuts()")
	public void logAfterMethodIsInvoked() {
		logger.debug("After method is invoked");
	}

	@Before("definePackagePointcuts()")
	public void logBeforeMethodIsInvokedWithJointPoint(JoinPoint joinPoint) {
		logger.debug("Before method is invoked with joint point");
		logger.debug("ClassName");
		logger.debug(joinPoint.getSignature().getDeclaringTypeName());
		logger.debug("MethodName");
		logger.debug(joinPoint.getSignature().getName());
		logger.debug("Arguments");
		logger.debug(Arrays.toString(joinPoint.getArgs()));
	}

	@After("definePackagePointcuts()")
	public void logAfterMethodIsInvokedWithJointPoint(JoinPoint joinPoint) {
		logger.debug("After method is invoked with joint point");
		logger.debug("ClassName");
		logger.debug(joinPoint.getSignature().getDeclaringTypeName());
		logger.debug("MethodName");
		logger.debug(joinPoint.getSignature().getName());
		logger.debug("Arguments");
		logger.debug(Arrays.toString(joinPoint.getArgs()));
	}

	@Around("definePackagePointcuts()")
	public Object logAroundMethodWithJointPoint(ProceedingJoinPoint proceedingJoinPoint) {
		logger.debug("Before method is invoked with joint point using Around");
		logger.debug("ClassName");
		logger.debug(proceedingJoinPoint.getSignature().getDeclaringTypeName());
		logger.debug("MethodName");
		logger.debug(proceedingJoinPoint.getSignature().getName());
		logger.debug("Arguments");
		logger.debug(Arrays.toString(proceedingJoinPoint.getArgs()));

		Object object = null;
		try {
			object = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.debug("After method is invoked with joint point using Around");
		logger.debug("ClassName");
		logger.debug(proceedingJoinPoint.getSignature().getDeclaringTypeName());
		logger.debug("MethodName");
		logger.debug(proceedingJoinPoint.getSignature().getName());
		logger.debug("Arguments");
		logger.debug(Arrays.toString(proceedingJoinPoint.getArgs()));

		return object;
	}

}