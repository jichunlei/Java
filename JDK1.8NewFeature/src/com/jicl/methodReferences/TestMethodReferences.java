package com.jicl.methodReferences;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

import org.junit.Test;

/**
 * JDK1.8新特性：方法引用:若lambda体中的内容有方法已经实现了，那么可以使用“方法引用”,也可以理解为方法引用是lambda表达式的另外一种表现形式并且其语法比lambda表达式更加简单
 *		
 * 三种表现形式： 
 *	1. 对象：：实例方法名 
 *	2. 类：：静态方法名 
 *	3. 类：：实例方法名 （lambda参数列表中第一个参数是实例方法的调用 者，第二个参数是实例方法的参数时可用）
 * @author xianzilei
 *
 */
public class TestMethodReferences {

	@Test
	public void test() {
		//普通lambda表达式写法
		Consumer<Integer> consumer=(i)->System.out.println(i);
		consumer.accept(996);
		
		//表现形式1：（对象：：实例方法名）
		Consumer<Integer> consumer1=System.out::println;
		consumer1.accept(997);
		
		//表现形式2：（类：：静态方法名）
		Function<String,Integer> function2=Integer::valueOf;
		Integer apply = function2.apply("998");
		System.out.println(apply);
		
		//表现形式3：（类：：实例方法名）
		BiFunction<String, String, Boolean> biFunction=String::equals;
		Boolean result = biFunction.apply("hello", "hello");
		System.out.println(result);
	}
}
