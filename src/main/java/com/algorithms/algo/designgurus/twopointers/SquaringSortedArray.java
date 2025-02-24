package com.algorithms.algo.designgurus.twopointers;

public class SquaringSortedArray {

    public static void main(String[] args) {

    }

    public static int[] makeSquares(int[] arr) {
        int n = arr.length;
        int[] squares = new int[n];

        int lastBigger = 0;
        squares[0] = Math.abs(arr[0] * arr[0]);
        for (int i = 1; i < arr.length; i++) {
            int square = Math.abs(arr[i] * arr[i]);
            if(square > arr[lastBigger]){
                arr[i]
                lastBigger = i;
            }
        }

        return squares;
    }

}
