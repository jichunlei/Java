package com.jicl.synchronizedLearning.syncMethod;

/**
 * synchronized修饰一个静态方法
 * 注：synchronized关键字不能继承。
 *	虽然可以使用synchronized来定义方法，但synchronized并不属于方法定义的一部分，
 *	因此，synchronized关键字不能被继承。如果在父类中的某个方法使用了synchronized关键字，
 *	而在子类中覆盖了这个方法，在子类中的这个方法默认情况下并不是同步的，而必须显式地在子类的这个
 *	方法中加上synchronized关键字才可以。当然，还可以在子类方法中调用父类中相应的方法，这样虽然子
 *	类中的方法不是同步的，但子类调用了父类的同步方法，因此，子类的方法也就相当于同步了。
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
