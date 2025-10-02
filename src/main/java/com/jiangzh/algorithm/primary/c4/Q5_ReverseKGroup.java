package com.jiangzh.algorithm.primary.c4;

public class Q5_ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) {
            return head;
        }
        // 确定第一次的头和尾
        ListNode result = findEndNode(head, k);
        if (result == null) {
            return head;
        }
        ListNode lastEnd = head;
        reverseListNode(lastEnd, result);

        ListNode start = null;
        ListNode end = null;
        while (lastEnd.next != null) {
            start = lastEnd.next;
            end = findEndNode(start, k);
            if (end == null) {
                break;
            }
            reverseListNode(start, end);
            lastEnd.next = end;
            lastEnd = start;
        }

        return result;
    }

    public ListNode findEndNode(ListNode startNode, int k) {
        while (--k > 0 && startNode != null) {
            startNode = startNode.next;
        }
        return startNode;
    }

    public ListNode reverseListNode(ListNode startNode, ListNode endNode) {
        endNode = endNode.next;

        ListNode pre = null;
        ListNode cur = startNode;
        ListNode next = null;
        while (cur != endNode) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        startNode.next = endNode;

        return cur;
    }

    public static void main(String[] args) {
        ListNode head = buildListNode();

        Q5_ReverseKGroup group = new Q5_ReverseKGroup();
        ListNode result = group.reverseKGroup(head, 4);
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

    private static ListNode buildListNode() {
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        ListNode h4 = new ListNode(4);
        ListNode h5 = new ListNode(5);
        ListNode h6 = new ListNode(6);
        ListNode h7 = new ListNode(7);
        ListNode h8 = new ListNode(8);
        ListNode h9 = new ListNode(9);
        ListNode h10 = new ListNode(10);

        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
        h5.next = h6;
        h6.next = h7;
        h7.next = h8;
        h8.next = h9;
        h9.next = h10;

        return h1;
    }
    
}
