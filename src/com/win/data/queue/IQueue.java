package com.win.data.queue;

public interface IQueue<E> {

    void enQueue(E e);

    E deQueue();

    E getFront();

    int getSize();

    boolean isEmpty();

}
