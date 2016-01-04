package com.tuilu;

/**
 * Created by Administrator on 2015/12/31.
 */
public class DoublyListNode {
    public int val;
    public DoublyListNode next, prev;

    public DoublyListNode(int val) {
        this.val = val;
        this.next = this.prev = null;
    }
}
