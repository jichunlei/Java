package com.jicl.synchronizedLearning.syncMethod;
/**
 * ∏∏¿‡
 * @author xianzilei
 *
 */
public class FatherClass implements Runnable{
	
	public static int count=0;
	@Override
	public synchronized void run(){
		for (int i = 0; i < 5; i++) {
			count++;
			System.out.println(Thread.currentThread().getName()+":"+count);
		}
	}
}
