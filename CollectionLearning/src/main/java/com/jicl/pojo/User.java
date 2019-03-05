package com.jicl.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

	private static final long serialVersionUID = 88888888L;

	private String username;

	private transient String password;

	private int age;

	private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
		System.out.println("自定义序列化方法");
	}

	private void readObject(java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {
		System.out.println("自定义反序列化方法");
	}
}
