package com.algorithms.algo.solutions.medium;

public class MaximumSubarray {

    public static void main(String[] args) {
        System.out.println(maxSumArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    //
    //-2,1,-3,4,-1,2,1,-5,4
    public static int maxSumArray(int[] nums){
        if(nums.length == 1) return nums[0];
        int sum = nums[0], index = 1, max = nums[0];
        while(index < nums.length){
            if(nums[index] > sum && sum < 0){
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
