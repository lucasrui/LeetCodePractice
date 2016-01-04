package com.tuilu;

/**
 * Created by Administrator on 2015/12/29.
 */
public class FindMin {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        int left = 0;
        int right = num.length;
        if(num[left]<num[right-1])return num[left];
        while (true) {
            if (right - left <= 1) {
                break;
            } else if (num[left] < num[(left + right) / 2]) {
                left = (left + right) / 2;
            } else {
                right = (left + right) / 2;
            }
        }
        return num[left]<num[right]?num[left]:num[right];
    }
}
