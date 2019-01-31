package com.jicl.functionalInterface;
/**
 * 自定义的函数式接口
 * @author xianzilei
 *
 */
@FunctionalInterface
public interface MyFunctionalInterface {
	public int method1(int i);
	
	//可以任意定义默认方法
	default public int method2(){
		return 2;
	}
	
	//可以任意定义静态方法
	static int method3(){
		return 3;
	}
}
