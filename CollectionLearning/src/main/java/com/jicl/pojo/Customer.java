package com.jicl.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public static String username;

	private transient String password;
	
	 public String getUsername() {
		 return username;
	 }

}
