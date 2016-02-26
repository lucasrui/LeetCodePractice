package com.tuilu.junit;

import com.tuilu.ArraySolution;
import com.tuilu.ListNode;
import com.tuilu.ListNodeSolution;
import com.tuilu.StringSolution;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2016/1/4.
 */
public class LeetCodeTestCase {
    @Test
    public void testFindLadders() {
        Set<String> set = new HashSet<>(Arrays.asList("hot", "dot", "dog", "lot", "log"));
        StringSolution stringSolution = new StringSolution();
        stringSolution.findLadders("hit", "cog", set);
    }

    @Test
    public void testIsValid() {
        StringSolution stringSolution = new StringSolution();
        assert (true == stringSolution.isValid("({[]})"));
        assert (false == stringSolution.isValid("["));
    }

    @Test
    public void testIsPalidrome() {
        StringSolution stringSolution = new StringSolution();
        assert (true == stringSolution.isPalidrome("A man, a plan, a canal: Panama"));
        assert (false == stringSolution.isPalidrome("race a car"));
    }

    @Test
    public void testProductExceptSelf() {
        ArraySolution solution = new ArraySolution();
        int[] nums = {1, 2, 3, 4};
        int[] result = solution.productExceptSelf(nums);
        System.out.println(result);
    }

    @Test
    public void testIsIsomorphic() {
        StringSolution solution = new StringSolution();
        assert (true == solution.isIsomorphic("bcc", "ess"));
    }

    @Test
    public void testAddTwoNumber() {
        ListNodeSolution solution = new ListNodeSolution();
        ListNode l1 = new ListNode(0);
        ListNode l12 = new ListNode(2);
//        l1.next = l12;
        ListNode l2 = new ListNode(0);
        ListNode l22 = new ListNode(3);
//        l2.next = l22;
        ListNode node = solution.addTwoNumbers(l1, l2);
        while(node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
