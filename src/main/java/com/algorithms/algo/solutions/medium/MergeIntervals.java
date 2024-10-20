package com.algorithms.algo.solutions.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] arrays = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.toString(merge(arrays)));
    }

    public static int[][] merge(int[][] intervals){
        List<List<Integer>> auxArray = new ArrayList<>();

        int i = 0;
        while(i < intervals.length) {
            int first = intervals[i][0];
            int last = intervals[i][1];
            if(intervals[i][1] >= intervals[i+1][0]){
                while(i < intervals.length - 1 && intervals[i][1] >= intervals[i+1][0]){
                    last = intervals[i+1][1];
                    i++;
                }
            }else i++;
            auxArray.add(Arrays.asList(first, last));
        }

        String string = Arrays.toString(auxArray.toArray());
        System.out.println(string);
        return null;
    }

}
