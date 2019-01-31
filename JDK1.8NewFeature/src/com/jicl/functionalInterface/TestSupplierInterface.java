package com.jicl.functionalInterface;

import java.util.function.Supplier;

import org.junit.Test;

/**
 * 四大函数式接口：
 * 	2.Supplier<T>：供给型接口，无参有返回值
 * 		T get();
 * @author xianzilei
 *
 */
public class TestSupplierInterface {
	public void getSupplier(Supplier<Integer> sup){
		System.out.println(sup.get());
	}
	
	@Test
	public void test(){
		getSupplier(()->99);
	}
}
