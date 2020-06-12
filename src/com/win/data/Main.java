package com.win.data;

import com.win.data.array.ArrayJava;

public class Main {

    public static void main(String[] args) {
        ArrayJava<Integer> array = new ArrayJava<>();

//        array.add(0, 1);
//        array.add(1, 9);
//        array.add(2, 5);
//        array.add(3, 6);
//        array.printAll();
//        array.add(2, 0);
//        array.printAll();
//
//        array.removeFirst();
//        array.printAll();
//        array.removeLast();
//        array.printAll();
//        array.remove(1);
//        array.printAll();
//        array.add(1, 5);
//        array.add(2, 6);
//        array.printAll();
//        boolean contains = array.contains(5);
//        System.out.println(contains);
//        array.printAll();
//        int i = array.get(2);
//        System.out.println(i);
//        int i1 = array.find(2);
//        System.out.println(6);
//        array.set(3,7);
//        array.printAll();


        for (int i = 0; i < 11; i++) {
            array.addLast(i);
            array.printAll();
        }

        for (int i = 0; i < 8; i++) {
            array.removeFirst();
            array.printAll();
        }

    }
}
