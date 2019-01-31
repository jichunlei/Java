package com.jicl.thread;

public class ThreadWithJoin implements Runnable{
	private String name;

	public ThreadWithJoin(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"--子线程开始！");
		for (int i = 0; i < 10; i++) {
			System.out.println(name + "--" + i);
			try {
				Thread.sleep((long) (Math.random() * 1));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		System.out.println(Thread.currentThread().getName()+"--子线程结束！");
	}
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()+"--主线程开始！");
		Thread thread0 = new Thread(new ThreadWithJoin("Thread0"));
		Thread thread1 = new Thread(new ThreadWithJoin("Thread1"));
		thread0.start();
		thread1.start();
		try {
			thread0.join();
			thread1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"--主线程结束！");
	}
}
