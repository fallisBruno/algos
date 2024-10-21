package com.algorithms.algo.solutions.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] arrays = {{1, 4}, {0, 4}};
        for (int[] arr : merge(arrays))
            System.out.println(Arrays.toString(arr));
    }

    public static int[][] merge(int[][] intervals){
        List<List<Integer>> auxArray = new ArrayList<>();

        int i = 0;
        int inputLen = intervals.length;
        while(i < inputLen) {
            int first = intervals[i][0];
            int last = intervals[i][1];
            if(i < inputLen - 1){
                int nextFirst = intervals[i+1][0];
                int nextLast = intervals[i+1][1];
                if(first < nextLast && last < nextFirst){
                    auxArray.add(Arrays.asList(first, last));
                }else if(first > nextLast){
                    auxArray.add(Arrays.asList(nextFirst, nextLast));
                    auxArray.add(Arrays.asList(first, last));
                    i++;
                }else if(last >= nextFirst || first == nextFirst){
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
