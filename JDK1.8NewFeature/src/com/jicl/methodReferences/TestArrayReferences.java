package com.jicl.methodReferences;

import java.util.function.Function;

import org.junit.Test;

/**
 * 数组引用
 * 格式：Type[]::new
 * @author xianzilei
 *
 */
public class TestArrayReferences {
	@Test
	public void test1(){
		Function<Integer, String[]> function1=(a)->new String[a];
		String[] array1 = function1.apply(10);
		System.out.println(array1.length);
		Function<Integer, String[]> function2=String[]::new;
		String[] array2 = function2.apply(20);
		System.out.println(array2.length);
	}
}
