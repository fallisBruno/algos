package com.algorithms.algo.solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Exercise12 {

    public static void main(String[] args) {
        System.out.println(findSingleNumberII(new int []{4,1,2,1,2}));
    }

    //ChatGPT solution using XOR, that was amazing, I had to read about XOR again like I was in university
    public static int findSingleNumberII(int[] nums){
        int result = 0;
        for (int num : nums) {
            System.out.println("result=" + Integer.toBinaryString(result));
            System.out.println("num=" + Integer.toBinaryString(num) + "n:" + num);
            System.out.println("operation=" + Integer.toBinaryString(result ^ num));
            System.out.println("non binary=" + (result ^ num));
            System.out.println("---------------------------------------------------------");
            result ^= num;
        }
        return result;
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
