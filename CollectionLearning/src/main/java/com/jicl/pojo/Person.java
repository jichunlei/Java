package com.jicl.pojo;

import java.util.Comparator;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("rawtypes")
public class Person implements Comparator{
	@Setter
	@Getter
	private int id;
	
	@Setter
	@Getter
	private String name;
	
	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Person() {
		
	}
	
	@Override
	public boolean equals(Object obj) {
		return false;
	}
	@Override
	public int hashCode() {
		return 10;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}

	public int compare(Object o1, Object o2) {
		Person person1=(Person) o1;
		Person person2=(Person) o2;
		if(person1.getId()>=person1.getId()) {
			return 1;
		}else {
			return -1;
		}
	}
	
}
