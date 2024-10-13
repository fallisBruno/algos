package com.algorithms.algo.book.chapterTwo;

import java.util.Arrays;

public class Exercise215 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(addBinaryIntegers(new int[]{1, 0, 1}, new int[]{1, 0, 1})));
    }

    public static int[] addBinaryIntegers(int[] numsA, int[] numsB){
        int[] resultC = new int[numsA.length + 1];
        int carry = 0;
        for (int i = 0; i < numsA.length; i++) {
            resultC[i] = (numsA[i] + numsB[i] + carry) % 2;
            if(numsA[i] + numsB[i] >= 2){
                carry = 1;
            }else{
                carry = 0;
            }
        }
        resultC[numsA.length] = carry;
        return resultC;
    }

}
