package com.jicl.generic;

/**
 * @author xianzilei
 * @date 2019/02/27
 */
public class GeneratorInterfaceImpl<T> implements GeneratorInterface<T> {

    private T t;
    
    /* (non-Javadoc)
     * @see com.jicl.generic.GeneratorInterface#get()
     */
    @Override
    public T get() {
        // TODO Auto-generated method stub
        return t;
    }

    /* (non-Javadoc)
     * @see com.jicl.generic.GeneratorInterface#set(java.lang.Object)
     */
    @Override
    public void set(T t) {
        this.t=t;
    }
}
