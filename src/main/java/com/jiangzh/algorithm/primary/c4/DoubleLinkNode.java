package com.jiangzh.algorithm.primary.c4;

public class DoubleLinkNode extends LinkNode {

    private LinkNode prev;

    public DoubleLinkNode(int val) {
        super(val);
    }

    public DoubleLinkNode(int val, LinkNode prev, LinkNode next) {
        super(val, next);
        this.prev = prev;
    }

    public LinkNode getPrev() {
        return prev;
    }

    public void setPrev(LinkNode prev) {
        this.prev = prev;
    }
}
