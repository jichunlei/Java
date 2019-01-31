package com.jicl.functionalInterface;

import java.util.function.Predicate;

import org.junit.Test;

/**
 * 四大函数式接口：
 * 	4.Predicate<T>：断言型接口，有参有返回值，返回值是boolean类型
 * 	----->boolean test(T t);;
 * @author xianzilei
 *
 */
public class TestPredicateInterface {
	public void getPredicate(String str,Predicate<String> pre){
		System.out.println(pre.test(str));
	}
	
	@Test
	public void test(){
		getPredicate("998", (str)->str=="991");
	}
}
