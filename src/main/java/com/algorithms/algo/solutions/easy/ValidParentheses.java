package com.algorithms.algo.solutions.easy;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValidII("(([]){})"));
    }

    //0 1 2 3 4 5 6 7
    //( ( ( ( ) ) ) )
    //8 9 10 11
    //[ {  }  ]
    //the code below doesn't solve the problem, buuut is a nice try :)
    public static boolean isValidII(String s) {
        if (s.length() % 2 != 0) return false;
        int countOpened = 0;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
                countOpened++;
            } else if (countOpened == 0) {
                return false;
            } else {
                int lastOpen = i - 1;
                while (countOpened > 0) {
                    if (s.charAt(i) == ')') {
                        if (s.charAt(lastOpen) != '(') {
                            return false;
                        }
                    } else if (s.charAt(i) == '}') {
                        if (s.charAt(lastOpen) != '{') {
                            return false;
                        }
                    } else if (s.charAt(i) == ']') {
                        if (s.charAt(lastOpen) != '[') {
                            return false;
                        }
                    } else {
                        return false;
                    }

                    lastOpen--;
                    countOpened--;
                    if (countOpened == 0) break;
                    if (i + 1 >= s.length())
                        return false;
                    else i++;
                }
            }
        }
        return !(countOpened > 0);
    }

    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        Stack<String> pile = new Stack<>();
        for (String ch : s.split("")) {
            if (ch.equals("(") || ch.equals("{") || ch.equals("[")) {
                pile.push(ch);
            } else if (pile.isEmpty()) {
                return false;
            } else {
                String pop = pile.pop();
                String closeSign = pop.equals("(") ? ")" : pop.equals("{") ? "}" : "]";
                if (!closeSign.equals(ch)) return false;
            }
        }
        return pile.isEmpty();
    }

}
