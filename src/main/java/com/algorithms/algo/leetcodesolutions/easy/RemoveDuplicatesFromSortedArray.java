package com.algorithms.algo.leetcodesolutions.easy;

//Class name correspond to LeetCode, but I'm solving the problem here:
//https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/find-nonduplicate-number-instances-easy
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{2,3,3,3,6,9,9}));
    }

    public static int removeDuplicates(int[] nums){
        int left = 0, right = 1, count = 0;
        while (right < nums.length){
            if(nums[left] != nums[right]) {
                count++;
                right++; left++;
            }else{
                right++;
            }
        }
        return count;
    }

}
