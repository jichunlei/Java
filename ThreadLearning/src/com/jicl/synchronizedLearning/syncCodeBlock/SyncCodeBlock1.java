package com.jicl.synchronizedLearning.syncCodeBlock;
/**
 * synchronized���δ����:
 *  1.һ���̷߳���һ�������е�synchronized(this)ͬ�������ʱ��������ͼ���ʸö�����߳̽�������
 * @author xianzilei
 *
 */
public class SyncCodeBlock1 implements Runnable{
	public static int count;
	
	public SyncCodeBlock1(){
		count=0;
	}

	@Override
	public void run() {
		synchronized (this) {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName()+":"+(count++));
			}
		}
	}
	
	public static void main(String[] args) {
		//ͬһ������
		/*SyncCodeBlock1 syncCodeBlock1 = new SyncCodeBlock1();
		new Thread(syncCodeBlock1).start();
		new Thread(syncCodeBlock1).start();
		new Thread(syncCodeBlock1).start();
		new Thread(syncCodeBlock1).start();
		new Thread(syncCodeBlock1).start();
		new Thread(syncCodeBlock1).start();*/
		
		//��ͬ�Ķ���
		new Thread(new SyncCodeBlock1()).start();
		new Thread(new SyncCodeBlock1()).start();
		new Thread(new SyncCodeBlock1()).start();
		new Thread(new SyncCodeBlock1()).start();
		new Thread(new SyncCodeBlock1()).start();
		new Thread(new SyncCodeBlock1()).start();
	}
}
