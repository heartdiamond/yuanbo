package com.yuanbook.util;

import java.io.IOException;

public class ConsoleInputException extends IOException {

	public ConsoleInputException() {
		super();
		System.out.println("The input content is not number.");
	}

	/*public ConsoleInputException(String message) {
		super(message);
	}*/
	
	
	
}
