package com.jicl.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: ThreadPrintABC3
 * @Description: 打印ABC写法三：ReentrantLock结合Condition
 * @Author xianzilei
 * @DateTime 2019年8月28日 上午8:22:01
 */
public class ThreadPrintABC3 {
	// 定义一个可重入锁及三个状态
	private static Lock lock = new ReentrantLock();
	private static Condition c1 = lock.newCondition();
	private static Condition c2 = lock.newCondition();
	private static Condition c3 = lock.newCondition();
	// 控制释放打印字符内容
	private static int state = 1;

	// 线程A打印
	static class ThreadA extends Thread {
		@Override
		public void run() {
			try {
				lock.lock();
				for (int i = 0; i < 10; i++) {
					// 1.判断
					while (state != 1) {
						c1.await();
					}
					// 2.干活
					System.out.print("A");
					// 3.通知
					state = 2;
					c2.signal();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}

	}

	// 线程B打印
	static class ThreadB extends Thread {
		@Override
		public void run() {
			try {
				lock.lock();
				for (int i = 0; i < 10; i++) {
					// 1.判断
					while (state != 2) {
						c2.await();
					}
					// 2.干活
					System.out.print("B");
					// 3.通知
					state = 3;
					c3.signal();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}

	}

	// 线程C打印
	static class ThreadC extends Thread {
		@Override
		public void run() {
			try {
				lock.lock();
				for (int i = 0; i < 10; i++) {
					// 1.判断
					while (state != 3) {
						c3.await();
					}
					// 2.干活
					System.out.print("C");
					// 3.通知
					state = 1;
					c1.signal();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}

	}

	public static void main(String[] args) {
		new ThreadA().start();
		new ThreadB().start();
		new ThreadC().start();
	}
}
