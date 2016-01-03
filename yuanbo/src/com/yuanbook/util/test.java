package com.yuanbook.util;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yuanbook.action.HelloSpring;
import com.yuanbook.bean.ArithmeticCalculator;
import com.yuanbook.bean.ArithmeticCalculatorImpl;
import com.yuanbook.bean.ArithmeticCalculatorProxy;
import com.yuanbook.bean.Car;
import com.yuanbook.bean.DataSource;
import com.yuanbook.bean.Person;
import com.yuanbook.bean.PersonCars;
import com.yuanbook.bean.PersonMap;
import com.yuanbook.service.UserService;

public class test {
	
	public static void inputFromConsole() throws ConsoleInputException{
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			String line = scanner.next();
			if(line.matches("\\d+")){
				System.out.println("Content:" + line);
			}else{
				throw new ConsoleInputException();
			}
		}
		scanner.close();
	}

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		/*Car car2 = (Car)ctx.getBean("car2");
		System.out.println(car2.toString());
		
		Car car1 = (Car)ctx.getBean("car");
		System.out.println(car1.toString());
		
		
		Person person = (Person)ctx.getBean("person");
		System.out.println(person);
		
		
		PersonCars personCars = (PersonCars)ctx.getBean("personCars");
		System.out.println(personCars);
		
		PersonMap personMap = (PersonMap)ctx.getBean("personMap");
		System.out.println(personMap);
		
		DataSource dataSource = (DataSource)ctx.getBean("dataSource");
		System.out.println(dataSource);
		*/
		
		/*try {
			inputFromConsole();
		} catch (ConsoleInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/*泛型依赖注入*/
		/*UserService userService = (UserService)ctx.getBean("userService");
		userService.add();*/
		
		/*动态代理实现AOP*/
		/*ArithmeticCalculator target = new ArithmeticCalculatorImpl();
		ArithmeticCalculator proxy = new ArithmeticCalculatorProxy(target).getProxy();
		
		
		proxy.add(1, 2);
		proxy.mul(3, 2);*/
		
		ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator)ctx.getBean("arithmeticCalculator");
		
		System.out.println("The result is " + arithmeticCalculator.add(3, 5));
		
		System.out.println("The result is " + arithmeticCalculator.mul(3, 5));
	}

}
