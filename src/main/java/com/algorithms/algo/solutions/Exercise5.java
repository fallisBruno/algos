package com.algorithms.algo.solutions;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Exercise5 {

    public static void main(String[] args) {
        System.out.println(findMajorityII(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    public static int findMajorityII(int[] nums){
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (int currentNumber : nums) {
            resultMap.put(currentNumber, resultMap.getOrDefault(currentNumber, 0) + 1);
            if (resultMap.get(currentNumber) > nums.length / 2)
                return currentNumber;
        }
        return -1;
    }

    //does not solve if you have negative numbers in the arr input
    public static int findMajority(int[] arr){
        int max = Arrays.stream(arr).max().getAsInt();
        int [] sumArr = new int[max+1];
        for (int j : arr) {
            sumArr[j]++;
            if (sumArr[j] > (arr.length / 2)) {
                return j;
            }
        }

        return -1;
    }

    //ChatGPT solution
    //it's really fast, but consumes more memory than my findMajorityII
    //search for Boyer-Moore Voting Algorithm (that's awesome)
    public static int findMajorityGPT(int[] arr) {
        int count = 0;
        Integer candidate = null;

        // First pass: Find a potential majority candidate
        for (int num : arr) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        // Second pass: Verify the candidate (optional if majority is guaranteed)
        count = 0;
        for (int num : arr) {
            if (num == candidate) {
                count++;
            }
        }

        return (count > arr.length / 2) ? candidate : -1;
    }

}
