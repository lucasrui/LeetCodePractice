package com.tuilu;

import java.util.*;

/**
 * Created by Administrator on 2015/12/29.
 */
public class StringSolution {

    /**
     * @param A a string
     * @param B a string
     * @return a boolean
     */
    public boolean stringPermutation(String A, String B) {
        // Write your code here
        if (A.length() != B.length()) return false;
        char[] arrayA = A.toCharArray();
        char[] arrayB = B.toCharArray();
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        return Arrays.equals(arrayA, arrayB);
    }

    /**
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public int replaceBlank(char[] string, int length) {
        /*for (int i = 0; i < length; i++) {
            if (string[i] == ' ') {
                length += 2;
                for(int j=length-1;j>i+2;j--){
                    string[j]=string[j-2];
                }
                string[i] = '%';
                string[i+1] = '2';
                string[i+2] = '0';
            }
        }
        return length;*/
        int newLength = length;
        for (int i = 0; i < length; i++) {
            if (string[i] == ' ') newLength += 2;
        }
        for (int j = length - 1, k = newLength - 1; j >= 0; j--) {
            if (string[j] != ' ') {
                string[k] = string[j];
                k--;
            } else {
                string[k] = '0';
                k--;
                string[k] = '2';
                k--;
                string[k] = '%';
                k--;
            }
        }
        return newLength;
    }

    // string,dfs,bfs
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<String> existList = new ArrayList<>();
        List<String> tempList = new ArrayList<>();
        List<List<String>> resultList = new ArrayList<>();
        tempList.add(beginWord);
        Iterator it = wordList.iterator();
        while (it.hasNext()) {
            String a = (String) it.next();
            System.out.println(a);
        }

        return null;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.empty() && isMatch(stack.peek(), s.charAt(i))) stack.pop();
            else stack.push(s.charAt(i));
        }
        return stack.empty();
    }

    public boolean isMatch(char a, char b) {
        return (a == '(' && b == ')') || (a == '[' && b == ']') || (a == '{' && b == '}');
    }

    public boolean isPalidrome(String s) {
        String s2 = s.replaceAll("[^\\p{Alnum}]", "").toLowerCase();
        return new StringBuilder(s2).reverse().toString().equals(s2);
    }

    public boolean isIsomorphic(String s, String t) {
        Map m = new HashMap();
        for (Integer i = 0; i < s.length(); ++i)
            if (m.put(s.charAt(i), i) != m.put(t.charAt(i) + "", i))
                return false;
        return true;
    }

    public String minWindow(String s, String t) {
        return "";
    }

    public boolean isInterleave(String s1, String s2, String s3) {

        return false;
    }

    /*
    Additive number is a string whose digits can form additive sequence.
    A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.*/
    public boolean isAdditiveNumber(String num) {
        int[] nums = new int[num.length()];
        for (int i = 0; i < num.length(); i++) {
            nums[i] = num.charAt(i) - 48;
        }
        int alength = 1;
        int blength = 1;
        int tag;
        while (alength * 2 < num.length()) {
            if (nums[0] == 0 && alength > 1) return false;
            if (nums[alength] == 0 && blength > 1) {
                alength++;
                continue;
            }
            tag = alength + blength;
            long a = 0;
            long b = 0;
            for (int i = 0; i < alength; i++) {
                a = a * 10 + nums[i];
            }
            for (int i = 0; i < blength; i++) {
                b = b * 10 + nums[i + alength];
            }
            int clength = 1;
            while (tag + clength - 1 < num.length()) {
                if (nums[tag] == 0 && clength > 1) {
                    break;
                }
                long c = 0;
                for (int i = 0; i < clength; i++) {
                    c = c * 10 + nums[i + tag];
                }
                if (a + b > c) {
                    clength++;
                } else if (a + b == c) {
                    a = b;
                    b = c;
                    tag += clength;
                    clength = 1;
                    if (tag == num.length()) return true;
                } else {
                    break;
                }
            }
            blength++;
            if (blength * 2 > num.length() || alength + blength == num.length()) {
                blength = 1;
                alength++;
            }
        }
        return false;
    }
}
