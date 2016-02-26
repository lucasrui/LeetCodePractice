package com.tuilu;

/**
 * Created by Administrator on 2015/12/29.
 */
public class ListNodeSolution {

    /**
     * @param node: the node in the list should be deleted
     * @return: nothing
     */
    public void deleteNode(ListNode node) {
        if (node == null) return;
        if (node.next != null) {
            ListNode node2 = node.next;
            node.next = node2.next;
            node.val = node2.val;
        }
    }

    /**
     * @param head: The first node of linked list.
     * @param n:    An integer.
     * @return: The head of linked list.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) return null;
        ListNode node = head;
        ListNode tail = node;
        for (int i = 0; i < n + 1; i++) {
            if (tail == null) return head.next;
            tail = tail.next;
        }
        while (tail != null) {
            node = node.next;
            tail = tail.next;
        }
        node.next = node.next.next;
        return head;
    }

    /**
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        /*if(head==null||head.next==null)return head;
        ListNode n1 = head.next;
        head.next=null;
        ListNode n2=head;
        ListNode next=n1;
        while(next!=null){
            next=n1.next;
            n1.next=n2;
            n2=n1;
            n1=next;
        }
        return n2;*/

        /*if (null == head)
        {
            return head;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode next;
        while (null != cur)
        {
            next = cur.next;
            cur.next=pre;
            pre = cur;
            cur = next;
        }
        // 将原链表的头节点的下一个节点置为null，再将反转后的头节点赋给head
        head.next=null;
        head = pre;
        return head;*/

        if (null == head || null == head.next) {
            return head;
        }
        ListNode reversedHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return reversedHead;
    }

    /**
     * @param l1 is the head of the linked list
     * @param l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /*if(l1==null||l2.val<l1.val){
            ListNode node=l1;
            l1=l2;
            l2=node;
        }
        ListNode head = l1;
        while(l2!=null){
            if(l1.val<=l2.val){
                if(l1.next==null||l1.next.val>l2.val){
                    ListNode node = new ListNode(l2.val);
                    node.next=l1.next;
                    l2=l2.next;
                    l1.next=node;
                    l1=l1.next;
                }else {
                    l1=l1.next;
                }
            }
        }
        return head;*/
        if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;

        ListNode pMergedHead = null;

        if (l1.val < l2.val) {
            pMergedHead = l1;
            pMergedHead.next = mergeTwoLists(l1.next, l2);
        } else {
            pMergedHead = l2;
            pMergedHead.next = mergeTwoLists(l1, l2.next);
        }

        return pMergedHead;
    }

    public void outprint(ListNode list) {
        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode p1 = l1, p2 = l2, p = result;
        int carry = 0;
        while (p1 != null || p2 != null) {
            int add1 = p1 == null ? 0 : p1.val;
            int add2 = p2 == null ? 0 : p2.val;
            int sum = add1 + add2 + carry;
            p.next = new ListNode(sum % 10);
            carry = sum / 10;
            p = p.next;
            if (p1 != null) { p1 = p1.next; }
            if (p2 != null) { p2 = p2.next; }
        }
        if (carry == 1) { p.next = new ListNode(1); }
        return result.next;
    }
}

