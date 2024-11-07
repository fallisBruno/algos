package com.algorithms.algo.solutions.medium;

public class MaximumProductSubarray {

    public static void main(String[] args) {
/*        System.out.println(maxProduct(new int[]{2,3,-2,4}));
        System.out.println(maxProduct(new int[]{7,-2,-4}));
        System.out.println(maxProduct(new int[]{2,-5,-2,-4,3}));
        System.out.println(maxProduct(new int[]{-2,0,-1}));*/


        System.out.println(maxProductI(new int[]{10,-2,-2}));
    }

    public static int maxProductI(int[] nums){
        if(nums.length == 1) return nums[0];

        int product = Integer.MIN_VALUE, cumulative = 1;

        for (int i = 0; i < nums.length; i++) {
            cumulative *= nums[i];
            product = Math.max(cumulative, product);
            if(cumulative == 0) cumulative = 1;
            else if(cumulative < 0){
                int cumulativeAux = 1;
                int indexAux = i + 1;
                while(indexAux < nums.length && nums[indexAux] > 0){
                    cumulativeAux *= nums[indexAux];
                    indexAux++;
                    product = Math.max(cumulativeAux, product);
                }
                if(indexAux >= nums.length) return product;
                if(nums[indexAux] == 0) cumulative = 1;
                else {
                    cumulative *= nums[i] * nums[indexAux] * cumulativeAux;
                    product = Math.max(cumulative, product);
                }
            }
        }

        return product;
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
