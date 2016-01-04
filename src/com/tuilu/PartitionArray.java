package com.tuilu;

/**
 * Created by Administrator on 2015/12/30.
 */
public class PartitionArray {
    /**
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        int right = nums.length - 1;
        int left = 0;
        while(right-left>0){
            if(nums[left]%2==0&&nums[right]%2!=0){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
            if(nums[left]%2!=0)left++;
            if(nums[right]%2==0)right--;
        }
    }
}
