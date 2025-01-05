package com.algorithms.algo.leetcodesolutions.easy;

public class Sqrt {

    public static void main(String[] args) {
        System.out.println(mySqrt(1));
    }

    public static int mySqrt(int x) {
        if(x <= 1) return x;
        int result = 0;
        for (int i = 0; i < x; i++) {
            if(i * i > x) {
                result = i - 1;
                break;
            }
        }
        return result == 0 ? 1 : result;
    }

}
