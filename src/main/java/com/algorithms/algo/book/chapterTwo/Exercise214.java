package com.algorithms.algo.book.chapterTwo;

public class Exercise214 {

    public static void main(String[] args) {
        System.out.println(findNumber(new int[]{1,3,4,5,8}, 4));
        System.out.println(findNumber(new int[]{1,3,4,5,8}, 10));
    }

    //loop invariant: ChatGPT provided the answers, and I need to think more about the concept and not so technical.
    public static Integer findNumber(int[] nums, int numberToBeFound){
        //Initialization (before the first iteration): When the loop starts (i.e., i = 0),
        // no elements have been checked yet. The subarray nums[0...i-1] is empty, so the invariant holds trivially.

        //Maintenance (during each iteration): At each step,
        // the loop checks if nums[i] == numberToBeFound. If it's true, the function returns i, t
        // erminating the search. Otherwise, the invariant ensures that numberToBeFound is not present in the subarray nums[0...i].
        // The next iteration increments i, and the invariant holds for the updated subarray nums[0...i-1].
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == numberToBeFound)
                return i;
        }
        //Termination (after the loop): If the loop finishes without finding numberToBeFound,
        // the invariant ensures that numberToBeFound is not present in any part of the array nums.
        // In this case, the function returns null, indicating the element was not found.
        return null;
    }

}
