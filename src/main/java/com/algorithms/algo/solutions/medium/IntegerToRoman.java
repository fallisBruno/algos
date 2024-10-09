package com.algorithms.algo.solutions.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class IntegerToRoman {

    public static void main(String[] args) {
/*        String biggestRomanNumber = "";
        for (int i = 0; i < 4000; i++) {
            System.out.println(i);
            String roman = convert(i);
            if(roman.length() > biggestRomanNumber.length())
                biggestRomanNumber = roman;
        }
        System.out.println(biggestRomanNumber);
        System.out.println("MMMDCCCLXXXVIII".length());*/

        System.out.println(convert(3));
    }

    //My solution, it solves the problem, but isn't the fastest solution
    public static String convert(int num){
        Map<Integer, String> romanMap = new HashMap<>();
        romanMap.put(1, "I");
        romanMap.put(4, "IV");
        romanMap.put(5, "V");
        romanMap.put(9, "IX");
        romanMap.put(10, "X");

        romanMap.put(40, "XL");
        romanMap.put(50, "L");
        romanMap.put(90, "XC");
        romanMap.put(100, "C");

        romanMap.put(400, "CD");
        romanMap.put(500, "D");
        romanMap.put(900, "CM");
        romanMap.put(1000, "M");

        String[] result = new String[15];
        int factor = 1, insertionIndex = 14;
        while(num > 0){
            int rest = num % 10;

            String romanString = romanMap.get(rest * factor);
            if(Objects.nonNull(romanString)){
                result[insertionIndex--] = romanString;
            }else{
                String repSymbol = romanMap.get(factor);
                for (int index = 0; index < (rest > 5 ? rest - 5 : rest); index++) {
                    result[insertionIndex--] = repSymbol;
                }
                if(rest >= 5) result[insertionIndex--] = romanMap.get(5*factor);
            }

            factor = factor*10;
            num = num / 10;
        }

        StringBuilder resultString = new StringBuilder();
        for (String str : result) {
            if (str != null)
                resultString.append(str);
        }
        return resultString.toString();
    }

    //This is the best solution, but isn't MINE, it's LeetCode and GPT
    public String intToRoman(int num) {
        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder roman=new StringBuilder();
        for(int i=0;i<value.length;i++){
            while(num>=value[i]){
                roman.append(symbol[i]);
                num-=value[i];
            }
        }
        return roman.toString();
    }

}
