package com.win.data.queue;

import com.win.data.array.ArrayJava;

public class ArrayQueue<E> implements IQueue<E> {

    private ArrayJava<E> data;

    public ArrayQueue(int capacity) {
        data = new ArrayJava<>(capacity);
    }

    public ArrayQueue() {
        this(10);
    }

    @Override
    public void enQueue(E e) {
        data.addLast(e);
    }

    @Override
    public E deQueue() {
        return data.removeFirst();
    }

    @Override
    public E getFront() {
        return data.getFirst();
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }
}
