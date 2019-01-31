package com.jicl.defaultInterface;
/**
 * jdk1.8新特性：
 * 		1.接口的默认方法
 * @author xianzilei
 *
 */
public interface DefaultInterface {
	int method1();
	
	default int method2(){
		return 2*4;
	}
}
