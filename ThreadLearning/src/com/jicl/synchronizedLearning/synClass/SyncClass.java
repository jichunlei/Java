package com.jicl.synchronizedLearning.synClass;

import com.jicl.synchronizedLearning.syncMethod.SyncStaticMethod;
/**
 * Synchronized作用于一个类
 * 作用类似修饰一个静态方法，对整个类同步
 * @author xianzilei
 * 
 */
public class SyncClass implements Runnable{
	private static int count = 0;

	private void method() {
		synchronized (SyncClass.class) {			
			for (int i = 0; i < 5; i++) {
				count++;
				System.out.println(Thread.currentThread().getName() + ":" + count);
			}
		}
	}

	@Override
	public void run() {
		method();
	}

	public static void main(String[] args) {
		new Thread(new SyncStaticMethod()).start();
		new Thread(new SyncStaticMethod()).start();
		new Thread(new SyncStaticMethod()).start();
	}
	
	/*
	 * 总结：
	 * A. 无论synchronized关键字加在方法上还是对象上，如果它作用的对象是非静态的，则它取得的锁是对象；如果synchronized作用的对象是一个静态方法或一个类，则它取得的锁是对类，该类所有的对象同一把锁。
	 * B. 每个对象只有一个锁（lock）与之相关联，谁拿到这个锁谁就可以运行它所控制的那段代码。
	 * C. 实现同步是要很大的系统开销作为代价的，甚至可能造成死锁，所以尽量避免无谓的同步控制。
	 * */
}
