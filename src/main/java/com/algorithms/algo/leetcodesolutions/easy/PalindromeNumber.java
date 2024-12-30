package com.algorithms.algo.leetcodesolutions.easy;

public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x){
        if(x <= 0) return false;
        int reversedNum = 0, inputAux = x;
        while (inputAux != 0) {
            reversedNum = reversedNum * 10 + inputAux % 10;
            inputAux = inputAux / 10;
        }
        return reversedNum == x;
    }

}
