package com.jicl.synchronizedLearning.syncCodeBlock;
/**
 * synchronized修饰代码块:
 *  3.当一个线程访问对象的一个synchronized(this)同步代码块时，另一个线程仍然可以访问该对象中的非synchronized(this)同步代码块。
 * @author xianzilei
 *
 */
public class SyncCodeBlock2 implements Runnable{
	public static int count;
	
	public SyncCodeBlock2(){
		count=0;
	}

	@Override
	public void run() {
		if(Thread.currentThread().getName().equals("A")){
			addCount();	
		}else{
			printCount();
		}
	}

	//synchronized方法
	private void addCount() {
		synchronized (this) {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName()+":"+count);
				count++;
			}
		}
	}
	
	//非synchronized方法
	private void printCount(){
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName()+":"+count);
		}
	}
	
	
	
	public static void main(String[] args) {
		SyncCodeBlock2 syncCodeBlock2 = new SyncCodeBlock2();
		new Thread(syncCodeBlock2,"A").start();
		new Thread(syncCodeBlock2,"B").start();
	}
}
