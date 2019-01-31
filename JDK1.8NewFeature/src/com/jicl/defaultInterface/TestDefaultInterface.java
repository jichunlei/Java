package com.jicl.defaultInterface;

import org.junit.Test;

/**
 * ≤‚ ‘DefaultInterface
 * @author xianzilei223
 *
 */
public class TestDefaultInterface {
	@Test
	public void test(){
		DefaultInterface defaultInterface=new DefaultInterface() {
			
			@Override
			public int method1() {
				return 2;
			}
		};
		System.out.println(defaultInterface.method1());
		System.out.println(defaultInterface.method2());
	}
}
