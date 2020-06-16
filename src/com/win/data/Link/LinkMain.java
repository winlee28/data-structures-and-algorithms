package com.win.data.Link;

import java.util.List;

public class LinkMain {


    public static void main(String[] args) {

        int[] res = new int[]{1, 2, 3, 6, 4, 5, 6};

        ListNode head = new ListNode(res);
        System.out.println(head.toString());

        ListNode listNode = reverseString(head);
        System.out.println(listNode.toString());

//        ListNode listNode1 = removeElement2(head, 6);
//        System.out.println(listNode1);

    }


    /**
     * 反转链表
     * 定义两个指针 ，通过指针移动完成反转
     *
     * @param head
     * @return
     */
    public static ListNode reverseString(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {

            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    /**
     * 针对头结点进行特殊处理
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElement(ListNode head, int val) {

        while (head != null && head.val == val) {
            head = head.next;
        }

        if (head == null) {
            return null;
        }

        ListNode pre = head;
        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }

        return head;

    }


    /**
     * 采用虚拟头节点方式，这样就每个节点都有head了 可以直接next
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElement2(ListNode head, int val) {

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode pre = dummyHead;
        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }

        return dummyHead.next;
    }
}
