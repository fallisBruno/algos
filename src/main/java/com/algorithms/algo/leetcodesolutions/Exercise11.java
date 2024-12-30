package com.algorithms.algo.leetcodesolutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Exercise11 {

    public static void main(String[] args) {
        System.out.println(findMissingNumberIV(new int[]{9,6,4,2,3,5,7,0,1}));
        //System.out.println(findMissingNumberII(new int[]{9,6,4,2,3,5,7,0,1}));
    }

    //ChatGPT solution
    //but I'm proud of myself after solution I, II and III :)
    public static int findMissingNumberIV(int[] nums){
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;  // Sum of numbers from 0 to n
        int actualSum = 0;

        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }

    public static int findMissingNumberIII(int[] nums){
        if(nums.length == 1 && nums[0] > 0) return 0;

        boolean[] auxArr = new boolean[nums.length + 1];

        for (int num : nums) {
            auxArr[num] = true;
        }

        for (int i = 0; i < auxArr.length; i++) {
            if(!auxArr[i]) return i;
        }

        return nums[nums.length - 1] + 1;
    }

    public static int findMissingNumberII(int[] nums){
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if(i != nums[i]) return i;
        }

        return nums[nums.length - 1] + 1;
    }

    public static int findMissingNumberI(int[] nums){
        Arrays.sort(nums);

        int max = -1;
        Set<Integer> controlSet = new HashSet<>();
        for (int num : nums) {
            if (max < num) max = num;
            controlSet.add(num);
        }

        for (int i = 0; i < max; i++) {
            if(!controlSet.contains(i)){
                return i;
            }
        }

        return nums[nums.length - 1] + 1;
    }

}
