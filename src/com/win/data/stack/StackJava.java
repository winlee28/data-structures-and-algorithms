package com.win.data.stack;

import com.win.data.array.ArrayJava;

public class StackJava<E> implements IStackJava<E> {

    private final ArrayJava<E> stack;

    public StackJava(ArrayJava<E> stack) {
        this.stack = stack;
    }

    @Override
    public void push(E e) {
        stack.addLast(e);
    }

    @Override
    public E pop() {
        return stack.removeLast();
    }

    @Override
    public E peek() {
        return stack.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public int getSize() {
        return stack.getSize();
    }
}
