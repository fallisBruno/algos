package com.algorithms.algo.leetcodesolutions;

public class Exercise13 {

    public static void main(String[] args) {
        System.out.println(findPeakElementIII(new int[]{1,3,2,1}));
    }

    //First solution, this isn't O(log N) and doesn't solve the problem
    public static int findPeakElement(int[] nums){
        for (int i = 1; i < nums.length - 1; i++) {
            int currentNumber = nums[i];
            int previousNumber = nums[i-1];
            int nextNumber = nums[i+1];
            if(currentNumber > previousNumber && currentNumber > nextNumber)
                return i;
        }
        return -1;
    }

    //solves the problem, buuuut isn't O(log n)
    public static int findPeakElementII(int[] nums){
        if(nums.length == 1) return 0;
        boolean biggerThanPrevious = true;
        boolean biggerThanNext;
        for (int i = 0; i < nums.length - 1; i++) {
            int nextNumber = nums[i+1];
            biggerThanNext = nums[i] > nextNumber;
            if(biggerThanPrevious && biggerThanNext)
                return i;
        }
        return nums.length-1;
    }

    //it works, took almost my entire day to figure this solution,
    // but it works ,and I learned a lot about binary search
    public static int findPeakElementIII(int[] nums) {
        int low = 0, high = nums.length - 1;

        do{
            int mid = low + (high - low) / 2;
            int currentNumber = nums[mid];

            boolean isRightNumberLess = mid + 1 >= nums.length || nums[mid + 1] < currentNumber;
            boolean isLeftNumberLess = mid - 1 < 0 || nums[mid - 1] < currentNumber;

            if(isRightNumberLess && isLeftNumberLess) return mid;

            if(currentNumber < nums[mid + 1])
                low = mid + 1;
            else
                high = mid - 1;
        }while (low <= high);

        return 0;
    }



}
