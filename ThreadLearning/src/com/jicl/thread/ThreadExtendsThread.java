package com.jicl.thread;

public class ThreadExtendsThread extends Thread{
   private String name;
	
	public ThreadExtendsThread(String name) {
	super();
	this.name = name;
}



	public void run(){
	   for (int i = 0; i < 10; i++) {
		System.out.println(name+"--"+i);
		try {
			sleep((long) (Math.random()*1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
   }
   
   
   
   public static void main(String[] args) {
	   ThreadExtendsThread thread1=new ThreadExtendsThread("thread1");
	   ThreadExtendsThread thread2=new ThreadExtendsThread("thread2");
	   thread1.start();
	   thread2.start();
   }
}
