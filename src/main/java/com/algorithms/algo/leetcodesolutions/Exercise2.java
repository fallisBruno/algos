package com.algorithms.algo.leetcodesolutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Exercise2 {

    public static void main(String[] args) {
        int[] result = getSumIndexes(new int[]{2,7,11,15}, 9);
        System.out.println(Arrays.toString(result));
    }

    public static int[] getSumIndexes(int[] arr, int target){
        if(arr == null || arr.length == 0) throw new IllegalArgumentException("Input array cannot be null or empty.");

        Map<Integer, Integer> complementMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if(complementMap.containsKey(complement)){
                return new int[]{complementMap.get(complement), i};
            }
            complementMap.put(arr[i], i);
        }
        throw new IllegalArgumentException("No solution found");
    }

}
