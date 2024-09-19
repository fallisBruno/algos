package com.algorithms.algo.solutions;

import java.util.Arrays;

public class Exercise7 {

    public static void main(String[] args) {
        int[] returnedArr = rotateArray(new int[]{-1, -100, 3, 99}, 2);
        System.out.println(Arrays.toString(returnedArr));

        rotateArrayGPT(new int[]{-1, -100, 3, 99}, 2);
    }

    //I like my solution, even though I didn't have a space complexity O(1)
    //but I ran some tests on leetcode and it was faster and consumed less memory :)
    public static int[] rotateArray(int[] nums, int k){
        int length = nums.length;
        if(length <= 1) return nums;
        int[] result = new int[length];
        k = k % length;
        int j = 0;
        for (int i = length - k; i < length; i++) {
            result[j++] = nums[i];
        }
        for (int i = 0; i < length - k; i++) {
            result[j++] = nums[i];
        }
        return result;
    }

    /*ChatGPT solution, you can also find it on leetcode.com*/
    public static void rotateArrayGPT(int[] nums, int k) {
        k = k % nums.length;  // Reduce k if it's larger than nums.length

        // Step 1: Reverse the entire array
        reverse(nums, 0, nums.length - 1);

        // Step 2: Reverse the first k elements
        reverse(nums, 0, k - 1);

        // Step 3: Reverse the remaining elements
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
