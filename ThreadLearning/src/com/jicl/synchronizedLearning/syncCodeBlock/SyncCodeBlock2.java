package com.jicl.synchronizedLearning.syncCodeBlock;
/**
 * synchronized���δ����:
 *  3.��һ���̷߳��ʶ����һ��synchronized(this)ͬ�������ʱ����һ���߳���Ȼ���Է��ʸö����еķ�synchronized(this)ͬ������顣
 * @author xianzilei
 *
 */
public class SyncCodeBlock2 implements Runnable{
	public static int count;
	
	public SyncCodeBlock2(){
		count=0;
	}

	@Override
	public void run() {
		if(Thread.currentThread().getName().equals("A")){
			addCount();	
		}else{
			printCount();
		}
	}

	//synchronized����
	private void addCount() {
		synchronized (this) {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName()+":"+count);
				count++;
			}
		}
	}
	
	//��synchronized����
	private void printCount(){
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName()+":"+count);
		}
	}
	
	
	
	public static void main(String[] args) {
		SyncCodeBlock2 syncCodeBlock2 = new SyncCodeBlock2();
		new Thread(syncCodeBlock2,"A").start();
		new Thread(syncCodeBlock2,"B").start();
	}
}
