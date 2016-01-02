package com.yuanbook.action;

public class HelloSpring {
	private String name;

	public void setName(String name) {
		this.name = name;
	}
	
	public void hello() {
		System.out.println("Hello " + name);
	}
	
}
