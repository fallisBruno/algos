package com.algorithms.algo.leetcodesolutions.easy;

import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));

        int[] nums3 = new int[]{0};
        int[] nums4 = new int[]{1};
        merge(nums3, 0, nums4, 1);
        System.out.println(Arrays.toString(nums3));

        int[] nums5 = new int[]{2,0};
        int[] nums6 = new int[]{1};
        merge(nums3, 1, nums4, 1);
        System.out.println(Arrays.toString(nums3));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n){
        if(n == 0)return;
        for (int i = 0; i < n; i++) {
            if(nums1[i] == 0){
                nums1[i] = nums2[i]; continue;
            }
            int j = m - 1;
            while(nums1[j] > nums2[i]){
                nums1[j + 1] = nums1[j];
                j--;
            }
            nums1[j+1] = nums2[i];
            m++;
        }
    }

}
