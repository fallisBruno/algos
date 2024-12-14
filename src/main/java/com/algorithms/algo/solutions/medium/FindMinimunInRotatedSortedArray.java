package com.algorithms.algo.solutions.medium;

public class FindMinimunInRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(1/2);
    }

    public static int findMin(int[] nums){

        int inicio = 0;
        int fim = nums.length - 1;

        while (inicio <= fim) {
            int meio = inicio + (fim - inicio) / 2; // Evita overflow

            // Verifica se o elemento está no meio
            if (nums[meio] > nums[meio+1]) {
                return nums[meio+1]; // Retorna o índice do elemento
            }

            // Decide se continua na metade direita ou esquerda
            if (nums[meio] < nums[meio+1]) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        return -1;
    }

}
