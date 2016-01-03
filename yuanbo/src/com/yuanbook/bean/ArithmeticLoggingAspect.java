package com.yuanbook.bean;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//����������
//����Ϊһ������
@Aspect
@Component
public class ArithmeticLoggingAspect {
	
	//�����÷���ʱһ��ǰ��֪ͨ����Ŀ�귽����ʼ֮ǰִ��
	
	@Before("execution(public int com.yuanbook.bean.ArithmeticCalculator.*(int,int))")
	public void beforeMethond(JoinPoint joinPoint){
		String stMethodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The methond " + stMethodName + " begins with " + args);
	}
}
