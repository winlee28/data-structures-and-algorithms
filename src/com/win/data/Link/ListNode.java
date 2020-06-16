package com.win.data.Link;

public class ListNode {

    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    /**
     * 根据数据创建一个链表
     *
     * @param arr
     */
    public ListNode(int[] arr) {

        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        ListNode cur = this;

        while (cur != null) {
            sb.append(cur.val + "->");
            cur = cur.next;
        }

        sb.append("NULL");
        return sb.toString();
    }
}
