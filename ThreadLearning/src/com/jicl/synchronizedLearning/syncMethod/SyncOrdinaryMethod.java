package com.jicl.synchronizedLearning.syncMethod;

/**
 * synchronized����һ����ͨ����
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
public class SyncOrdinaryMethod {
	public static void main(String[] args) {
		FatherClass fatherClass = new SonClass();
		new Thread(fatherClass).start();
		new Thread(fatherClass).start();
		new Thread(fatherClass).start();
	}
}
