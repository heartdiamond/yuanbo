package com.yuanbook.bean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ArithmeticCalculatorProxy {
	//Ҫ����Ķ���
	private ArithmeticCalculator target;
	
	public ArithmeticCalculatorProxy(ArithmeticCalculator target) {
		this.target = target;
	}

	public ArithmeticCalculator getProxy(){
		ArithmeticCalculator proxy = null;
		
		//�����������һ����������������
		ClassLoader loader = target.getClass().getClassLoader();
		
		//�����������ͣ�����������Щ����
		Class[] interfaces = new Class[]{ArithmeticCalculator.class};
		
		//�����ô���������еķ���ʱ����ִ�еĴ���
		InvocationHandler h = new InvocationHandler(){
			
			/**
			 * proxy:���ص��Ǹ��������һ������£���invoke�����ж���ʹ�øö���
			 * method:�����õķ���
			 * args:  ���÷���ʱ������Ĳ���
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				String stMethodName = method.getName();
				//��־
				System.out.println("The method " + stMethodName + " begins with " + Arrays.asList(args));
				//ִ�з���
				Object  result = method.invoke(target, args);
				
				System.out.println("--->" + result);
				
				//��־
				System.out.println("The method " + stMethodName + " ends with " + result);
				return result;
			}
			
		};
		
		proxy = (ArithmeticCalculator)Proxy.newProxyInstance(loader, interfaces, h);
		
		return proxy;
	}

}
