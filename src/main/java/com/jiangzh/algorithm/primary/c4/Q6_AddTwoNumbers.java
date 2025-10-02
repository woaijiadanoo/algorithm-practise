package com.jiangzh.algorithm.primary.c4;

public class Q6_AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        int l1Depth = getListNodeDepth(l1);
        int l2Depth = getListNodeDepth(l2);

        ListNode longList = l1Depth >= l2Depth ? l1 : l2;
        ListNode shortList = longList == l1 ? l2 : l1;

        ListNode currentLong = longList;
        ListNode currentShort = shortList;
        ListNode lastNode = null;

        int carry = 0;
        int tempVal = 0;
        // 如果两个链表都有值
        while (currentShort != null) {
            tempVal = currentLong.val + currentShort.val + carry;
            // 是否要进位
            carry = tempVal / 10;
            // 进位后当前的值
            currentLong.val = tempVal % 10;
            lastNode = currentLong;
            // 同时移到下一个节点
            currentLong = currentLong.next;
            currentShort = currentShort.next;
        }

        // 短链表结束
        while (currentLong != null) {
            tempVal = currentLong.val + carry;
            carry = tempVal / 10;
            currentLong.val = tempVal % 10;

            lastNode = currentLong;
            currentLong = currentLong.next;
        }

        // 如果长链表都结束了，但是进位还有
        if (carry > 0) {
            lastNode.next = new ListNode(carry);
        }

        return longList;
    }

    public int getListNodeDepth(ListNode head) {
        int i = 0;
        while (head != null) {
            head = head.next;
            i++;
        }

        return i;
    }

    public static void main(String[] args) {
        ListNode l1 = buildListNode1();
        ListNode l2 = buildListNode2();

        Q6_AddTwoNumbers q = new Q6_AddTwoNumbers();
        ListNode head = q.addTwoNumbers(l1, l2);
        printLinkNode(head);
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
        ListNode h3 = new ListNode(3);

        h1.next = h2;
        h2.next = h3;

        return h1;
    }

    private static ListNode buildListNode2() {
        ListNode h1 = new ListNode(5);
        ListNode h2 = new ListNode(6);
        ListNode h3 = new ListNode(8);
        ListNode h4 = new ListNode(9);
        ListNode h5 = new ListNode(9);

        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;

        return h1;
    }

}
