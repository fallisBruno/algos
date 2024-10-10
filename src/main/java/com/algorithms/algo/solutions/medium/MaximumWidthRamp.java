package com.algorithms.algo.solutions.medium;

public class MaximumWidthRamp {

    public static void main(String[] args) {
        System.out.println(findRamp(new int[]{6,0,8,2,1,5}));
    }

    public static int findRamp(int[] nums){
        int left = nums.length / 2;
        int right = nums.length / 2;
        int maxWidth = 0;
        while(left > 0 || right < nums.length){
            while(left > 0 && nums[left] <= nums[right]){
                maxWidth = right - left;
                System.out.println("comparing left: " + nums[left] + " - " + nums[right]);
                if(nums[left] < nums[left-1]) break;
                left--;
            }
            while(right < nums.length - 1 && nums[right] >= nums[left]){
                maxWidth = right - left;
                right++;
                System.out.println("comparing right: " + nums[left] + " - " + nums[right]);
            }
            if(left <= 0) right++;
            else left--;
        }
        return maxWidth;
    }

}
