package com.jicl.methodReferences;

import java.util.function.BiFunction;
import java.util.function.Supplier;

import org.junit.Test;

/**
 * 构造器引用
 * 格式：ClassName::new
 * @author xianzilei
 *
 */
public class TestConstructorReferences {
	
	@Test
	//构造方法引用  类名::new（无参）
	public void test1(){
		Supplier<Person> supplier=()->new Person();
		System.out.println(supplier.get());
		Supplier<Person> supplier2=Person::new;//Person类必须有无参构造器
		System.out.println(supplier2.get());	
	}
	
	@Test
	//构造方法引用 类名::new （带参）
	public void test2(){
		BiFunction<String, Integer,Person> biFunction1=(a,b)->new Person(a, b);
		Person person1 = biFunction1.apply("张三", 18);
		System.out.println(person1);
		
		BiFunction<String, Integer,Person> biFunction2=Person::new;
		Person person2 = biFunction2.apply("张三", 18);
		System.out.println(person2);
		
	}
	
}
