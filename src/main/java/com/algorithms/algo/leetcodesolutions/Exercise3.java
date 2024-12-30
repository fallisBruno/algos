package com.algorithms.algo.leetcodesolutions;

public class Exercise3 {

    public static void main(String[] args) {
        System.out.println(reverse("hello"));
        System.out.println(reverse("h"));
        System.out.println(reverse(""));
    }

    public static String reverse(String input){
        if(input == null || input.isBlank()) throw new IllegalArgumentException("Input cannot be null or empty.");

        if(input.length() == 1) return input;

        StringBuilder reversed = new StringBuilder();
        for (int i = input.length() - 1; i >= 0 ; i--) {
            reversed.append(input.charAt(i));
        }
        return reversed.toString();
    }

}
