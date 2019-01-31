package com.jicl.functionalInterface;

import java.util.function.Function;

import org.junit.Test;

/**
 * 四大函数式接口：
 * 	3.Function<T , R>：函数式接口，有参有返回值
 * 	----->R apply(T t);
 * @author xianzilei
 *
 */
public class TestFunctionInterface {
	public void getFunction(String str,Function<String,Integer> fun){
		System.out.println(fun.apply(str));
	}
	
	@Test
	public void test(){
		getFunction("998", (s)->Integer.valueOf(s));
	}
}
