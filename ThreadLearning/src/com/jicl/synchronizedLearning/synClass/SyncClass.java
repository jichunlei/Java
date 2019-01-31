package com.jicl.synchronizedLearning.synClass;

import com.jicl.synchronizedLearning.syncMethod.SyncStaticMethod;
/**
 * Synchronized������һ����
 * ������������һ����̬��������������ͬ��
 * @author xianzilei
 * 
 */
public class SyncClass implements Runnable{
	private static int count = 0;

	private void method() {
		synchronized (SyncClass.class) {			
			for (int i = 0; i < 5; i++) {
				count++;
				System.out.println(Thread.currentThread().getName() + ":" + count);
			}
		}
	}

	@Override
	public void run() {
		method();
	}

	public static void main(String[] args) {
		new Thread(new SyncStaticMethod()).start();
		new Thread(new SyncStaticMethod()).start();
		new Thread(new SyncStaticMethod()).start();
	}
	
	/*
	 * �ܽ᣺
	 * A. ����synchronized�ؼ��ּ��ڷ����ϻ��Ƕ����ϣ���������õĶ����ǷǾ�̬�ģ�����ȡ�õ����Ƕ������synchronized���õĶ�����һ����̬������һ���࣬����ȡ�õ����Ƕ��࣬�������еĶ���ͬһ������
	 * B. ÿ������ֻ��һ������lock����֮�������˭�õ������˭�Ϳ��������������Ƶ��Ƕδ��롣
	 * C. ʵ��ͬ����Ҫ�ܴ��ϵͳ������Ϊ���۵ģ���������������������Ծ���������ν��ͬ�����ơ�
	 * */
}
