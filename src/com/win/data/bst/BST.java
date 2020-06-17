package com.win.data.bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {

    private class Node {

        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void add(E e) {
        root = add(root, e);
    }

    /**
     * 添加
     *
     * @param node
     * @param e
     * @return
     */
    private Node add(Node node, E e) {

        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) { //left
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) { //right
            node.right = add(node.right, e);
        }

        return node;

    }


    /**
     * 是否包含某元素
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {

        if (node == null) {
            return false;
        }

        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) { //继续查找左
            return contains(node.left, e);
        } else { //继续查找右
            return contains(node.right, e);
        }
    }

    /**
     * 前序遍历 递归
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 前序遍历 不使用递归  结合使用stack来实现
     */
    public void preOrderNR() {

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            Node pop = stack.pop();
            System.out.println(pop.e);
            if (pop.right != null) { //  先入右节点  Last In First Out
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
    }

    /**
     * 中序遍历 递归
     */
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 后序遍历 递归
     */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    /**
     * 广度优先遍历  （层序遍历）
     * <p>
     * 使用队列的数据结构来实现 First In First Out
     */
    public void levelOrder() {

        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {

            Node node = q.remove();
            System.out.println(node.e);

            if (node.left != null) {
                q.add(node.left);
            }

            if (node.right != null) {
                q.add(node.right);
            }

        }

    }

    public E min() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }

        return min(root).e;
    }

    /**
     * 沿着左侧一直寻找判断
     *
     * @param node
     * @return
     */
    private Node min(Node node) {

        if (node.left == null) {
            return node;
        }

        return min(node.left);
    }

    /**
     * 非递归 最小值
     *
     * @return
     */
    public E minNR() {
        return minNR(root).e;
    }

    private Node minNR(Node node) {

        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    public E max() {
        if (size == 0) {
            throw new IllegalArgumentException("bst is empty");
        }

        return max(root).e;

    }

    /**
     * 沿着右侧一直寻找判断
     *
     * @param node
     * @return
     */
    private Node max(Node node) {

        if (node.right == null) {
            return node;
        }

        return max((node.right));
    }

    /**
     * 非递归 最大值
     *
     * @return
     */
    public E maxNR() {
        return maxNR(root).e;
    }

    private Node maxNR(Node node) {
        while (node.right != null) {
            node = node.right;
        }

        return node;
    }

    /**
     * 左侧寻找 删除 如果有子节点 那么将其作为node节点父节点的左节点存储
     *
     * @return
     */
    public E removeMin() {
        E minNode = min();
        root = removeMin(root);
        return minNode;
    }

    private Node removeMin(Node node) {

        if (node.left == null) {
            Node nodeRight = node.right;
            node.right = null;
            size--;
            return nodeRight;
        }

        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax() {
        E max = max();
        root = removeMax(root);
        return max;
    }

    private Node removeMax(Node node) {

        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = removeMax(node.right);

        return node;
    }

    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {

        if (node == null) {
            return null;
        }

        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {
            //左子树为空
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            //右子树为空
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            //左右子树都不为空
            Node successor = min(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }

    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res) {

        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++)
            res.append("--");
        return res.toString();
    }


}
