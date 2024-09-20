package com.algorithms.algo.solutions;

import java.util.HashSet;
import java.util.Set;

public class Exercise9 {

    public static void main(String[] args) {
        lengthOfLongestSubstring("abcabcbb");
        longestSubstringI("bbbbb");
        longestSubstringI("pwwkew");
        longestSubstringI("aab");
        longestSubstringI("dvdf");
    }

    //ChatGPT solution, my solution is longestSubstringI and I'm proud of that because it's working,
    //yet slow, but working :)
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> controlSet = new HashSet<>();
        int left = 0, result = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If we encounter a duplicate, slide the left pointer
            while (controlSet.contains(currentChar)) {
                controlSet.remove(s.charAt(left));
                left++;
            }

            // Add the current character to the set
            controlSet.add(currentChar);

            // Update the maximum length of substring
            result = Math.max(result, right - left + 1);
        }

        return result;
    }


    public static int longestSubstringI(String s){
        if(s.length() == 0) return 0;
        if(s.length() == 1) return 1;

        String[] stringArr = s.split("");
        Set<String> controlSet = new HashSet<>();
        int result = 0, count = 0, auxIndex = 0;
        for (int i = 0; i < stringArr.length; i++) {
            if(controlSet.contains(stringArr[i])){
                count = 0;
                i = ++auxIndex;
                controlSet.clear();
            }
            count++;
            controlSet.add(stringArr[i]);
            if(count > result) result = count;
        }

        return result;
    }

}
