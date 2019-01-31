package com.jicl.thread;

public class ThreadImplRunnable implements Runnable {

	private String name;

	public ThreadImplRunnable(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(name + "--" + i);
			try {
				Thread.sleep((long) (Math.random() * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	public static void main(String[] args) {
		new Thread(new ThreadImplRunnable("thread1")).start();
		new Thread(new ThreadImplRunnable("thread2")).start();
		new Thread(new ThreadImplRunnable("thread3")).start();
	}
}
