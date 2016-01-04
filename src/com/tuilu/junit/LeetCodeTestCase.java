package com.tuilu.junit;

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
    public void testFindLadders(){
        Set<String> set = new HashSet<>(Arrays.asList("hot","dot","dog","lot","log"));
        StringSolution stringSolution = new StringSolution();
        stringSolution.findLadders("hit","cog",set);
    }
    @Test
    public void testIsValid(){
        StringSolution stringSolution = new StringSolution();
        assert (true==stringSolution.isValid("({[]})"));
        assert (false==stringSolution.isValid("["));
    }
    @Test
    public void testIsPalidrome(){
        StringSolution stringSolution = new StringSolution();
        assert(true == stringSolution.isPalidrome("A man, a plan, a canal: Panama"));
        assert(false == stringSolution.isPalidrome("race a car"));
    }
}
