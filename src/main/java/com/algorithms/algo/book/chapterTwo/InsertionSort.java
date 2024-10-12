package com.algorithms.algo.book.chapterTwo;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(insertionSort(new int[]{4,3,2,7,1})));
    }

    public static int[] insertionSort(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i - 1;
            while(j >= 0 && nums[j] > key){
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
        return nums;
    }

    //Solves exercise 2.1-3
    public static int[] insertionSortReverse(int[] nums){
        for (int i = nums.length - 2; i >= 0; i--) {
            int key = nums[i];
            int j = i + 1;
            while(j < nums.length && nums[j] > key){
                nums[j - 1] = nums[j];
                j++;
            }
            nums[j - 1] = key;
        }
        return nums;
    }

}
