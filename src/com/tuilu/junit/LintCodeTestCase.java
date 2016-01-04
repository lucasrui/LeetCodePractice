package com.tuilu.junit;

import com.tuilu.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2015/12/29.
 */
public class LintCodeTestCase {
    @Test
    public void testFindMin() {
        FindMin fm = new FindMin();
        int[] num = {6, 1, 2, 3, 4, 5};
        assert (1 == fm.findMin(num));
    }

    @Test
    public void testBuildTree() {
        TreeNodeSolution bt = new TreeNodeSolution();
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode treeNode = bt.buildTree(preorder, inorder);
        assert (treeNode.val == 1);
    }

    @Test
    public void testQueue() {
        Queue queue = new Queue();
        queue.push(1);
        assert (queue.pop() == 1);
        queue.push(2);
        queue.push(3);
        assert (queue.top() == 2);
        assert (queue.pop() == 2);
    }

    @Test
    public void testSearchMatrix01() {
        int[][] matrix = {
                {1, 3, 5, 7},
                {2, 4, 7, 8},
                {3, 5, 9, 10}
        };
        MatrixSolution matrixSolution = new MatrixSolution();
        assert (matrixSolution.searchMatrix(matrix, 3) == 2);
    }

    @Test
    public void testSearchMatrix02() {
        int[][] matrix = {
                {1, 3, 5, 7},
                {2, 4, 7, 8},
                {3, 5, 9, 10},
                {5, 6, 10, 11},
        };
        MatrixSolution searchMatrix = new MatrixSolution();
        assert (searchMatrix.searchMatrix(matrix, 4) == 1);
    }

    @Test
    public void testPartitionArray() {
        PartitionArray partitionArray = new PartitionArray();
        int[] nums = {1, 2, 3, 4, 5};
        partitionArray.partitionArray(nums);
        for (int i : nums)
            System.out.println(i);
    }

