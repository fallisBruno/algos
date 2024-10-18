package com.algorithms.algo.solutions.medium;

public class MaximumSubarray {

    public static void main(String[] args) {
        System.out.println(maxSumArray(new int[]{-2,-1}));
    }

    public static int maxSumArray(int[] nums){
        if(nums.length == 1) return nums[0];
        int sum = 0, index = 0, max = Integer.MIN_VALUE;
        while(index < nums.length){
            if(nums[index] > sum){
                sum = nums[index];
            }else{
                sum += nums[index];
            }

            if(sum > max) max = sum;
            index++;
        }
        return max;
    }

}
