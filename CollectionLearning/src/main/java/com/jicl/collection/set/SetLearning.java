package com.jicl.collection.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import com.jicl.pojo.Person;

/**
 * set����ѧϰ
 * @author xianzilei
 *
 */
public class SetLearning {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void TestSet() {
		Set set=new HashSet();
		set.add("abc");
		set.add("cba");
		set.add("bce");
		set.add("abe");
		set.add("cfa");
		set.add("ace");
		set.add("ace");//set����Ԫ�ز������ظ�
		set.add(null);//set����������nullֵ������ֻ����һ��
		set.add(null);
		//����˳�����ȡ˳�����
		System.out.println(set+"���ȣ�"+set.size());
		
		Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next()+" ");
		}
	}
	
	/**
	 * HashSet�ж�Ԫ���Ƿ����ظ����ж����̣�ֻ��hashcode() ֵ��ͬ��equals() ����Ϊtrue ʱ,hashset ���ϲŻ���Ϊ������Ԫ������ͬ��Ԫ�أ�
	 * 1.���ж�����Ԫ�ص�hashcode�Ƿ���ͬ
	 * 	1.1.�������ͬ�����ʾ�������󲻿�����ͬ�����Բ����Ԫ��
	 * 	1.2.�����ͬ�������ʹ��equals�������бȽ�
	 * 		1.2.1.���Ϊfalse,��˵��Ԫ�ز��ظ������Բ����Ԫ��
	 * 		1.2.2.���Ϊtrue����˵��Ԫ���ظ������ɲ���
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testHashSet() {
		Set set=new HashSet();
		Person person1=new Person(2,"zhangsan");
		Person person2=new Person(1,"lisi");
		Person person3=new Person(3,"wangwu");
		boolean add1 = set.add(person1);
		String result1=add1==true?"�ɹ�":"ʧ��";
		System.out.println("��һ�β������ݣ�"+result1);
		boolean add2 = set.add(person2);
		String result2=add2==true?"�ɹ�":"ʧ��";
		System.out.println("�ڶ��β������ݣ�"+result2);
		boolean add3 = set.add(person3);
		String result3=add3==true?"�ɹ�":"ʧ��";
		System.out.println("�����β������ݣ�"+result3);
		System.out.println(set);
	}
	
	/**
	 * 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testTreeSet() {
		TreeSet ts=new TreeSet(new Person());
		Person person1=new Person(2,"zhangsan");
		Person person2=new Person(1,"lisi");
		Person person3=new Person(3,"wangwu");
		boolean add1 = ts.add(person1);
		String result1=add1==true?"�ɹ�":"ʧ��";
		System.out.println("��һ�β������ݣ�"+result1);
		boolean add2 = ts.add(person2);
		String result2=add2==true?"�ɹ�":"ʧ��";
		System.out.println("�ڶ��β������ݣ�"+result2);
		boolean add3 = ts.add(person3);
		String result3=add3==true?"�ɹ�":"ʧ��";
		System.out.println("�����β������ݣ�"+result3);
		System.out.println(ts);
	}
	
	
	
}
