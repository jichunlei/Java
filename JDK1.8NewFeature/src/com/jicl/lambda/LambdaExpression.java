package com.jicl.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * jdk1.8新特性：
 * 		2.Lambda表达式（组成：参数列表，箭头（->），以及一个表达式或语句块）====本质：匿名内部类，也可以是一段可以传递的代码
 * 
 * @author xianzilei
 *
 */
public class LambdaExpression {

	/**
	 * 传统排序写法
	 */
	public void traditionalSort() {
		List<String> list = Arrays.asList("bd", "af", "ac", "dg", "cc");
		System.out.println("排序前----" + list);
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		System.out.println("排序后----" + list);
	}

	/**
	 * Lambda表达式写法1
	 */
	public void lambdaSort1() {
		List<String> list = Arrays.asList("bd", "af", "ac", "dg", "cc");
		System.out.println("排序前----" + list);
		Collections.sort(list, (String a, String b) -> {
			return a.compareTo(b);
		});
		System.out.println("排序后----" + list);
	}

	/**
	 * Lambda表达式写法2
	 */
	public void lambdaSort2() {
		List<String> list = Arrays.asList("bd", "af", "ac", "dg", "cc");
		System.out.println("排序前----" + list);
		Collections.sort(list, (String a, String b) -> a.compareTo(b));
		System.out.println("排序后----" + list);
	}

	/**
	 * Lambda表达式写法3
	 */
	public void lambdaSort3() {
		List<String> list = Arrays.asList("bd", "af", "ac", "dg", "cc");
		System.out.println("排序前----" + list);
		Collections.sort(list, (a, b) -> a.compareTo(b));
		System.out.println("排序后----" + list);
	}
}
