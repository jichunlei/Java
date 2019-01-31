package com.jicl.thread;
/**
 * wait()��notify()�Ƚ�
 * ���������߳�˳���ӡ10��ABC
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
		while (count>0) {//���̲߳���ֻ��ʹ��while��������ʹ��if
			synchronized (preObject) {//�Ȼ�ȡpreObject��
				synchronized (curObject) {//�ٻ�ȡcur��
					System.out.print(name);//��ӡ
					count--;
					curObject.notify();//���������߳̾���curObject����ע���ʱcurObject����δ�����ͷš�
				}//��ʱcurObject���ͷ�
				try {
					if(count==0){
						preObject.notify();//���countΪ0����ʾ�������һ�δ�ӡ��ֱ���ͷŶ�����
					}else{						
						preObject.wait();//�����ͷ� prev������ǰ�߳����ߣ��ȴ�����
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
		Thread.sleep(100);// ��֤��ʼABC������˳��
		new Thread(new ThreadWaitNotify("B", a, b)).start();
		Thread.sleep(100);// ��֤��ʼABC������˳��
		new Thread(new ThreadWaitNotify("C", b, c)).start();
		Thread.sleep(100);// ��֤��ʼABC������˳��
	}
}
