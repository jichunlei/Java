package com.jicl.synchronizedLearning.syncCodeBlock;
/**
 * synchronized修饰代码块:
 *  1.一个线程访问一个对象中的synchronized(this)同步代码块时，其他试图访问该对象的线程将被阻塞
 * @author xianzilei
 *
 */
public class SyncCodeBlock1 implements Runnable{
	public static int count;
	
	public SyncCodeBlock1(){
		count=0;
	}

	@Override
	public void run() {
		synchronized (this) {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName()+":"+(count++));
			}
		}
	}
	
	public static void main(String[] args) {
		//同一个对象
		/*SyncCodeBlock1 syncCodeBlock1 = new SyncCodeBlock1();
		new Thread(syncCodeBlock1).start();
		new Thread(syncCodeBlock1).start();
		new Thread(syncCodeBlock1).start();
		new Thread(syncCodeBlock1).start();
		new Thread(syncCodeBlock1).start();
		new Thread(syncCodeBlock1).start();*/
		
		//不同的对象
		new Thread(new SyncCodeBlock1()).start();
		new Thread(new SyncCodeBlock1()).start();
		new Thread(new SyncCodeBlock1()).start();
		new Thread(new SyncCodeBlock1()).start();
		new Thread(new SyncCodeBlock1()).start();
		new Thread(new SyncCodeBlock1()).start();
	}
}
