package com.jiangzh.algorithm.primary.c6;

import com.jiangzh.algorithm.primary.c4.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/merge-k-sorted-lists
 */
public class Code01_MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        int listSize = lists.length;
        if (listSize == 1) {
            return lists[0];
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        // 获取最小值的头
        for (int i = 0; i < listSize; i++) {
            if (lists[i] != null) {
                queue.offer(lists[i]);
            }
        }

        if (queue.isEmpty()) {
            return null;
        }
        // 获取最小值的节点作为新链表的头
        ListNode head = queue.poll();
        if (head.next != null) {
            queue.offer(head.next);
        }

        ListNode tail = head;
        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;
            if (tail.next != null) {
                queue.offer(tail.next);
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = buildListNode1();
        ListNode l2 = buildListNode2();

//        ListNode[] lists = {l1, l2};
        ListNode[] lists = {null, null};

        Code01_MergeKLists merge = new Code01_MergeKLists();
        ListNode result = merge.mergeKLists(lists);
        printLinkNode(result);
    }

    public static void printLinkNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
        System.out.println("Print finished !!! ");
    }


    private static ListNode buildListNode1() {
        ListNode h1 = new ListNode(2);
        ListNode h2 = new ListNode(4);
        ListNode h3 = new ListNode(7);

        h1.next = h2;
        h2.next = h3;

        return h1;
    }

    private static ListNode buildListNode2() {
        ListNode h1 = new ListNode(5);
        ListNode h2 = new ListNode(6);
        ListNode h3 = new ListNode(8);
        ListNode h4 = new ListNode(9);
        ListNode h5 = new ListNode(13);

        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;

        return h1;
    }

}
