package com.tuilu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/12/30.
 */
public class Recursion {
    /**
     * @param n: An integer.
     * return : An array storing 1 to the largest number with n digits.
     */
    public List<Integer> numbersByRecursion(int n) {
        if(n<=0)return new ArrayList<>();
        if(n==1){
            List<Integer> list = new ArrayList<>();
            for(int i=1;i<10;i++){
                list.add(i);
            }
            return list;
        }
        List<Integer> list=numbersByRecursion(n-1);
        List<Integer> templist=new ArrayList<>(list);
        for(int i=1;i<10;i++){
            int temp = (int) (i*Math.pow(10,n-1));
            list.add(temp);
            for(int x:templist){
                list.add(x+temp);
            }
        }
        return  list;
    }
}
