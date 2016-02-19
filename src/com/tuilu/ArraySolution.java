package com.tuilu;

/**
 * Created by Administrator on 2016/2/18.
 */
public class ArraySolution {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length == 0){
            return nums;
        }

        int length = nums.length;
        int[] output = new int[length];

        // output acts as product from head to i - 1.
        output[0] = 1;
        for(int i = 1; i < length; i ++){
            output[i] = output[i - 1] * nums[i - 1];
        }

        // multiply by product from tail to i + 1.
        int productFromTail = 1;
        for(int i = length - 2; i >= 0; i --){
            productFromTail *= nums[i + 1];
            output[i] *= productFromTail;
        }

        return output;
    }
}
