package com.jicl.demos;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * �Զ���ע��
 * @author xianzilei
 *
 */
@Retention(RetentionPolicy.RUNTIME)//Ԫע��
//Ԫע�⣺@Retention��@Documented��@Target��@Inherited��@Repeatable 5 �֡�

public @interface CustomAnnotation {
	//ע������ԣ����βεķ�����ʽ��ʾ����������ʾ����������������ֵ���ͱ�ʾ���Ե�����
	//���Ե����ͱ����� 8 �ֻ�������������� �ࡢ�ӿڡ�ע�⼰���ǵ����顣
	int id();
	String name();
	int age() default 18;//ע�����Կ�����Ĭ��ֵ��ʹ��default�ؼ���
}
