package com.win.data.bst;

public class BSTMain {

    public static void main(String[] args) {

        BST<Integer> bst = new BST<>();

        int[] data = new int[]{4, 3, 6, 9, 2, 0, 1};

        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }

//        System.out.println(bst.toString());
//        bst.preOrder();
//        System.out.println();
//        bst.preOrderNR();
//        bst.inOrder();
//        System.out.println();
//        bst.postOrder();


//        bst.levelOrder();


        System.out.println(bst.min());
        System.out.println(bst.minNR());
        System.out.println(bst.max());
        System.out.println(bst.maxNR());
    }


}

