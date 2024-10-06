package com.algorithms.algo.solutions.medium;


//Both Solution I and II are mine and I'm really proud of that :)
public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverseIntegerII(321));
    }

    public static int reverseIntegerI(int x){
        boolean isNegative = x < 0;
        StringBuilder aux = new StringBuilder();
        x = Math.abs(x);
        while(x > 0){
            int soloNum = x % 10;
            aux.append(soloNum);
            x = x / 10;
        }
        if(aux.isEmpty()) return 0;
        long resultDouble = Long.parseLong(aux.toString());
        if(resultDouble < Integer.MIN_VALUE || resultDouble > Integer.MAX_VALUE) return 0;
        int result = Integer.parseInt(aux.toString());
        return isNegative ? result - (result * 2) : result;
    }

    public static int reverseIntegerII(int x){
        boolean isNegative = x < 0;
        x = Math.abs(x);
        long product = 0;
        long factor = (long) Math.pow(10, String.valueOf(x).length() - 1);
        while(x > 0){
            int lastNumber = x % 10;
            product += lastNumber * factor;
            if(product > Integer.MAX_VALUE) return 0;
            factor = factor / 10;
            x = x / 10;
        }
        int result = Math.toIntExact(product);
        return isNegative ? result - (result * 2) : result;
    }

}
