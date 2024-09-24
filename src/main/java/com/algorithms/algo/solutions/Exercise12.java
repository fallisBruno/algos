package com.algorithms.algo.solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Exercise12 {

    public static void main(String[] args) {
        System.out.println(findSingleNumber(new int []{-1,-1,-2}));
    }

    //it solves the problem fast, but is O(N) in space complexity
    //it means that I'm using unnecessary extra space :s
    public static int findSingleNumber(int[] nums){
        if(nums.length <= 1) return nums[0];

        Map<Integer, Integer> resultMap = new HashMap<>();

        for (int num : nums) {
            resultMap.put(num, resultMap.getOrDefault(num, 0) + 1);
        }

        Set<Map.Entry<Integer, Integer>> entries = resultMap.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if(entry.getValue() == 1) return entry.getKey();
        }

        return -1;
    }

}
