package com.win.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class MyQueue {

    Stack<Integer> stack;
    List<Integer> list;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stack = new Stack();
        list = new ArrayList<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        list.clear();
         // 2

        while (!stack.empty()) {  // 0
            list.add(stack.pop());  // 1
        }

        stack.push(x);

        for (int i = 0; i < list.size(); i++) {
            stack.push(list.get(i)); // 1
        }

    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        return stack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return stack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack.empty();
    }
}