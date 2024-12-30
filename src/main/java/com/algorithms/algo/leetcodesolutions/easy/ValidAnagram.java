package com.algorithms.algo.leetcodesolutions.easy;

public class ValidAnagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("rat", "car"));
    }

    //It solves the problem, but it's possible to calculate at line 16:
    //Instead of "letters[s.charAt(i)]++", I could have use "letters[s.charAt(i) - 'a']++"
    //so the letters char array can be shorter new int[23];
    public static boolean isAnagram(String s, String t){
        if(t.length() != s.length()) return false;
        int[] letters = new int[123];
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i)]++;
        }
        for (int i = 0; i < t.length(); i++) {
            letters[t.charAt(i)]--;
        }
        for (int letterCount : letters) {
            if (letterCount > 0) return false;
        }
        return true;
    }

}
