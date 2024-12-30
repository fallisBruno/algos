package com.algorithms.algo.leetcodesolutions.medium;

import com.algorithms.algo.utils.NumbersUtils;

public class StringToIntegerATOI {

    public static void main(String[] args) {
        System.out.println(myAtoi(" -428c7"));
    }

    public static int myAtoi(String s) {
        long result = 0;
        boolean isNegative = false, hasSignAlready = false;
        for (int index = 0; index < s.length(); index++) {
            int currentChar = s.charAt(index);
            if (currentChar == 32){
                if(hasSignAlready) break;
            }
            else if (currentChar == 45 || currentChar == 43){
                if(hasSignAlready) break;
                isNegative = currentChar == 45;
                hasSignAlready = true;
            }
            else if (currentChar >= 48 && currentChar <= 57){
                while(currentChar >= 48 && currentChar <= 57){
                    result = result * 10 + Character.getNumericValue(currentChar);
                    if(NumbersUtils.isBiggerThanSignedInt(result)){
                        return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                    }
                    ++index;
                    if(index >= s.length()) break;
                    currentChar = s.charAt(index);
                }
                break;
            }else
                break;
        }
        return Math.toIntExact(isNegative ? result * (-1) : result);
    }

}
