package com.jicl.collection.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import com.jicl.pojo.Person;

/**
 * set集合学习
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
		set.add("ace");//set集合元素不允许重复
		set.add(null);//set集合允许有null值，但是只能有一个
		set.add(null);
		//插入顺序与读取顺序不相关
		System.out.println(set+"长度："+set.size());
		
		Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next()+" ");
		}
	}
	
	/**
	 * HashSet判断元素是否有重复的判断流程（只有hashcode() 值相同且equals() 返回为true 时,hashset 集合才会认为这两个元素是相同的元素）
	 * 1.先判断两个元素的hashcode是否相同
	 * 	1.1.如果不相同，则表示两个对象不可能相同，可以插入该元素
	 * 	1.2.如果相同，则继续使用equals方法进行比较
	 * 		1.2.1.如果为false,则说明元素不重复，可以插入该元素
	 * 		1.2.2.如果为true，则说明元素重复，不可插入
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testHashSet() {
		Set set=new HashSet();
		Person person1=new Person(2,"zhangsan");
		Person person2=new Person(1,"lisi");
		Person person3=new Person(3,"wangwu");
		boolean add1 = set.add(person1);
		String result1=add1==true?"成功":"失败";
		System.out.println("第一次插入数据："+result1);
		boolean add2 = set.add(person2);
		String result2=add2==true?"成功":"失败";
		System.out.println("第二次插入数据："+result2);
		boolean add3 = set.add(person3);
		String result3=add3==true?"成功":"失败";
		System.out.println("第三次插入数据："+result3);
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
		String result1=add1==true?"成功":"失败";
		System.out.println("第一次插入数据："+result1);
		boolean add2 = ts.add(person2);
		String result2=add2==true?"成功":"失败";
		System.out.println("第二次插入数据："+result2);
		boolean add3 = ts.add(person3);
		String result3=add3==true?"成功":"失败";
		System.out.println("第三次插入数据："+result3);
		System.out.println(ts);
	}
	
	
	
}
