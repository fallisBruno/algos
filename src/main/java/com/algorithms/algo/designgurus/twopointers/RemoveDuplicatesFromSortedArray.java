package com.algorithms.algo.designgurus.twopointers;

import java.util.Arrays;

//Class name correspond to LeetCode, but I'm solving the problem here:
//https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/find-nonduplicate-number-instances-easy
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(removeDuplicatesII(new int[]{1, 1, 2})));
    }

    public static int removeDuplicatesI(int[] nums){
        int left = 0, right = 1, count = 1;
        while (right < nums.length){
            if(nums[left] != nums[right]) {
                count++;
                right++;
                left = right - 1;
            }else{
                right++;
            }
        }
        return count;
    }

    //LEETCODE ATTEMPT, gonna go back here one day
    public static int[] removeDuplicatesII(int[] nums){
        int left = 0, right = 1;
        while (right < nums.length - 1){
            if(nums[left] == nums[right]) {
                nums[right] = nums[right+1];
                right++;
                left = right - 1;
            }else{
                right++;
            }
        }
        return nums;
    }

}
