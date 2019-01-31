package com.jicl.thread;

public class ThreadWithYield extends Thread {
	@Override
	public void run(){
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+"--"+i);
			if(i==5){
				Thread.yield();
			}
		}
	}
	
	public static void main(String[] args) {
		ThreadWithYield thread0=new ThreadWithYield();
		ThreadWithYield thread1=new ThreadWithYield();
		thread0.setPriority(1);
		thread1.setPriority(10);
		thread0.start();
		thread1.start();
		
	}
}
