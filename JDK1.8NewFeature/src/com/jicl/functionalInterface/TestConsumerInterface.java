package com.jicl.functionalInterface;

import java.util.function.Consumer;
import org.junit.Test;

/**
 * 四大函数式接口：
 * 	1.Consumer<T>：消费型接口，有参无返回值
 * 		void accept(T t);
 * @author xianzilei
 *
 */
public class TestConsumerInterface {
	public void getConsumer(double money,Consumer<Double> consumer){
		consumer.accept(money);
	}
	
	@Test
	public void test(){
		getConsumer(999,(m)->System.out.println("一共消费"+m+"元"));
	}
}
