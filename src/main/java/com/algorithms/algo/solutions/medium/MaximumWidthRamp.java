package com.algorithms.algo.solutions.medium;

public class MaximumWidthRamp {

    public static void main(String[] args) {
        System.out.println(findRampIII(new int[]{3,2,4,1}));
    }

    public static int findRampIII(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            if(nums[left] <= nums[right]){
                return right - left;
            }
            if(nums[left] > nums[left + 1])
                left++;
            else
                right--;
        }
        return left - right;
    }

    public static int findRampII(int[] nums){
        int maxWidth = 0;
        int left = 0;
        int right = 1;
        while(left < nums.length){
            if(right < nums.length - 1){
                while(right < nums.length - 1 && nums[left] > nums[right]){
                    right++;
                }
            }else{
                while(right >= 0  && nums[left] > nums[right]){
                    right--;
                }
            }
            if(nums[left] <= nums[right] && left != right){
                maxWidth = right - left;
                if(right == nums.length - 1 || left > 0) break;
            }
            if(right < nums.length - 1) right++;
            else left++;
        }
        return maxWidth;
    }

    public static int findRamp(int[] nums){
        int maxWidth = 0;
        int left = nums.length / 2;
        int right = nums.length / 2;
        while(left >= 0 || right < nums.length){
            while(left >= 0 &&  nums[left] <= nums[right]){
                maxWidth = right - left;
                System.out.println("comparing left: " + nums[left] + " - " + nums[right]);
                if(left <= 0 || nums[left] < nums[left-1]) break;
                left--;
            }
            while(right < nums.length - 1 && nums[right] >= nums[left]){
                System.out.println("comparing right: " + nums[left] + " - " + nums[right]);
                maxWidth = right - left;
                right++;
            }
            if(left <= 0 && right >= nums.length - 1) break;
            else if(left <= 0) right++;
            else left--;
        }
        return maxWidth;
    }

}
