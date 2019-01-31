package com.jicl.thread;
/**
 * wait()和notify()比较
 * 案例：三线程顺序打印10次ABC
 * @author xianzilei
 *
 */
public class ThreadWaitNotify implements Runnable{
	private String name;
	private Object preObject;
	private Object curObject;
	public ThreadWaitNotify(String name, Object preObject, Object curObject) {
		super();
		this.name = name;
		this.preObject = preObject;
		this.curObject = curObject;
	}
	@Override
	public void run() {
		int count=10;
		while (count>0) {//多线程并发只能使用while，而不能使用if
			synchronized (preObject) {//先获取preObject锁
				synchronized (curObject) {//再获取cur锁
					System.out.print(name);//打印
					count--;
					curObject.notify();//唤醒其他线程竞争curObject锁，注意此时curObject锁并未立即释放。
				}//此时curObject才释放
				try {
					if(count==0){
						preObject.notify();//如果count为0，表示这是最后一次打印，直接释放对象锁
					}else{						
						preObject.wait();//立即释放 prev锁，当前线程休眠，等待唤醒
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		Object a=new Object();
		Object b=new Object();
		Object c=new Object();
		new Thread(new ThreadWaitNotify("A", c, a)).start();
		Thread.sleep(100);// 保证初始ABC的启动顺序
		new Thread(new ThreadWaitNotify("B", a, b)).start();
		Thread.sleep(100);// 保证初始ABC的启动顺序
		new Thread(new ThreadWaitNotify("C", b, c)).start();
		Thread.sleep(100);// 保证初始ABC的启动顺序
	}
}
