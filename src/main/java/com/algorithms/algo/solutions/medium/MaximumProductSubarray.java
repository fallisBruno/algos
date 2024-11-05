package com.algorithms.algo.solutions.medium;

public class MaximumProductSubarray {

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2,3,-2,4}));
        System.out.println(maxProduct(new int[]{7,-2,-4}));
        System.out.println(maxProduct(new int[]{7,-2,-4}));
    }

    public static int maxProduct(int[] nums){
        if(nums.length == 1) return nums[0];

        int largestProduct = Integer.MIN_VALUE;
        int max = 1;
        int index = 0;

        while(index < nums.length){
            if(nums[index] <= 0){
                int firstNegative = index;
                int maxAux = 1;
                ++index;
                while(index < nums.length && nums[index] > 0){
                    maxAux *= nums[index];
                    largestProduct = Math.max(maxAux, largestProduct);
                    index++;
                }
                if(index >= nums.length) return largestProduct;
                if(nums[index] < 0){
                    max *= nums[index] * nums[firstNegative] * maxAux;
                    largestProduct = Math.max(max, largestProduct);
                }else{
                    largestProduct = Math.max(0, largestProduct);
                    max = 1;
                }
            }else{
                max *= nums[index];
                largestProduct = Math.max(max, largestProduct);
            }
            index++;
        }

        return largestProduct;
    }

}
