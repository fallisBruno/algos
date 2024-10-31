package com.algorithms.algo.solutions.medium;

import java.util.*;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] arrays = {{1, 3}, {2, 4}};
        for (int[] arr : mergeIV(arrays))
            System.out.println(Arrays.toString(arr));
    }

    //I wasn't able to solve this problem, but I saw the solution and learned it :)
    //and here it's the solution:
    public static int[][] mergeV(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> merged = new ArrayList<>();
        int[] prev = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], interval[1]);
            } else {
                merged.add(prev);
                prev = interval;
            }
        }

        merged.add(prev);

        return merged.toArray(new int[merged.size()][]);
    }

    public static int[][] mergeIV(int[][] intervals) {
        if (intervals.length == 1) return intervals;

        int newLength = 0;
        for (int i = 0; i < intervals.length - 1; i++) {
            int first = intervals[i][0];
            int second = intervals[i][1];
            int nextFirst = intervals[i + 1][0];
            int nextSecond = intervals[i + 1][1];
            if(first < nextFirst && first < nextSecond && second < nextFirst && second < nextSecond){
                continue;
            }else{
                if(first > nextFirst && first > nextSecond){
                }
            }
        }

        return intervals;
    }

    //the solution might be sort the array or getting all the values without [] then sorting then and creating
    //a new array with the sorted, but the overlapping rules should be applied when the difference between
    //the next number is > 1
    public static int[][] mergeIII(int[][] intervals) {
        if (intervals.length == 1) return intervals;

        List<Integer> auxArr = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            auxArr.add(intervals[i][0]);
            auxArr.add(intervals[i][1]);
        }

        Collections.sort(auxArr);

        List<List<Integer>> result = new ArrayList<>();
        int index = 1;
        while(index <= auxArr.size()){
            List<Integer> combination = new ArrayList<>();
            combination.add(auxArr.get(index - 1));
            if(!Objects.equals(auxArr.get(index - 1), auxArr.get(index))){
                while (index < auxArr.size() - 1 && Math.abs(auxArr.get(index) - auxArr.get(index + 1)) <= 1) {
                    index += 2;
                }
            }else{
                index += 2;
            }
            combination.add(auxArr.get(index));
            result.add(combination);
            index+=2;
        }

        return result.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }

    public static int[][] mergeII(int[][] intervals) {
        if (intervals.length == 1) return intervals;

        List<List<Integer>> auxArray = new ArrayList<>();
        int index = 0;
        int inputLen = intervals.length;
        while (index < inputLen) {
            int first = intervals[index][0];
            int last = intervals[index][1];
            if (index < inputLen - 1) {
                int nextFirst = intervals[index + 1][0];
                int nextLast = intervals[index + 1][1];
                if (first > nextFirst && first > nextLast) {
                    auxArray.add(Arrays.asList(nextFirst, nextLast));
                    auxArray.add(Arrays.asList(first, last));
                    index++;
                } else if (first < nextFirst && last >= nextFirst) {
                    auxArray.add(Arrays.asList(first, Math.max(last, nextLast)));
                    index++;
                } else if (first >= nextFirst && last >= nextLast) {
                    auxArray.add(Arrays.asList(nextFirst, last));
                    index++;
                } else if (first < nextFirst && last < nextLast) {
                    auxArray.add(Arrays.asList(first, last));
                }
            } else {
                auxArray.add(Arrays.asList(first, last));
            }
            index++;
        }

        int[][] result = new int[auxArray.size()][2];

        for (int j = 0; j < auxArray.size(); j++) {
            result[j][0] = auxArray.get(j).get(0);
            result[j][1] = auxArray.get(j).get(1);
        }

        return result;
    }

    public static int[][] merge(int[][] intervals) {
        List<List<Integer>> auxArray = new ArrayList<>();

        int i = 0;
        int inputLen = intervals.length;
        while (i < inputLen) {
            int first = intervals[i][0];
            int last = intervals[i][1];
            if (i < inputLen - 1) {
                int nextFirst = intervals[i + 1][0];
                int nextLast = intervals[i + 1][1];
                if (first < nextLast && last < nextFirst) {
                    auxArray.add(Arrays.asList(first, last));
                } else if (first > nextLast) {
                    auxArray.add(Arrays.asList(nextFirst, nextLast));
                    auxArray.add(Arrays.asList(first, last));
                    i++;
                } else if (last >= nextFirst || first == nextFirst) {
                    auxArray.add(Arrays.asList(first, nextLast));
                    i++;
                }
            }
            i++;
        }

        int[][] result = new int[auxArray.size()][2];

        for (int j = 0; j < auxArray.size(); j++) {
            result[j][0] = auxArray.get(j).get(0);
            result[j][1] = auxArray.get(j).get(1);
        }

        return result;
    }

}
