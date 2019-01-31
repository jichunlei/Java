package com.jicl.synchronizedLearning.syncMethod;

/**
 * synchronized����һ����̬����
 * ע��synchronized�ؼ��ֲ��ܼ̳С�
 *	��Ȼ����ʹ��synchronized�����巽������synchronized�������ڷ��������һ���֣�
 *	��ˣ�synchronized�ؼ��ֲ��ܱ��̳С�����ڸ����е�ĳ������ʹ����synchronized�ؼ��֣�
 *	���������и���������������������е��������Ĭ������²�����ͬ���ģ���������ʽ������������
 *	�����м���synchronized�ؼ��ֲſ��ԡ���Ȼ�������������෽���е��ø�������Ӧ�ķ�����������Ȼ��
 *	���еķ�������ͬ���ģ�����������˸����ͬ����������ˣ�����ķ���Ҳ���൱��ͬ���ˡ�
 * 
 * @author xianzilei
 *
 */
public class SyncStaticMethod implements Runnable{
	private static int count=0;
	
	private synchronized static void method(){
		for (int i = 0; i < 5; i++) {
			count++;
			System.out.println(Thread.currentThread().getName()+":"+count);
		}
	}
	
	@Override
	public void run(){
		method();	
	}
	
	
	
	public static void main(String[] args) {
		new Thread(new SyncStaticMethod()).start();
		new Thread(new SyncStaticMethod()).start();
		new Thread(new SyncStaticMethod()).start();
	}
}
