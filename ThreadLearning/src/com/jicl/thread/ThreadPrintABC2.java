package com.jicl.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: ThreadPrintABC
 * @Description: 打印ABC写法二：使用ReentrantLock写法
 * @Author xianzilei
 * @DateTime 2019年8月28日 上午8:22:01
 */
public class ThreadPrintABC2 {
	// 定义一个可重入锁
	private static ReentrantLock lock = new ReentrantLock();
	// 控制释放打印字符内容
	private static int state = 0;

	// 线程A打印
	static class ThreadA extends Thread {
		@Override
		public void run() {
			for (int i = 0; i < 10;) {
				try {
					lock.lock();
					while (state % 3 == 0) {
						System.out.print("A");
						state++;
						i++;
					}
				} finally {
					lock.unlock();
				}
			}

		}
	}

	// 线程B打印
	static class ThreadB extends Thread {
		@Override
		public void run() {
			for (int i = 0; i < 10;) {
				try {
					lock.lock();
					while (state % 3 == 1) {
						System.out.print("B");
						state++;
						i++;
					}
				} finally {
					lock.unlock();
				}
			}

		}
	}

	// 线程C打印
	static class ThreadC extends Thread {
		@Override
		public void run() {
			for (int i = 0; i < 10;) {
				try {
					lock.lock();
					while (state % 3 == 2) {
						System.out.print("C");
						state++;
						i++;
					}
				} finally {
					lock.unlock();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new ThreadA().start();
		new ThreadB().start();
		new ThreadC().start();
	}
}
