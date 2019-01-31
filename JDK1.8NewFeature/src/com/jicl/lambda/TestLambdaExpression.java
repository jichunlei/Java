package com.jicl.lambda;

import org.junit.Test;

public class TestLambdaExpression {
	
	@Test
	public void testTraditionalSort() {
		LambdaExpression lambdaExpression=new LambdaExpression();
		lambdaExpression.traditionalSort();
	}
	
	@Test
	public void test1LambdaSort1() {
		LambdaExpression lambdaExpression=new LambdaExpression();
		lambdaExpression.lambdaSort1();
	}
	
	
	@Test
	public void test1LambdaSort2() {
		LambdaExpression lambdaExpression=new LambdaExpression();
		lambdaExpression.lambdaSort2();
	}
	
	@Test
	public void test1LambdaSort3() {
		LambdaExpression lambdaExpression=new LambdaExpression();
		lambdaExpression.lambdaSort3();
	}
}
