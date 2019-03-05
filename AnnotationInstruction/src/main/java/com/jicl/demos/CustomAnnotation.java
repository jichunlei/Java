package com.jicl.demos;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 自定义注解
 * @author xianzilei
 *
 */
@Retention(RetentionPolicy.RUNTIME)//元注解
//元注解：@Retention、@Documented、@Target、@Inherited、@Repeatable 5 种。

public @interface CustomAnnotation {
	//注解的属性：无形参的方法形式表示，方法名表示属性名，方法返回值类型表示属性的类型
	//属性的类型必须是 8 种基本数据类型外加 类、接口、注解及它们的数组。
	int id();
	String name();
	int age() default 18;//注解属性可以有默认值，使用default关键字
}
