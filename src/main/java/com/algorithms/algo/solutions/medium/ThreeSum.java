package com.algorithms.algo.solutions.medium;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(threeSumIV(new int[]{0,0,0}).toArray()));
    }

    //I was not able to provide a faster solution, even that I solved the problem :/
    //Bellow there's Chat GPT's solution
    public static List<List<Integer>> GPTSolution(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);  // Sort the array to make it easier to avoid duplicates

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;  // Skip duplicate numbers to avoid duplicate triplets
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Move the left pointer to avoid duplicates
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // Move the right pointer to avoid duplicates
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;  // Increase the sum by moving the left pointer to the right
                } else {
                    right--;  // Decrease the sum by moving the right pointer to the left
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSumIV(int[] nums){
        Map<Integer, Set<Integer>> controlMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            controlMap.putIfAbsent(nums[i], new HashSet<>());
            controlMap.get(nums[i]).add(i);
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {

            }
        }

        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(i == j)continue;
                int sum = -(nums[i] + nums[j]);
                if(controlMap.containsKey(sum)){
                    if(!controlMap.get(sum).contains(i) && !controlMap.get(sum).contains(j)){
                        List<Integer> list = new ArrayList<>();
                        list.add(sum);list.add(nums[i]);list.add(nums[j]);
                        Collections.sort(list);
                        if(result.contains(list)) continue;
                        result.add(list);
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }

    private static String buildKey(int value, int position) {
        return String.valueOf(value).concat("-").concat(String.valueOf(position));
    }

    //it solves the problem, but takes too much time:
    //308 / 313 testcases passed on LeetCode, at case 308 = Time Limit Exceeded
    public static List<List<Integer>> threeSumIII(int[] nums){
        Map<Integer, List<TwoSumFailed>> controlMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int outerForNum = nums[i];
            for (int j = 0; j < nums.length; j++) {
                if(i == j) continue;
                int key = outerForNum + nums[j];
                TwoSumFailed twoSum = new TwoSumFailed(i, j);
                controlMap.putIfAbsent(key, new ArrayList<>());
                controlMap.get(key).add(twoSum);
            }
        }

        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length; i++){
            List<TwoSumFailed> twoSumList = controlMap.get(-nums[i]);
            if(twoSumList == null) continue;
            for (TwoSumFailed twoSum: twoSumList){
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
        }

        return new ArrayList<>(result);
    }

    static class TwoSumFailed{
        int firstIdx;
        int secondIdx;

        TwoSumFailed(int first, int second) {
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
