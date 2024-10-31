package com.algorithms.algo.solutions.medium;

public class MaximumProductSubarray {

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{-2,0,-1}));
    }

    public static int maxProduct(int[] nums){
        if(nums.length == 1) return nums[0];

        int largestProduct = Integer.MIN_VALUE, max = nums[0];

        for (int i = 0; i < nums.length - 1; i++) {
            while(max > largestProduct){
                largestProduct = max;
                max *= nums[i+1];
            }
            if()
        }

        return largestProduct;
    }

}
