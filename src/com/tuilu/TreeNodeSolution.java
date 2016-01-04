package com.tuilu;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Administrator on 2015/12/30.
 */
public class TreeNodeSolution {


    /**
     * @param T1, T2: The roots of binary tree.
     * @return True if T2 is a subtree of T1, or false.
     */
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        return isEqual(T1, T2) || T1 != null && (isSubtree(T1.left, T2) || isSubtree(T1.right, T2));
    }

    /**
     * @param T1,T2: The roots of binary tree.
     * @return True if T2 is a equal to T1, or false.
     */
    public boolean isEqual(TreeNode T1, TreeNode T2) {
        return T1 == null && T2 == null || T1 != null && T2 != null && T1.val == T2.val && isEqual(T1.left, T2.left) && isEqual(T1.right, T2.right);
    }

    /**
     * @param preorder : A list of integers that preorder traversal of a tree
     * @param inorder  : A list of integers that inorder traversal of a tree
     * @return Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || preorder.length != inorder.length) return null;
        int length = preorder.length;
        TreeNode root = new TreeNode(preorder[0]);
        if (length == 1) return root;
        int i = 0;
        while (i < length) {
            if (root.val == inorder[i]) {
                break;
            }
            i++;
        }
        int[] preorder2 = new int[i];
        System.arraycopy(preorder, 1, preorder2, 0, i);
        int[] inorder2 = new int[i];
        System.arraycopy(inorder, 0, inorder2, 0, i);

        int[] preorder3 = new int[length - i - 1];
        System.arraycopy(preorder, i + 1, preorder3, 0, length - i - 1);
        int[] inorder3 = new int[length - i - 1];
        System.arraycopy(inorder, i + 1, inorder3, 0, length - i - 1);

        root.left = buildTree(preorder2, inorder2);
        root.right = buildTree(preorder3, inorder3);
        return root;
    }

    /**
     * @param root   the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        } else if (root.val == target) {
            if (root.left == null && root.right == null) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(root.val);
                result.add(list);
            }
        } else {
            List<List<Integer>> leftList = binaryTreePathSum(root.left, target - root.val);
            if (leftList != null) {
                for (List<Integer> l : leftList) {
                    l.add(0, root.val);
                    result.add(l);
                }
            }
            List<List<Integer>> rightList = binaryTreePathSum(root.right, target - root.val);
            if (rightList != null) {
                for (List<Integer> l : rightList) {
                    l.add(0, root.val);
                    result.add(l);
                }
            }
        }
        return result;
    }

    /**
     * @param root: The root of binary tree.
     * @return Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        ArrayList<Integer> leftList = postorderTraversal(root.left);
        ArrayList<Integer> rightList = postorderTraversal(root.right);
        leftList.addAll(rightList);
        leftList.add(root.val);
        return leftList;
    }

    /**
     * @param root: The root of binary tree.
     * @return Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversalNotRecursion(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) stack.push(root);
        while (!stack.empty()) {
            if (stack.peek().left != null) {
                stack.push(stack.peek().left);
            } else if (stack.peek().right != null) {
                stack.push(stack.peek().right);
            } else {
                list.add(stack.pop().val);
                if (!stack.empty()) {
                    if (stack.peek().left != null) {
                        stack.peek().left = null;
                    } else {
                        stack.peek().right = null;
                    }
                }
            }
        }
        return list;
    }

    /**
     * @param root: The root of tree
     * @return the head of doubly list node
     */
    public DoublyListNode bstToDoublyList(TreeNode root) {
        if(root==null)return null;
        DoublyListNode head = null;
        DoublyListNode node = null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            if (stack.peek().left != null) {
                stack.push(stack.peek().left);
            }else {
                TreeNode treeNode = stack.pop();
                DoublyListNode temp = new DoublyListNode(treeNode.val);
                if(head==null) {
                    head=temp;
                    node=head;
                }else{
                    temp.prev=node;
                    node.next=temp;
                    node=node.next;
                }
                if(!stack.empty())stack.peek().left=null;
                if(treeNode.right!=null)stack.push(treeNode.right);
            }
        }
        return head;
    }
}
