package com.algorithms.algo.leetcodesolutions;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        System.out.println(calculate(new int[]{8,7,2,1}));
    }

    //ChatGPT gave me the formula Math.min(currentStart, currentEnd) * (end - start)
    //but I was only asking to understand some part of the example, anyways, here's the formula explanation:
    //(end - start) calculates the container's width and Math.min(currentStart, currentEnd)
    //brings the shorter height.
    public static int calculate(int[] height){
        int start = 0, end = height.length - 1, result = 0;
        while(start < end){
            int currentStart = height[start];
            int currentEnd = height[end];
            int currentArea = Math.min(currentStart, currentEnd) * (end - start);
            if(currentArea > result) result = currentArea;
            if(currentStart > currentEnd)
                end--;
            else if(currentEnd > currentStart)
                start++;
            else{
                start++;
                end--;
            }
        }
        return result;
    }

}
