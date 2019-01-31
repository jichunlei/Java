package com.jicl.thread;
/**
 * ��ӡABC
 * @author xianzilei
 *
 */
public class ThreadPrintABC implements Runnable{
	 private String name;
     private Object prev;
     private Object self;

     private ThreadPrintABC(String name, Object prev, Object self) {
         this.name = name;
         this.prev = prev;
         this.self = self;
     }

     @Override
     public void run() {
         int count = 10;
         while (count > 0) {// ���̲߳�����������if������ʹ��whilѭ��
             synchronized (prev) { // �Ȼ�ȡ prev ��
                 synchronized (self) {// �ٻ�ȡ self ��
                     System.out.print(name);//��ӡ
                     count--;

                     self.notifyAll();// ���������߳̾���self����ע���ʱself����δ�����ͷš�
                 }
                 //��ʱִ����self��ͬ���飬��ʱself�����ͷš�
                 try {
                     prev.wait(); // �����ͷ� prev������ǰ�߳����ߣ��ȴ�����
                     /**
                      * JVM����wait()���������߳������ѡȡһ�̣߳�������������������̣߳�����ִ�С�
                      */
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
         }
     }

 public static void main(String[] args) throws Exception {
     Object a = new Object();
     Object b = new Object();
     Object c = new Object();
     ThreadPrintABC pa = new ThreadPrintABC("A", c, a);
     ThreadPrintABC pb = new ThreadPrintABC("B", a, b);
     ThreadPrintABC pc = new ThreadPrintABC("C", b, c);

     new Thread(pa).start();
     Thread.sleep(10);//��֤��ʼABC������˳��
     new Thread(pb).start();
     Thread.sleep(10);
     new Thread(pc).start();
     Thread.sleep(10);
 }
}
