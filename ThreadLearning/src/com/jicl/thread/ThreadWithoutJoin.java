package com.jicl.thread;

public class ThreadWithoutJoin implements Runnable{
	private String name;

	public ThreadWithoutJoin(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"--线程开始！");
		for (int i = 0; i < 10; i++) {
			System.out.println(name + "--" + i);
			try {
				Thread.sleep((long) (Math.random() * 1));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		System.out.println(Thread.currentThread().getName()+"--线程结束！");
	}
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()+"--主线程开始！");
		new Thread(new ThreadWithoutJoin("Thread0")).start();
		new Thread(new ThreadWithoutJoin("Thread1")).start();
		System.out.println(Thread.currentThread().getName()+"--主线程结束！");
	}
}
