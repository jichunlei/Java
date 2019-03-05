package com.jicl.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * List学习
 * 
 * @author xianzilei
 *
 */
public class ListLearning {
	/**
	 * ArrayList构造方法
	 */
	@Test
	public void testArrayListConstructor() {
		ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList("1", "2", "4", "5"));
		Iterator<String> iterator = arrayList.iterator();
		while (iterator.hasNext()) {
			String str = (String) iterator.next();
			System.out.print(str + "-");
		}
	}

	/**
	 * ArrayList线程安全问题
	 */
	@Test
	public void testArrayListThreadSafe() {
		//线程不安全
//		List<Integer> list = new ArrayList<Integer>();
		//线程安全
		List<Integer> list = Collections.synchronizedList(new ArrayList<Integer>());
		new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				list.add(i);
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		new Thread(() -> {
			for (int i = 1000; i < 2000; i++) {
				list.add(i);
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int j = 0; j < list.size(); j++) {
			System.out.println("第" + (j + 1) + "元素为：" + list.get(j));
		}
	}
	
	/**
	 * LinkedList测试
	 */
	@Test
	public void testLinkedList() {
		LinkedList<Integer> linkedList=new LinkedList<>();
		linkedList.add(5);
		linkedList.get(0);
	}
	
}
 