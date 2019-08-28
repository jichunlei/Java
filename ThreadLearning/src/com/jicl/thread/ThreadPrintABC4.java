package com.jicl.thread;

import java.util.concurrent.Semaphore;

/**
 * @ClassName: ThreadPrintABC4
 * @Description: 打印ABC写法四：Semaphore信号量方式
 * @Author xianzilei
 * @DateTime 2019年8月28日 上午8:22:01
 */
public class ThreadPrintABC4 {
	// 定义三个信号量，其中s1初始值为1，保证现打印A字母
	private static Semaphore s1 = new Semaphore(1);
	private static Semaphore s2 = new Semaphore(0);
	private static Semaphore s3 = new Semaphore(0);

	// 线程A打印
	static class ThreadA extends Thread {
		@Override
		public void run() {
			try {
				for (int i = 0; i < 10; i++) {
					// ThreadA获取信号量，s1信号量减一变为0后无法进行获取
					s1.acquire();
					System.out.print("A");
					// ThreadA释放信号s2，s2信号量加1（初始为0），此时其余线程可以获取s2信号量
					s2.release();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// 线程B打印
	static class ThreadB extends Thread {
		@Override
		public void run() {
			try {
				for (int i = 0; i < 10; i++) {
					// ThreadB获取信号量，s2信号量减一变为0后无法进行获取
					s2.acquire();
					System.out.print("B");
					// ThreadB释放信号s3，s3信号量加1（初始为0），此时其余线程可以获取s3信号量
					s3.release();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	// 线程C打印
	static class ThreadC extends Thread {
		@Override
		public void run() {
			try {
				for (int i = 0; i < 10; i++) {
					// ThreadC获取信号量，s3信号量减一变为0后无法进行获取
					s3.acquire();
					System.out.print("C");
					// ThreadC释放信号s1，s1信号量加1（初始为0），此时其余线程可以获取s1信号量
					s1.release();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		new ThreadA().start();
		new ThreadB().start();
		new ThreadC().start();
	}
}
