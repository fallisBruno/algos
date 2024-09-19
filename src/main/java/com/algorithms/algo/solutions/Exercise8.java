package com.algorithms.algo.solutions;

import java.util.Arrays;

public class Exercise8 {

    public static void main(String[] args) {
        moveZerosI(new int[]{0, 1, 0, 3, 12});
        moveZerosII(new int[]{0, 1, 0, 3, 12});
    }

    //I did the code below, but at some point I had ChatGPT to solve something that I wasn't getting
    //still happy that I was able to think about a very close solution :)
    public static void moveZerosII(int[] nums){
        int zeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                nums[zeroIndex] = nums[i];
                zeroIndex++;
            }
        }

        for (int i = zeroIndex; i < nums.length ; i++) {
            nums[i] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }

    //This one is Big O(n*n), too slow
    public static void moveZerosI(int[] nums){
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int currentNumber = nums[i];
            if(currentNumber == 0){
                for (int j = i; j < length - 1; j++) {
                    nums[j] = nums[j+1];
                }
                nums[length - 1] = currentNumber;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

}
