package com.win.data;

import com.win.data.array.ArrayJava;

import java.util.Map;

public class Main {


    public static void main(String[] args) {

        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.peek();
        myQueue.pop();
        myQueue.pop();

        System.out.println(myQueue.empty());

    }


}


