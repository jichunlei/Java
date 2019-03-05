package com.jicl.demos;

import org.junit.Test;

/**
 * 注解测试类
 * @author xianzilei
 *
 */
public class TestAnnotation {
	
	/**
	 * Deprecated：用来标记过时的元素
	 * SuppressWarnings：阻止警告
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testDeprecated() {
		Person person=new Person();
		person.method1();
	}
	
	/**
	 * Deprecated和SuppressWarnings注解测试
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testSafeVarargs() {
		Person person=new Person();
		person.method1();
	}
}
