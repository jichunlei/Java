package com.jicl.streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * Stream测试
 * @author xianzilei
 *
 */
public class TestStream {
	/**
	 * 生成流
	 */
	@Test
	public void testGenerateStream(){
		//1.通过Collection 系列集合提供的stream()或者paralleStream()
		List<String> list1 = Arrays.asList("dc","dadw","","adq","c","we");
		Stream<String> stream1 = list1.stream();
		Stream<String> parallelStream1 = list1.parallelStream();//为集合创建并行流
		List<String> collect11 = stream1.filter(s->!s.isEmpty()).collect(Collectors.toList());
		List<String> collect12 = parallelStream1.filter(s->!s.isEmpty()).collect(Collectors.toList());
		System.out.println("通过集合提供的stream()创建流------"+collect11);
		System.out.println("通过集合提供的paralleStream()创建流------"+collect12);
		stream1.close();
		parallelStream1.close();
		
		//2.通过Arrays的静态方法stream()获取数组流
		String[] strings={"dc","dadw","","adq","c","we"};
		Stream<String> stream2 = Arrays.stream(strings);
		List<String> collect2 = stream2.collect(Collectors.toList());
		System.out.println("通过Arrays的静态方法stream()获取数组流------"+collect2);
		stream2.close();
		
		//3.通过Stream类中的静态方法of
		Stream<String> stream3 = Stream.of("dc","dadw","","adq","c","we");
		List<String> collect3 = stream3.collect(Collectors.toList());
		System.out.println("通过Stream类中的静态方法of------"+collect3);
		stream3.close();
		
		//4.创建无限流
		Stream<Integer> stream4 = Stream.iterate(0, (x)->x+2);
		List<Integer> collect4 = stream4.collect(Collectors.toList());
		System.out.println("创建无限流------"+collect4);
		stream4.close();
	}
	
	/**
	 * forEach用法:Stream 提供了新的方法 'forEach' 来迭代流中的每个数据
	 */
	@Test
	public void testForEach(){
		Random random=new Random();
		random.ints(0,10).limit(20).forEach(System.out::println);
	}
	
	/**
	 * map用法:map 方法用于映射每个元素到对应的结果
	 */
	@Test
	public void testMap(){
		List<String> list = Arrays.asList("dc","c","","adq","c","we");
		List<String> collect = list.stream().map(i->i+"1").distinct().collect(Collectors.toList());
		System.out.println(collect);
	}
	
	/**
	 * filter用法:filter 方法用于映射每个元素到对应的结果
	 */
	@Test
	public void testFilter(){
		List<String> list = Arrays.asList("dc","c","","adq","c","we");
		List<String> collect = list.stream().filter(s->!s.isEmpty()).distinct().collect(Collectors.toList());
		System.out.println(collect);
	}
	
	/**
	 * limit用法:limit 方法用于获取指定数量的流
	 */
	@Test
	public void testLimit(){
		Random random=new Random();
		random.ints(0,10).limit(20).forEach(System.out::println);
	}
	
	/**
	 * sorted用法:sorted 方法用于对流进行排序
	 */
	@Test
	public void testSorted(){
		Random random=new Random();
		random.ints(0,100).limit(20).sorted().forEach(System.out::println);
	}
	
	/**
	 * 并行（parallel）程序
	 */
	@Test
	public void testParallel(){
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,9,8);
		list.parallelStream().forEach(System.out::print);//不一定按照原有顺序输出，即并行输出
		System.out.println();
		list.parallelStream().forEachOrdered(System.out::print);//按照原有顺序输出
	}
	
	/**
	 * Collectors:Collectors 类实现了很多归约操作，例如将流转换成集合和聚合元素
	 */
	@Test
	public void testCollectors(){
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,9,8);
		list.parallelStream().forEach(System.out::print);//不一定按照原有顺序输出，即并行输出
		System.out.println();
		list.parallelStream().forEachOrdered(System.out::print);//按照原有顺序输出
	}
	
	/**
	 * reduce ：规约操作
	 */
	@Test
	public void testReduce(){
		//一个入参
		List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7,9,8);
		Integer sum = list1.stream().reduce((a,b)->a+b).get();
		System.out.println(sum);
		//两个入参
		List<String> list2 = Arrays.asList("a","b","b","c");
		String str = list2.stream().reduce("j", (a,b)->a+b);
		System.out.println(str);
		//三个入参
	}
}
