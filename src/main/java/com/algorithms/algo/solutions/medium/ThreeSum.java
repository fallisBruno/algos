package com.algorithms.algo.solutions.medium;

import java.lang.reflect.Array;
import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(threeSum(new int[]{1,2,-2,-1}).toArray()));
    }

    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        int start = 0;
        int end = nums.length - 1;
        boolean hasZero = Arrays.toString(nums).contains("0");
        Set<String> duplicateControl = new HashSet<>();
        while(start < end){
            //-2 = 2-(-4)
            int sub = nums[end] + nums[start];
            boolean walkInBoth = false;
            System.out.println(sub + " = " + nums[end] + " - " + nums[start]);
            List<Integer> triple = null;
            if(sub < 0){
                if(nums[end - 1] + sub == 0){
                    triple = Arrays.asList(nums[end],nums[start],nums[end - 1]);
                    walkInBoth = true;
                }else{
                    start++;
                }
            }else if(sub > 0){
                if(nums[start + 1] + sub == 0){
                    triple = Arrays.asList(nums[end],nums[start],nums[start + 1]);
                    walkInBoth = true;
                }else{
                    end--;
                }
            }else if(hasZero){
                triple = Arrays.asList(nums[end],nums[start],0);
                walkInBoth = true;
            }
            if(walkInBoth || (sub == 0 && !hasZero)){
                start++;
                end--;
            }
            if(triple != null){
                String string = Arrays.toString(triple.toArray());
                if(duplicateControl.contains(string)) continue;
                result.add(triple);
                duplicateControl.add(string);
            }
        }

        return result;
    }

}