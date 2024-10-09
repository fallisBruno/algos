package com.algorithms.algo.utils;

public class NumbersUtils {

    public static boolean isBiggerThanSignedInt(long n){
        return n < Integer.MIN_VALUE || n > Integer.MAX_VALUE;
    }

}
