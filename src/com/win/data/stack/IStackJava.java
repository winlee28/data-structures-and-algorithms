package com.win.data.stack;

public interface IStackJava<E> {

    void push(E e);

    E pop();

    E peek();

    boolean isEmpty();

    int getSize();


}
