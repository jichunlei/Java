package com.jicl.thread;

/**
 * @ClassName: ThreadPrintABC
 * @Description: 打印ABC写法一：使用synchronized+notify+wait写法
 * @Author xianzilei
 * @DateTime 2019年8月28日 上午8:22:01
 */
public class ThreadPrintABC implements Runnable {
	private String name;
	private Object prev;
	private Object self;

	public ThreadPrintABC(String name, Object prev, Object self) {
		super();
		this.name = name;
		this.prev = prev;
		this.self = self;
	}

	/**
	 * obj.wait():
	 * 		该方法用来将当前线程置入休眠状态，直到接到通知或被中断为止。
	 * 		在调用wait（）之前，线程必须要获得该对象的对象级别锁，
	 * 		即只能在同步方法或同步块中调用wait（）方法。进入wait（）方法后，
	 * 		当前线程释放锁。在从wait（）返回前，线程与其他线程竞争重新获得锁。
	 * 		如果调用wait（）时，没有持有适当的锁，
	 * 		则抛出IllegalMonitorStateException，
	 * 		它是RuntimeException的一个子类，因此，不需要try-catch结构
	 * obj.notify():
	 * 		该方法也要在同步方法或同步块中调用，
	 * 		即在调用前，线程也必须要获得该对象的对象级别锁，
	 * 		如果调用notify()时没有持有适当的锁，也会抛出IllegalMonitorStateException。
	 *		该方法用来通知那些可能等待该对象的对象锁的其他线程。
	 *		如果有多个线程等待，则线程规划器任意挑选出其中一个wait()状态的线程来发出通知，
	 *		并使它等待获取该对象的对象锁。
	 *		需要注意，notify后，当前线程不会马上释放该对象锁，
	 *	    wait所在的线程并不能马上获取该对象锁，
	 *	       要等到程序退出synchronized代码块后，
	 *		当前线程才会释放锁，wait所在的线程也才可以获取该对象锁，
	 *		 但不惊动其他同样在等待被该对象notify的线程们。
	 *		 当第一个获得了该对象锁的wait线程运行完毕以后，
	 *		 它会释放掉该对象锁，此时如果该对象没有再次使用notify语句，
	 *	          则即便该对象已经空闲，其他wait状态等待的线程由于没有得到该对象的通知，
	 *		 会继续阻塞在wait状态，直到这个对象发出一个notify或notifyAll。
	 *		这里需要注意：它们等待的是被notify或notifyAll，而不是锁。
	 *		这与下面的notifyAll（）方法执行后的情况不同。 
	 * obj.notify():
	 * 		该方法与notify（）方法的工作方式相同，重要的一点差异是：
	 *		notifyAll使所有原来在该对象上wait的线程统统退出wait的状态
	 *		（即全部被唤醒，不再等待notify或notifyAll，但由于此时还没有获取到该对象锁，
	 *		因此还不能继续往下执行），变成等待获取该对象上的锁，
	 *		一旦该对象锁被释放（notifyAll线程退出调用了notifyAll的synchronized代码块的时候），
	 *		他们就会去竞争。如果其中一个线程获得了该对象锁，它就会继续往下执行，
	 *		在它退出synchronized代码块，释放锁后，其他的已经被唤醒的线程将会继续竞争获取该锁，
	 *		一直进行下去，直到所有被唤醒的线程都执行完毕。
	 * 
	 * 
	 * 
	 * 
	 */
	@Override
	public void run() {
		// 打印次数
		int count = 10;
		// 多线程并发使用while
		while (count > 0) {
			// 先获取prev锁
			synchronized (prev) {
				// 再获取self锁
				synchronized (self) {
					// 打印字符
					System.out.print(name);
					// 打印次数减一
					count--;
					// 唤醒所有等待self的线程，但是不是立即唤醒，
					// 而是在当前synchronized代码执行完成后释放
					self.notifyAll();
				}
				// 此时self锁已经释放
				try {
					//如果打印次数已经完成了，则无需再使当前线程阻塞，否则程序无法结束
					if(count==0) {
						//释放对象锁
						prev.notifyAll();
					}else {
						//使当前线程处于prev对象的等待池中，
						//等待别的线程调用prev.notify方法唤醒
						prev.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Object a=new Object();
		Object b=new Object();
		Object c=new Object();
		ThreadPrintABC threadA=new ThreadPrintABC("A", c, a);
		ThreadPrintABC threadB=new ThreadPrintABC("B", a, b);
		ThreadPrintABC threadC=new ThreadPrintABC("C", b, c);
		new Thread(threadA).start();
		//保证A先执行
		Thread.sleep(100);
		new Thread(threadB).start();
		//保证A和B先执行
		Thread.sleep(100);
		new Thread(threadC).start();
	}

}
