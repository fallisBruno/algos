package com.algorithms.algo.solutions;

import java.util.*;

public class Exercise4 {

    public static void main(String[] args) {
        System.out.println(findFirstNonRepeating("aabb"));
    }

    public static int findFirstNonRepeating(String input){
        Map<Character, Integer> controlMap = new HashMap<>();
        Set<Character> appearsMoreThanOnce = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            Character c = input.charAt(i);
            if(controlMap.containsKey(c)){
                appearsMoreThanOnce.add(c);
                controlMap.remove(c);
            }else{
                if(appearsMoreThanOnce.contains(c)){
                    continue;
                }
                controlMap.put(c, i);
            }
        }
        return controlMap.isEmpty() ? -1 : Collections.min(controlMap.entrySet(), Map.Entry.comparingByValue()).getValue();
    }

    /*

    Fastest solution on leetcode.com, isn't mine, but I did debug it and think that's amazing :)

    char[] chars = s.toCharArray();
        int[] alphabet = new int[26];
        for (char c : chars) {
            alphabet[c - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (alphabet[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;

     */

}
