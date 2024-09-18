package com.algorithms.algo.solutions;

import java.util.*;

public class Exercise6 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4})));
    }

    public static int[] removeDuplicates(int[] nums){
        Set<Integer> controlSet = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            if (!controlSet.contains(num)) {
                result.add(num);
            }
            controlSet.add(num);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    /* ChatGPT solution, I misunderstood the problem :s
       I FORGOT THAT THE ARRAY IS ALREADY SORTED
    *
    *       public static int removeDuplicates(int[] nums) {
            if (nums.length == 0) return 0;

            int j = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[j]) {
                    j++;
                    nums[j] = nums[i];
                }
            }
            return j + 1;
        }
    * */

}
