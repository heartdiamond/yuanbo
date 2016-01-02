package com.yuanbook.util;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
		/*ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloSpring hs = (HelloSpring)ctx.getBean("helloSpring");
		hs.hello();*/
		try {
			inputFromConsole();
		} catch (ConsoleInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
