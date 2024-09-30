package com.algorithms.algo.solutions;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(findII("abb"));
    }

    public static String find(String s){
        StringBuilder sb = new StringBuilder();
        String result = "";
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            sb.append(currentChar);

            do{
                left++;
                if(left == s.length()){
                    left = right;
                    break;
                }
                currentChar = s.charAt(left);
                sb.append(currentChar);

            }while ((sb.charAt(0) != currentChar));

            String currentString = sb.toString();
            if(sb.reverse().toString().equals(currentString) && currentString.length() > result.length()){
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
    public static String findII(String s){
        StringBuilder aux = new StringBuilder();
        String result = String.valueOf(s.charAt(0));
        int left = 0, right = s.length() - 1;
        while (left <= right){
            while(s.charAt(left) == s.charAt(right)){
                aux.append(s.charAt(left));
                if(aux.toString().length() > result.length()){
                    result = aux.toString();
                    if(left >= s.length() - 1 || right <= 0)
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

}
