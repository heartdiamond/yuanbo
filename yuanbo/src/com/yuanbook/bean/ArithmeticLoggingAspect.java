package com.yuanbook.bean;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//放置容器中
//申明为一个切面
@Aspect
@Component
public class ArithmeticLoggingAspect {
	
	//声明该方法时一个前置通知，在目标方法开始之前执行
	
	@Before("execution(public int com.yuanbook.bean.ArithmeticCalculator.*(int,int))")
	public void beforeMethond(JoinPoint joinPoint){
		String stMethodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The methond " + stMethodName + " begins with " + args);
	}
}
