package com.jicl.demos;

import org.junit.Test;

/**
 * ע�������
 * @author xianzilei
 *
 */
public class TestAnnotation {
	
	/**
	 * Deprecated��������ǹ�ʱ��Ԫ��
	 * SuppressWarnings����ֹ����
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testDeprecated() {
		Person person=new Person();
		person.method1();
	}
	
	/**
	 * Deprecated��SuppressWarningsע�����
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testSafeVarargs() {
		Person person=new Person();
		person.method1();
	}
}
