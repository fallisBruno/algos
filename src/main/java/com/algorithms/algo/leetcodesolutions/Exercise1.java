package com.algorithms.algo.leetcodesolutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

//Write a function that implements linear search. Given an array of integers and a target integer,
//return the index of the target if found, otherwise return -1.
public class Exercise1 {

    public static void main(String[] args) throws IllegalArgumentException {

        List<Integer> testInput1 = new ArrayList<>(Arrays.asList(3, 5, 2, 9, 4));

        System.out.println(getIndexStream(testInput1, 9));

        List<Integer> testInput2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        System.out.println(getIndexStream(testInput1, 6));
    }

    public static Integer getIndex(List<Integer> arr, Integer target) throws IllegalArgumentException {
        if(arr == null) throw new IllegalArgumentException("Input array cannot be null.");
        if(target == null ) throw new IllegalArgumentException("Target cannot be null.");

        for (int i = 0; i < arr.size(); i++) {
            if(arr.get(i).equals(target)) return i;
        }
        return -1;
    }

    public static Integer getIndexStream(List<Integer> arr, Integer target) {
        return IntStream.range(0, arr.size())
                .filter(i -> arr.get(i).equals(target))
                .findFirst()
                .orElse(-1);
    }

}
