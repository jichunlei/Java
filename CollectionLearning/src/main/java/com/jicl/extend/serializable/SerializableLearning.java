package com.jicl.extend.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import com.jicl.pojo.User;

/**
 * 序列化学习
 * --使用Java对象序列化，在保存对象时，会把其状态保存为一组字节，在未来，再将这些字节组装成对象。
 * ----1、如果一个类想被序列化，需要实现Serializable接口。否则将抛出NotSerializableException异常，这是因为，在序列化操作过程中会对类型进行检查，要求被序列化的类必须属于Enum、Array和Serializable类型其中的任何一种。
 * ----2、在变量声明前加上该关键字，可以阻止该变量被序列化到文件中。
 * ----3、在类中增加writeObject 和 readObject 方法可以实现自定义序列化策略
 * 
 * @author xianzilei
 *
 */
public class SerializableLearning {
	private User user;
	File file = new File("C:\\Users\\xianzilei\\Desktop\\user.txt");

	@Before
	public void init() {
		user = new User("zhangsan", "123abc", 18);
		System.out.println(user);
	}

	/**
	 * 序列化测试
	 */
	@Test
	public void testSerializable() {

		// 将对象写入文本中
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(user);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(oos);
		}

		//从文本中读取信息
		ObjectInputStream ois = null;

		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			User user = (User) ois.readObject();
			System.out.println(user);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * ArrayList集合序列化剖析
	 *--Object[] elementData即使被transient修饰，还是可以被序列化
	 *----这是因为在序列化过程中，如果被序列化的类中定义了writeObject 和 readObject 方法，
	 *----虚拟机会试图调用对象类里的 writeObject 和 readObject 方法，进行用户自定义的序列化和反序列化，
	 *----而ArrayList中定义类writeObject 和 readObject 方法
	 *----当然，如果没有这样的方法，则默认调用是 ObjectOutputStream 的 defaultWriteObject 方法
	 *----以及 ObjectInputStream 的 defaultReadObject 方法
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	@SuppressWarnings({ "resource", "unchecked" })
	@Test
	public void testArrayList() throws FileNotFoundException, IOException, ClassNotFoundException {
		List<String> list=new ArrayList<String>(10);
		list.add("hello");
		list.add("Serializable");
		list.add("hello");
		list.add("ArrayList");
		System.out.println(list+"长度："+list.size());
		
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(list);
		
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream(file));
		List<String> obj = (List<String>) ois.readObject();
		System.out.println(obj+"长度："+obj.size());
	}
	
	
}
