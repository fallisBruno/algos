package com.algorithms.algo.solutions.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] arrays = {{1, 4}, {0, 0}, {6, 8}};
        for (int[] arr : mergeIII(arrays))
            System.out.println(Arrays.toString(arr));
    }

    //the solution might be sort the array or getting all the values without [] then sorting then and creating
    //a new array with the sorted, but the overlapping rules should be applied when the difference between
    //the next number is > 1
    public static int[][] mergeIII(int[][] intervals) {
        if (intervals.length == 1) return intervals;

        int[] auxArr = new int[intervals.length * 2];
        for (int i = 0; i < intervals.length; i++) {
            auxArr[i] = intervals[i][0];
            auxArr[i + 1] = intervals[i][1];
            ++i;
        }

        Arrays.sort(auxArr);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i < auxArr.length; i++) {
            List<Integer> combination = new ArrayList<>();
            combination.add(auxArr[i - 1]);
            if (Math.abs(auxArr[i] - auxArr[i + 1]) <= 1) {
                while (i < auxArr.length - 1 && Math.abs(auxArr[i] - auxArr[i + 1]) <= 1) {
                    i += 2;
                }
            } else {
                ++i;
            }
            combination.add(auxArr[i]);
            result.add(combination);
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
