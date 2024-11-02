package com.algorithms.algo.solutions.medium;

public class MaximumProductSubarray {

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{0,2}));
    }

    public static int maxProduct(int[] nums){
        if(nums.length == 1) return nums[0];

        int largestProduct = Integer.MIN_VALUE, max = nums[0];

        for (int i = 0; i < nums.length - 1; i++) {
            if( max > largestProduct) largestProduct = max;
            if(max == 0) max = 1;
            max *= nums[i+1];
        }

        return Math.max(max, largestProduct);
    }

}
