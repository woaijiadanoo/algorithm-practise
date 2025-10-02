package com.jiangzh.algorithm.primary.c4;

public class Q7_MergeTwoSortList {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }

        ListNode head = list1.val < list2.val ? list1 : list2;

        ListNode tempL1 = head.next;
        ListNode tempL2 = head == list1 ? list2 : list1;
        ListNode temp = head;
        while (tempL1 != null && tempL2 != null) {
            if (tempL1.val < tempL2.val) {
                temp.next = tempL1;
                tempL1 = tempL1.next;
            } else {
                temp.next = tempL2;
                tempL2 = tempL2.next;
            }
            temp = temp.next;
        }

        temp.next = tempL1 == null ? tempL2 : tempL1;

        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = buildListNode1();
        ListNode l2 = buildListNode2();

        Q7_MergeTwoSortList merge = new Q7_MergeTwoSortList();
        ListNode result = merge.mergeTwoLists(l1, l2);
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
