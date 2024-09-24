package com.algorithms.algo.solutions;

import java.util.Arrays;

public class Exercise10 {

    public static void main(String[] args) {
        //calculateProductIV(new int[]{1,2,3,4});
        calculateProductIV(new int[]{-1,1,0,-3,3});
    }

    //Velloso solution
    public static int[] calculateProductIV(int[] nums){
        int[] result = new int[nums.length];

        // Left Pass: Calculate the cumulative product of elements to the left of each index
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = nums[i - 1] * result[i - 1];
        }

        // Right Pass: Calculate the cumulative product of elements to the right of each index
        // and multiply it directly into the result array
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * right;
            right = right * nums[i];  // Update the right cumulative product
        }

        return result;
    }

    //This one below solves the problem, but is O(n*n)
    public static int[] calculateProductII(int[] nums){
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if(i == j) continue;
                product *= nums[j];
            }
            result[i] = product;
        }

        return result;
    }

    //this solution solves the problem, but it's using division
    public static int[] calculateProductI(int[] nums){
        int[] result = new int[nums.length];
        int product = 1;
        int zeros = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(num == 0) {
                zeros++;
                continue;
            };
            product *= nums[i];
        }

        if(zeros > 1) {
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(num == 0){
                result[i] = product;
            }else{
                result[i] = zeros > 0 ? 0 : product / num;
            }
        }

        return result;
    }

}
