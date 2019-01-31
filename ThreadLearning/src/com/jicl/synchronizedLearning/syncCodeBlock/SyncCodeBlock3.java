package com.jicl.synchronizedLearning.syncCodeBlock;
/**
 * synchronized修饰代码块:
 *  3.指定要给某个对象加锁。
 * @author xianzilei
 *
 */
public class SyncCodeBlock3 implements Runnable{

	private Account account;
	
	
	public SyncCodeBlock3(Account account) {
		super();
		this.account = account;
	}


	@Override
	public void run() {
		synchronized (account) {
			account.saveMoney(500);
			account.withdrawMoney(400);
			System.out.println(Thread.currentThread().getName()+":"+account.getMoney());
		}
		//System.out.println(Thread.currentThread().getName()+":"+account.getMoney());
		
	}
	
	public static void main(String[] args) {
		Account account = new Account("张三", 1000);
		SyncCodeBlock3 syncCodeBlock3=new SyncCodeBlock3(account);
		Thread[] threads=new Thread[5];
		for (int i = 0; i < 5; i++) {
			threads[i]=new Thread(syncCodeBlock3,"张三"+i);
			threads[i].start();
		}
	}
	
}
