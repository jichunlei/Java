package com.jicl.functionalInterface;

import org.junit.Test;

/**
 * jdk1.8新特性：
 * 		3.函数式接口：仅仅只包含一个抽象方法的接口（注意是抽象方法）
 * @author xianzilei
 *
 */
public class TestMyFunctionalInterface{
	@Test
	public void test() {
		MyFunctionalInterface myFI=i->i*2;
		System.out.println(myFI.method1(99));
		System.out.println(myFI.method2());
		System.out.println(MyFunctionalInterface.method3());
	}
	
	
}
