package com.jiangzh.algorithm.primary.c4;

public class Q1_Q2_LinkedReversal {

    private static LinkNode singleLinkReversal(LinkNode head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        LinkNode prev = null;
        LinkNode next = null;

        while (head != null) {
            next = head.getNext();
            head.setNext(prev);
            prev = head;
            head = next;
        }

        return prev;
    }

    public static DoubleLinkNode doubleLinkReversal(DoubleLinkNode head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        DoubleLinkNode prev = null;
        DoubleLinkNode next = null;

        while (head != null) {
            next = (DoubleLinkNode) head.getNext();

            head.setNext(prev);
            head.setPrev(next);

            prev = head;
            head = next;
        }

        return prev;
    }


    public static void main(String[] args) {
        // 构建单链表
        LinkNode head = buildLinkNode();
        printLinkNode(head);
        System.out.println("================ 这是一条分割线 =========================");
        // 单链表翻转
        LinkNode singleLinkReversal = singleLinkReversal(head);
        printLinkNode(singleLinkReversal);
        System.out.println("================ 这是一条分割线 =========================");
        // 构建双链表
        DoubleLinkNode head2 = buildDoubleLinkNode();
        DoubleLinkNode doubleLinkNode = doubleLinkReversal(head2);
        printLinkNode(doubleLinkNode);

    }

    public static void printLinkNode(LinkNode head) {
        while (head != null) {
            System.out.print(head.getVal() + " ");
            head = head.getNext();
        }
        System.out.println();
        System.out.println("Print finished !!! ");
    }

    private static LinkNode buildLinkNode() {
        LinkNode h1 = new LinkNode(1);
        LinkNode h2 = new LinkNode(2);
        LinkNode h3 = new LinkNode(3);
        LinkNode h4 = new LinkNode(4);
        LinkNode h5 = new LinkNode(5);
        LinkNode h6 = new LinkNode(6);
        LinkNode h7 = new LinkNode(7);
        LinkNode h8 = new LinkNode(8);
        LinkNode h9 = new LinkNode(9);
        LinkNode h10 = new LinkNode(10);

        h1.setNext(h2);
        h2.setNext(h3);
        h3.setNext(h4);
        h4.setNext(h5);
        h5.setNext(h6);
        h6.setNext(h7);
        h7.setNext(h8);
        h8.setNext(h9);
        h9.setNext(h10);

        return h1;
    }

    private static DoubleLinkNode buildDoubleLinkNode() {
        DoubleLinkNode h1 = new DoubleLinkNode(1);
        DoubleLinkNode h2 = new DoubleLinkNode(2);
        DoubleLinkNode h3 = new DoubleLinkNode(3);
        DoubleLinkNode h4 = new DoubleLinkNode(4);
        DoubleLinkNode h5 = new DoubleLinkNode(5);
        DoubleLinkNode h6 = new DoubleLinkNode(6);
        DoubleLinkNode h7 = new DoubleLinkNode(7);
        DoubleLinkNode h8 = new DoubleLinkNode(8);
        DoubleLinkNode h9 = new DoubleLinkNode(9);
        DoubleLinkNode h10 = new DoubleLinkNode(10);

        h2.setPrev(h1);
        h3.setPrev(h2);
        h4.setPrev(h3);
        h5.setPrev(h4);
        h6.setPrev(h5);
        h7.setPrev(h6);
        h8.setPrev(h7);
        h9.setPrev(h8);
        h10.setPrev(h9);

        h1.setNext(h2);
        h2.setNext(h3);
        h3.setNext(h4);
        h4.setNext(h5);
        h5.setNext(h6);
        h6.setNext(h7);
        h7.setNext(h8);
        h8.setNext(h9);
        h9.setNext(h10);
        return h1;
    }

}
