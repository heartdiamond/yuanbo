package com.yuanbook.bean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ArithmeticCalculatorProxy {
	//要代理的对象
	private ArithmeticCalculator target;
	
	public ArithmeticCalculatorProxy(ArithmeticCalculator target) {
		this.target = target;
	}

	public ArithmeticCalculator getProxy(){
		ArithmeticCalculator proxy = null;
		
		//代理对象由哪一个类加载器负责加载
		ClassLoader loader = target.getClass().getClassLoader();
		
		//代理对象的类型，即其中有哪些方法
		Class[] interfaces = new Class[]{ArithmeticCalculator.class};
		
		//当调用代理对象其中的方法时，该执行的代码
		InvocationHandler h = new InvocationHandler(){
			
			/**
			 * proxy:返回的那个代理对象，一下情况下，在invoke方法中都不使用该对象
			 * method:被调用的方法
			 * args:  调用方法时，传入的参数
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				String stMethodName = method.getName();
				//日志
				System.out.println("The method " + stMethodName + " begins with " + Arrays.asList(args));
				//执行方法
				Object  result = method.invoke(target, args);
				
				System.out.println("--->" + result);
				
				//日志
				System.out.println("The method " + stMethodName + " ends with " + result);
				return result;
			}
			
		};
		
		proxy = (ArithmeticCalculator)Proxy.newProxyInstance(loader, interfaces, h);
		
		return proxy;
	}

}
