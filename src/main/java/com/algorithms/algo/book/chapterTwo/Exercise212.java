package com.algorithms.algo.book.chapterTwo;

import org.springframework.util.StopWatch;

//Solves exercise 2.1-2
public class Exercise212 {

    public static void main(String[] args) {

        int[] array = new int[10000000];

        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        System.out.println(sumArray(array));
        System.out.println(sumArrayII(array));
    }

    public static int sumArrayII(int[] nums){
        StopWatch watch = new StopWatch();
        watch.start();
        int sum = 0;
        for(int n : nums)
            sum += n;

        watch.stop();
        System.out.println("sumArrayII:" + watch.getTotalTimeMillis());
        return sum;
    }

    public static int sumArray(int[] nums) {
        StopWatch watch = new StopWatch();
        watch.start();

        int left = 0;
        int right = nums.length - 1;
        int sum = 0;
        while(left < right){
            sum+=nums[left] + nums[right];
            left++;
            right--;
        }

        if (left == right) { // Handle the middle element in case of odd-sized array
            sum += nums[left];
        }

        watch.stop();
        System.out.println("sumArray:" + watch.getTotalTimeMillis());

        return sum;
    }

}
