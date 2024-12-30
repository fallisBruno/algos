package com.algorithms.algo.leetcodesolutions.medium;

public class FindMinimunInRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{5,1,2,3,4}));
    }

    public static int findMin(int[] nums){

        if(nums[0] < nums[nums.length - 1] || nums.length == 1) return nums[0];

        int inicio = 0;
        int fim = nums.length - 1;

        while (inicio <= fim) {
            int meio = inicio + (fim - inicio) / 2; // Evita overflow

            // Verifica se o elemento está no meio
            if (nums[meio] > nums[meio+1]) {
                return nums[meio+1]; // Retorna o índice do elemento
            }else if(nums[meio-1] > nums[meio]){
                return nums[meio];
            }

            // Decide se continua na metade direita ou esquerda
            if (nums[meio] > nums[meio+1]) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        return -1;
    }

}
