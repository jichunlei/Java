package com.jicl.generic;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

/**
 * 泛型介绍：
 * 泛型使用原则：无论何时，如果你能做到，你就该尽量使用泛型方法。
 *          也就是说，如果使用泛型方法将整个类泛型化，那么就应该使用泛型方法。
 *          另外对于一个static的方法而已，无法访问泛型类型的参数。所以如果static方法要使用泛型能力，就必须使其成为泛型方法。
 * 
 * @author xianzilei
 * @date 2019/02/27
 */
public class GenericIntroduction {

    /**
     * 举个例子
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    @Test(expected = ClassCastException.class)
    public void genericExample() {
        List arrayList = new ArrayList();
        arrayList.add("a");
        arrayList.add(1);
        for (Object object : arrayList) {
            String obj = (String)object;
            System.out.println("泛型测试:" + "obj = " + obj);
        }
    }

    /**
     * 泛型只在编译阶段起作用：泛型类型在逻辑上看以看成是多个不同的类型，实际上都是相同的基本类型
     */
    @SuppressWarnings("rawtypes")
    @Test
    public void test2() {
        List<String> stringList = new ArrayList<String>();
        List<Integer> integerList = new ArrayList<Integer>();
        Class stringClass = stringList.getClass();
        Class integerClass = integerList.getClass();
        System.out.println("stringClass类型：" + stringClass);
        System.out.println("integerClass类型：" + integerClass);
        assertThat(stringClass, equalTo(integerClass));
    }

    /**
     * 泛型接口
     */
    @Test
    public void testGenericClass() {
        GenericClass<Integer> genericClass1 = new GenericClass<Integer>(111);
        GenericClass<String> genericClass2 = new GenericClass<String>("222");
        assertThat(genericClass1.getId(), equalTo(111));
        assertThat(genericClass2.getId(), equalTo("222"));
    }

    /**
     * 泛型类:如果不传入泛型类型实参的话，在泛型类中使用泛型的方法或成员变量定义的类型可以为任何的类型
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    @Test
    public void testGenericClass2() {
        GenericClass genericClass = new GenericClass(111);
        // 不会报错
        genericClass.setId("123");
    }

    /**
     * 泛型接口
     */
    @Test
    public void testGeneratorInterface() {
        GeneratorInterface<String> generatorInterface1 = new GeneratorInterfaceImpl<String>();
        generatorInterface1.set("11");
        assertThat(generatorInterface1.get(), is("11"));

        GeneratorInterface<Integer> generatorInterface2 = new GeneratorInterfaceImpl<Integer>();
        generatorInterface2.set(88);
        assertThat(generatorInterface2.get(), is(88));
    }

    /**
     * 通配符 同一种泛型可以对应多个版本（因为参数类型是不确定的），不同版本的泛型类实例是不兼容的
     */
    @Test
    public void testWildcards() {
        GenericClass<Integer> gInteger = new GenericClass<Integer>(123);
        GenericClass<Number> gNumber = new GenericClass<Number>(456);
        // 该方法编译时会报错，因为对于不同泛型参数类型是不相关的，即不兼容
        // method1(gInteger);
        method1(gNumber);// 必须类型一致才可以编译成功

        // 该方法编译时不会报错，注意：此处’？’是类型实参，而不是类型形参
        // 1.当类型不确定时，可以使用？通配符
        // 2.当操作类型时，无需使用类型中的具体方法，可以使用？通配符
        method2(gInteger);

    }

    /**
     * 无边界通配符：<?>
     */
    @Test
    public void testUnboundedWildcards() {
        List<String> list1 = new ArrayList<String>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        method3(list1);

        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        method3(list2);
        Object obj1 = list1.get(4);
        Object obj2 = list2.get(4);
        assertThat(obj1, nullValue());
        assertThat(obj2, nullValue());
    }

    /**
     * 固定上边界的通配符:<? extends E> 限于：1.继承了父类E的子类；2.实现了接口E的类
     */
    @Test
    public void testUpperBoundedWildcards() {
        List<Integer> integers = Arrays.asList(1,2,3,4,5);
        List<Double> doubles = Arrays.asList(1.1,2.2,3.3,4.4,5.5);
        method4(integers);
        method4(doubles);
    }
    
    /**
     * 固定下边界的通配符：<? super E>
     */
    @Test
    public void testLowerBoundedWildcards() {
        List<Object> objects = new ArrayList<Object>();
        method5(objects);
    }
    

    private void method1(GenericClass<Number> gNumber) {
        System.out.println(gNumber.getId());
    }

    private void method2(GenericClass<?> gNumber) {
        System.out.println(gNumber.getId());
    }

    /**
     * 类型任意
     * @param list
     */
    private void method3(List<?> list) {
        // list.add(1);//编译报错
        // list.add("11");//编译报错
        list.add(null);// 因为我们根本不知道list会接受到具有什么样的泛型List, 所以除了null之外什么也不能add.
        for (Object object : list) {
            System.out.println(object);
        }
    }
    
    /**
     * 类型必须是Integer的子类类型
     * @param list
     */
    private void method4(List<? extends Number> list) {
        // list.add(1);//编译报错
        // list.add("1.1");//编译报错
        list.add(null);//传入的可能是Integer, 也可能是Double, 我们在写这个方法时不能确定传入的什么类型的数据
        for (Number number : list) {
            System.out.println(number);
        }
    }
    
    /**
     * 类型必须是Object到Integer之间的类型
     * @param list
     */
    private void method5(List<? super Integer> list) {
        list.add(1);
        list.add(null);
        for (Object object : list) {
            System.out.println(object);
        }
    }
    
    

}
