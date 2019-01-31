package com.jicl.methodReferences;

import lombok.Data;

@Data
public class Person {
	private String name;
	private int age;

	public Person(){
		
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
}
