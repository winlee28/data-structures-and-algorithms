package com.win.data.queue;

import org.omg.CORBA.Object;

/**
 * 取模计算公式 a%b = a - (int)(a / b) * b
 *
 * @param <E>
 */
public class LoopQueue<E> implements IQueue<E> {

    private E[] data;

    private int front;
    private int tail;
    private int size;

    public LoopQueue(int capacity) {
        //循环队列中 是浪费了一个元素的 因为当front == tail的时候 代表了队列为空
        //所以当队列满了的时候 计算方式为：（tail+1）% data.length == front
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    @Override
    public void enQueue(E e) {
        if ((tail + 1) % data.length == front) { //队列满
            reSize(2 * getCapacity());
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    private void reSize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E deQueue() {

        E e = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (getCapacity() / 4 == size && getCapacity() / 2 != 0) {
            reSize(getCapacity() / 2);
        }
        return e;
    }

    @Override
    public E getFront() {
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    public int getCapacity() {
        return data.length - 1;
    }
}
