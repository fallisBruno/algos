package com.algorithms.algo.solutions;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("racecar"));
    }

    public static String find(String s) {
        StringBuilder sb = new StringBuilder();
        String result = "";
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            sb.append(currentChar);

            do {
                left++;
                if (left == s.length()) {
                    left = right;
                    break;
                }
                currentChar = s.charAt(left);
                sb.append(currentChar);

            } while ((sb.charAt(0) != currentChar));

            String currentString = sb.toString();
            if (sb.reverse().toString().equals(currentString) && currentString.length() > result.length()) {
                result = currentString;
            }
            sb.setLength(0);
        }
        return result;
    }

    //I need to reverse the string before like:
    // ABB
    // BBA
    // then verify, but this code below is almost there
    public static String findII(String s) {
        StringBuilder aux = new StringBuilder();
        String result = String.valueOf(s.charAt(0));
        int left = 0, right = s.length() - 1;
        while (left < s.length()) {
            while (s.charAt(left) == s.charAt(right)) {
                aux.append(s.charAt(left));
                if (aux.toString().length() > result.length()) {
                    result = aux.toString();
                    if (left >= s.length() - 1 || right <= 0)
                        return result;
                }
                left++;
                right--;
            }
            left++;
            right--;
        }
        return result;
    }

    public static String findIII(String s) {
        int left = 0;
        StringBuilder aux = new StringBuilder();
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            while (currentChar == s.charAt((s.length() - 1) - left)) {
                aux.append(currentChar);
                left++;
                currentChar = s.charAt(left);
            }
            if (aux.length() > result.length()) result = aux.toString();
            aux.setLength(0);
            left++;
            if (left >= s.length()) break;
        }
        return result;
    }

    public static String findIV(String s) {
        int begin = 0, end = 0, max = 0;
        for (int index = 0; index < s.length() - 1; index++) {
            char currentChar = s.charAt(index);
            int lastIndexOf = s.lastIndexOf(currentChar);
            if(lastIndexOf != -1 && lastIndexOf != index){
                int firstIndex = index;
                boolean isDifferent = false;
                int size = (lastIndexOf - firstIndex) + 1;
                if(lastIndexOf - firstIndex > 1){
                    while(firstIndex <= lastIndexOf){
                        if(s.charAt(firstIndex) != s.charAt(lastIndexOf)){
                            isDifferent = true; break;
                        }
                        firstIndex++;
                        lastIndexOf--;
                    }
                }
                if(!isDifferent && size > max){
                    max = size;
                    begin = index;
                    end = s.lastIndexOf(currentChar);
                }
            }
        }
        return s.substring(begin, end+1);
    }


    //ChatGPT solution, I wasn't able to solve the problem, I tried a lot as it shows my previous commits :/
    //, but I learned and I debugged the solution below.
    //NOTES: I focused to much on solving it in O(n) instead of solving the problem first
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            // Check for odd-length palindromes
            int len1 = expandAroundCenter(s, i, i);
            // Check for even-length palindromes
            int len2 = expandAroundCenter(s, i, i + 1);

            int len = Math.max(len1, len2);
            if (len > end - start) {
                System.out.println(len);
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        System.out.println(start + "-" + end);
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            System.out.println("comparing left:" + s.charAt(left) + " to right: " + s.charAt(right));
            left--;
            right++;
        }
        return right - left - 1; // Return the length of the palindrome
    }

}
