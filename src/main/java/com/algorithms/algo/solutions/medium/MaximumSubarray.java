package com.algorithms.algo.solutions.medium;

public class MaximumSubarray {

    public static void main(String[] args) {
        System.out.println(maxSumArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    public static int maxSumArray(int[] nums){
        if(nums.length == 1) return nums[0];
        int sum = 0, index = 0, max = 0;
        while(index < nums.length){
            if(sum + nums[index] > 0){
                sum += nums[index];
            }else{
                sum = 0;
            }

            if(sum > max) max = sum;
            index++;
        }
        return max;
    }

}
