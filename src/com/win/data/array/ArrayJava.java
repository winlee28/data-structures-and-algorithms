package com.win.data.array;

public class ArrayJava<E> {

    private E[] data;
    private int size;

    public ArrayJava(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    public ArrayJava() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void add(int index, E e) {

        if (index < 0 || index > size) { // 如果大于size 那么数组就不连续了
            throw new IllegalArgumentException("add fail. index must >= 0 ||  <= size");
        }

        if (size == data.length) {
            reSize(2 * getCapacity()); //扩容
        }

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = e;
        size++;

    }

    private void reSize(int newCapacity) {

        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;

    }

    public E get(int index) {

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get fail.index  must >= 0 && index < size ");
        }

        return data[index];
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("set fail.index  must >= 0 && index < size ");
        }

        data[index] = e;

    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int find(E e) {

        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;

    }

    public void removeFirst() {
        remove(0);
    }

    public void removeLast() {
        remove(size - 1);
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove fail.index  must >= 0 && index < size ");
        }

        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }

        size--;
        if (getCapacity() / size == 4) {
            reSize(getCapacity() / 2);
        }
    }

    public void printAll() {
        int capacity = getCapacity();
        System.out.println("数组大小" + capacity);
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }


}

























