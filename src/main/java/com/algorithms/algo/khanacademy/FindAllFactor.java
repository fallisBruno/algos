package com.algorithms.algo.khanacademy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllFactor {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getFactors(42).toArray()));
    }

    public static List<Integer> getFactors(int n){
        List<Integer> result = new ArrayList<>();
        for (int testFactor = 1;testFactor < n;testFactor++){
            if(n % testFactor == 0) result.add(testFactor);
        }
        return result;
    }

}
