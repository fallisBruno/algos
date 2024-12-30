package com.algorithms.algo.leetcodesolutions.blind75.firstweek;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static void main(String[] args) {
        System.out.println(contains(new int[]{1,2,3,4}));
    }

    public static boolean contains(int[] nums){
        Set<Integer> controlSet = new HashSet<>();
        for (int num : nums) {
            if (controlSet.contains(num)) {
                return true;
            }
            controlSet.add(num);
        }
        return false;
    }

}