    @Test
    public void testDeleteNode() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        ListNodeSolution listNodeSolution = new ListNodeSolution();
        listNodeSolution.deleteNode(node2);
        while (node1 != null) {
            System.out.println(node1.val);
            node1 = node1.next;
        }
    }

    @Test
    public void testReverseListNode() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        a.next = b;
        ListNode c = new ListNode(3);
        b.next = c;
        ListNode d = new ListNode(4);
        c.next = d;
        d.next = null;
        ListNodeSolution rl = new ListNodeSolution();
        rl.outprint(a);
        ListNode head = rl.reverse(a);
        rl.outprint(head);
    }

    @Test
    public void testFinMin() {
        FindMin fm = new FindMin();
        int[] num = {6, 1, 2, 3, 4, 5};
        assert (fm.findMin(num) == 1);
    }

    @Test
    public void testIsSubTree() {
        TreeNodeSolution treeNodeSolution = new TreeNodeSolution();
        TreeNode T1 = new TreeNode(1);
        TreeNode T2 = new TreeNode(2);
        TreeNode T3 = new TreeNode(3);
        TreeNode T4 = new TreeNode(4);
        TreeNode T5 = new TreeNode(5);
        T1.left = T2;
        T1.right = T3;
        T3.left = T4;
        T3.right = T5;

        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        assert (treeNodeSolution.isEqual(T3, t1));
        assert (treeNodeSolution.isSubtree(T1, t1));
    }

    @Test
    public void testRemoveNthFromEnd() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        a.next = b;
        ListNode c = new ListNode(3);
        b.next = c;
        ListNode d = new ListNode(4);
        c.next = d;
        d.next = null;
        ListNodeSolution rl = new ListNodeSolution();
        rl.outprint(a);
        ListNode head = rl.removeNthFromEnd(a, 1);
        rl.outprint(head);
    }

    @Test
    public void testMergeListNode() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(3);
        a.next = b;
        ListNode c = new ListNode(5);
        b.next = c;
        ListNode d = new ListNode(7);
        c.next = d;
        d.next = null;

        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        l1.next = l2;
        ListNode l3 = new ListNode(6);
        l2.next = l3;
        ListNode l4 = new ListNode(8);
        l3.next = l4;
        l4.next = null;

        ListNodeSolution rl = new ListNodeSolution();
        rl.outprint(a);
        ListNode head = rl.mergeTwoLists(a, l1);
        rl.outprint(head);
    }

    @Test
    public void testNumbersByRecursion() {
        Recursion recursion = new Recursion();
        List<Integer> list = recursion.numbersByRecursion(3);
        System.out.println(list.size());
    }

    @Test
    public void testFastPower() {
        DivideConquer divideConquer = new DivideConquer();
        assert (divideConquer.fastPower(109, 10000007, 1000001) == 5249911);
    }

    @Test
    public void testTreePathSum() {
        TreeNodeSolution treeNodeSolution = new TreeNodeSolution();
        TreeNode T1 = new TreeNode(1);
        TreeNode T2 = new TreeNode(2);
        TreeNode T3 = new TreeNode(2);
        TreeNode T4 = new TreeNode(3);
        TreeNode T5 = new TreeNode(4);
        T1.left = T2;
        T2.left = T3;
        T2.right = T4;
        T1.right = T5;
        List list = treeNodeSolution.binaryTreePathSum(T1, 5);
        System.out.println(list);
    }

    @Test
    public void testReplaceBlank() {
        StringSolution rb = new StringSolution();
        String str = " Mr John  Smith";
        char[] arr = str.toCharArray();
        char[] arr2 = Arrays.copyOf(arr, arr.length * 3);
        assert (23 == rb.replaceBlank(arr2, arr.length));
        System.out.println(new String(arr2).trim().equals("%20Mr%20John%20%20Smith"));
    }

    @Test
    public void testStringPermutation() {
        StringSolution stringSolution = new StringSolution();
        assert (stringSolution.stringPermutation("", ""));
    }

    @Test
    public void testPostorder() {
        TreeNodeSolution treeNodeSolution = new TreeNodeSolution();
        TreeNode T1 = new TreeNode(1);
        TreeNode T2 = new TreeNode(2);
        TreeNode T3 = new TreeNode(2);
        TreeNode T4 = new TreeNode(3);
        TreeNode T5 = new TreeNode(4);
        T1.left = T2;
        T2.left = T3;
        T2.right = T4;
        T1.right = T5;
        List list = treeNodeSolution.postorderTraversal(T1);
        System.out.println(list);
    }

    @Test
    public void testPostorderNotRecursion() {
        TreeNodeSolution treeNodeSolution = new TreeNodeSolution();
        TreeNode T1 = new TreeNode(1);
        TreeNode T2 = new TreeNode(2);
        TreeNode T3 = new TreeNode(2);
        TreeNode T4 = new TreeNode(3);
        TreeNode T5 = new TreeNode(4);
        T1.left = T2;
        T2.left = T3;
        T2.right = T4;
        T1.right = T5;
        List list = treeNodeSolution.postorderTraversalNotRecursion(T1);
        System.out.println(list);
    }

    @Test
    public void testBstToDoublyList() {
        TreeNodeSolution treeNodeSolution = new TreeNodeSolution();
        TreeNode T1 = new TreeNode(1);
        TreeNode T2 = new TreeNode(2);
        TreeNode T3 = new TreeNode(2);
        TreeNode T4 = new TreeNode(3);
        TreeNode T5 = new TreeNode(4);
        T1.left = T2;
        T2.left = T3;
        T2.right = T4;
        T1.right = T5;
        DoublyListNode dNode = treeNodeSolution.bstToDoublyList(T1);
        System.out.println(dNode);
    }
    @Test
    public void  testSpiralOrder(){
        MatrixSolution matrixSolution = new MatrixSolution();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
//        int[][] matrix = {{10}};
        System.out.println(matrixSolution.spiralOrder(matrix));
    }
}
