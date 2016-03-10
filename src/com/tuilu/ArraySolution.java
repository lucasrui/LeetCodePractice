package com.tuilu;

/**
 * Created by Administrator on 2016/2/18.
 */
public class ArraySolution {
    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }

        int length = nums.length;
        int[] output = new int[length];

        // output acts as product from head to i - 1.
        output[0] = 1;
        for (int i = 1; i < length; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }

        // multiply by product from tail to i + 1.
        int productFromTail = 1;
        for (int i = length - 2; i >= 0; i--) {
            productFromTail *= nums[i + 1];
            output[i] *= productFromTail;
        }

        return output;
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = {1, 2};

        return result;
    }

    /*There are N children standing in a line. Each child is assigned a rating value.

    You are giving candies to these children subjected to the following requirements:

    Each child must have at least one candy.
    Children with a higher rating get more candies than their neighbors.
    What is the minimum candies you must give?*/
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] candies = new int[len];
        int count = 1;
        for (int i = 0; i < len; i++) {
            if (i == len - 1 || ratings[i + 1] > ratings[i]) {
                if (count == 1 && i > 0) {
                    candies[i] = candies[i - 1] + 1;
                } else {
                    int candy = 1;
                    candies[i] = candy;
                    for (int j = 1; j < count; j++) {
                        if (ratings[i - j + 1] < ratings[i - j]) {
                            candies[i - j] = ++candy;
                        } else {
                            candies[i - j] = candy;
                            if (i - j == 0) {
                                candies[i - j] = 1;
                            } else if (ratings[i - j - 1] == ratings[i - j + 1]) {
                                candies[i - j] = 1;
                                candy = 1;
                            }
                        }
                        if (i > j && j == count - 1 && (candies[i - j - 1] >= candies[i - j] || ratings[i - j] == ratings[i - j + 1]))
                            candies[i - j] = candies[i - j - 1] + 1;
                    }
                }
                count = 0;
            }
            count++;
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += candies[i];
        }
        return sum;
    }
}
