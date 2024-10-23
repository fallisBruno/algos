package com.algorithms.algo.solutions.medium;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] input = new String[]{"eat","tea","tan","ate","nat","bat"};
        List<List<String>> group = group(input);
        for (List<String> l : group){
            System.out.println(l);
        }
    }

    public static List<List<String>> group(String[] strs){
        Map<String, List<String>> wordMap = new HashMap<>();
        for (String s : strs){
            char[] sorted = s.toCharArray();
            Arrays.sort(sorted);
            String sortedString = new String(sorted);
            if(wordMap.containsKey(sortedString)){
                List<String> strings = wordMap.get(sortedString);
                strings.add(s);
                wordMap.put(sortedString, strings);
            }else{
                List<String> strings = new ArrayList<>();
                strings.add(s);
                wordMap.put(sortedString, strings);
            }
        }

        return wordMap.values().stream().toList();
    }

}
