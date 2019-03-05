package com.jicl.extend.transientlearning;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import com.jicl.pojo.Customer;

public class TransientLearning {
	File file = new File("C:\\Users\\xianzilei\\Desktop\\user.txt");
	/**
	 * 被transient关键字修饰的变量不再能被序列化，
	 * 一个静态变量不管是否被transient修饰，均不能被序列化。
	 */
	@Test
	public void testTransient() {
		//初始化数据
		Customer customer=new Customer();
		customer.setPassword("123");
		Customer.username="zhangsan";
		System.out.println(customer.getUsername()+"--"+customer.getPassword());
		
		//序列化
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(customer);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(oos);
		}

		//反序列化
		ObjectInputStream ois = null;

		try {
			Customer.username="lisi";
			ois = new ObjectInputStream(new FileInputStream(file));
			Customer obj = (Customer) ois.readObject();
			System.out.println(obj.getUsername()+"--"+obj.getPassword());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
