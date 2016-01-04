package com.tuilu;

/**
 * Created by Administrator on 2015/12/29.
 */
public class CountOnes {
    /**
     * @param num: an integer
     * @return: an integer, the number of ones in num
     */
    public int countOnes(int num) {
        int count = 0;
        int flag = 1;

        while (flag>0) {
            if ((num & flag)!=0) {
                count++;
            }
            flag = flag << 1;
        }
        if(num<0)count++;// int flag为有符号int型。java没有unsigned修饰符
        return count;
    }
}
