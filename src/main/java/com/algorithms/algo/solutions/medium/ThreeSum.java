package com.algorithms.algo.solutions.medium;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(threeSumIII(new int[]{-1,0,1}).toArray()));
    }

    public static List<List<Integer>> threeSumIII(int[] nums){
        Map<Integer, TwoSum> controlMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int outerForNum = nums[i];
            for (int j = 0; j < nums.length; j++) {
                if(i == j) continue;
                controlMap.put(outerForNum + nums[j], new TwoSum(i,j));
            }
        }

        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length; i++){
            TwoSum twoSum = controlMap.get(-nums[i]);
            if(twoSum != null && twoSum.firstIdx != i && twoSum.secondIdx != i){
                twoSum.sortByValue(nums);
                if(nums[i] >= nums[twoSum.firstIdx])
                    result.add(Arrays.asList(nums[i], nums[twoSum.firstIdx], nums[twoSum.secondIdx]));
                else if(nums[i] >= nums[twoSum.secondIdx])
                    result.add(Arrays.asList(nums[twoSum.firstIdx], nums[i], nums[twoSum.secondIdx]));
                else
                    result.add(Arrays.asList(nums[twoSum.firstIdx], nums[twoSum.secondIdx], nums[i]));
            }
        }

        return new ArrayList<>(result);
    }

    static class TwoSum{
        int firstIdx;
        int secondIdx;

        TwoSum(int first, int second) {
            firstIdx = first;
            secondIdx = second;
        }

        public void sortByValue(int[] nums) {
            if(nums[firstIdx] >= nums[secondIdx]) return;
            int aux = firstIdx;
            firstIdx = secondIdx;
            secondIdx = aux;
        }
    }

    public static List<List<Integer>> threeSumII(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Set<String> duplicateControl = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int currentNumber = nums[i];
            int left = 0, right = nums.length - 1;
            int sum = currentNumber;
            while (left < right){
                if(left == i) left++;
                if(right == i) right--;

                if(nums[left] + nums[right] + currentNumber == 0){
                    List<Integer> tripple = Arrays.asList(nums[right], nums[left], currentNumber);
                    Collections.sort(tripple);
                    String string = Arrays.toString(tripple.toArray());
                    if(duplicateControl.contains(string)) break;
                    result.add(tripple);
                    duplicateControl.add(string);
                }else{
                    if(Math.abs(nums[left] + sum) <= Math.abs(sum)){
                        sum += nums[left];
                    }else{
                        left++;
                    }

                    if(Math.abs(nums[right] + sum) <= Math.abs(sum)){
                        sum += nums[right];
                    }else{
                        right--;
                    }
                }

            }
        }

        return result;
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
