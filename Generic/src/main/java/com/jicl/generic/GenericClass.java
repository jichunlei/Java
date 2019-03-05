package com.jicl.generic;

import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class GenericClass<T> {
    private T id;

    /**
     * 这个方法虽然使用了泛型，但是不是个泛型方法，只是个普通方法 其中的T是在声明类的时候声明的，所以可以直接拿来使用
     * 
     * @return
     */
    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    /**
     * 这个方法编译会报错，因为E类型为定义，编译器会无法识别
     * 
     * @param e
     * @return
     */
    /*public Exception setE(E e) {
        this.id=e;
    }*/

    /**
     * 真正的泛型方法
     * 1）public 与 返回值中间<T>非常重要，可以理解为声明此方法为泛型方法。
     * 2）只有声明了<T>的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法。
     * 3）<T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
     * 4）与泛型类的定义一样，此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型。
     * @param list
     * @return
     */
    public <E> E genericMethod(List<E> list) {
        if (!list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }
    
    /**
     * 泛型的数量也可以为任意多个,
     * 这个K,V可以出现在这个泛型方法的任意位置。
     * @param map
     * @param k
     * @return
     */
    public <K,V> V getValue(Map<K, V> map,K k) {
        if(map.containsKey(k)) {
            return map.get(k);
        }
        return null;
    }
    
    /**
     * 泛型方法的声明的字母可以与泛型类声明的字母一样，
     * 但是二者类型可以不一样，都是全新的类型
     * 可以与泛型类中声明的T不是同一种类型。
     * @param t
     */
    @SuppressWarnings("hiding")
    public <T> void show(T t) {
        System.out.println(t.toString());
    }
    
    /**
     * 可变参数
     * @param args
     */
    @SuppressWarnings("unchecked")
    public <E> void PrintMsg(E... args) {
        //单一个方法既使用泛型的时候也使用可变参数,此时容易导致堆污染 
        for (E e : args) {
            System.out.println(e);
        }
    }
    
    
}
